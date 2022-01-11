package com.wahyu.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wahyu.dao.RegisterDAO;
import com.wahyu.model.UserLogin;

@Controller
public class RegisterController {
	
	@Autowired
	RegisterDAO dao;
	
	@PostMapping("/proses_edit")
	public ModelAndView proses_edit(@ModelAttribute UserLogin userLogin)
	{
		dao.update(userLogin);
		ModelAndView mv = new ModelAndView("redirect:/list");
		return mv;
	}
	
	@GetMapping(value="/edit_user/{id}")
	public ModelAndView edit_user(@PathVariable int id)
	{
		UserLogin userLogin = dao.get(id);
		ModelAndView mv = new ModelAndView("edit", "userLogin", userLogin);
		return mv;
	}
	
	@PostMapping(value="/delete_user")
	public ModelAndView delete_user(@RequestParam int id)
	{
		dao.delete(id);
		ModelAndView mv = new ModelAndView("redirect:/list");
		return mv;
	}
	
	@GetMapping(value="/list")
	public ModelAndView list_user()
	{
		List<UserLogin> dt = dao.get_all();
		
		ModelAndView mv = new ModelAndView("list", "data_user", dt);
		return mv;
	}

	@RequestMapping(value="/register")
	public ModelAndView register()
	{
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}
		
	@RequestMapping(value="/register2")
	public ModelAndView register2()
	{
		UserLogin u = new UserLogin();
		
		ModelAndView  mv = new ModelAndView("register2", "userLogin", u);
		return mv;
	}
		
	@RequestMapping(value="/proses_register",
		method=RequestMethod.POST)
	public ModelAndView proses_register(
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String text,
			@RequestParam String gender,
			@RequestParam String status
			)
	{
			HashMap<String, String> data =  new HashMap<String, String>();
			data.put("email1", email);
			data.put("password1", password);
			data.put("text1", text);
			data.put("gender1", gender);
			data.put("status1", status);
			ModelAndView mv = new ModelAndView("success", "data", data);
			return mv;
	}
		
	@PostMapping(value="/proses_register2")
	public ModelAndView proses_register2(@ModelAttribute @Valid 
			UserLogin userLogin, BindingResult result) {
			
		//jika hasil validasinya ada yang error
		//maka tampilkan lg halaman registrasinya
		if(result.hasErrors())
		
		//cara menampilkan pesan eror
		//	List<ObjectError> er = result.getAllErrors();
		//	for(ObjectError) e : er)
		//	{
		//		System.out.println(e.getDefaultMessage());
		//	}
			
	{	
		ModelAndView  mv = new ModelAndView("register2", "userLogin", userLogin);
		return mv;
		
	}
			
		dao.add(userLogin);
			
		ModelAndView mv = new ModelAndView("success2", "data", userLogin);
		return mv;
	}
}
