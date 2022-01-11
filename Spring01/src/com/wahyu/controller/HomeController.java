package com.wahyu.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	// http://localhost:8080/
	// output : "Welcome to my website"
	@RequestMapping(value = "/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("Home");
		return mv;
	}

	// http://localhost:8080/about
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("about");
		return mv;
	}

	// http://localhost:8080/product/samsung : Product Samsung
	// http://localhost:8080/product/lenovo : Product Lenovo
	// http://localhost:8080/product/acer : Product Acer
	@RequestMapping(value = "/product/{brand}")
	public ModelAndView product(@PathVariable String brand) {
		ModelAndView mv = new ModelAndView("product", "product", brand);
		return mv;
	}

	// http://localhost:8080/product/samsung/galaxy : Product Samsung Galaxy
	// http://localhost:8080/product/samsung/s1 : Product Samsung Galaxy s1
	// http://localhost:8080/product/Lenovo/a6000 : Product Lenovo a6000
	// http://localhost:8080/product/Lenovo/a7000 : Product Lenovo a7000
	@RequestMapping(value ="/product/{brand}/{tipe}")
	public ModelAndView product_detail(@PathVariable String brand,
			@PathVariable String tipe)
	{
		int m = 5;
		HashMap<String, String> data =  new HashMap<String, String>();
		data.put("a", brand);
		data.put("b", tipe);
		data.put("d", m + "");
		
		ModelAndView x = new ModelAndView("product_detail",
				"c", data);
		return x;
	}

	// PR
	// http://localhost:8080/calculator/add/1/3 === 4
	// http://localhost:8080/calculator/subtract/5/3 === 2
	// http://localhost:8080/calculator/multiple/5/3 === 15
	// http://localhost:8080/calculator/divide/9/3 === 3
	@RequestMapping(value = "/calculator/{operator}/{n1}/{n2}")
		public ModelAndView calculate(@PathVariable String operator, @PathVariable int n1,
				@PathVariable int n2) {
		int result = 0;
		String simbol = "";
		if (operator.equals("add")) {
			result = n1 + n2;
			simbol = "+";
 } else if (operator.equals("subtract")) {
	 		result = n1 - n2;
	 		simbol = "-";
 } else if (operator.equals("multiple")) {
	 		result = n1 * n2;
	 		simbol = "*";
 } else if (operator.equals("divide")) {
	 		result = n1 / n2;
	 		simbol = "/";
 }
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("a1", n1 + "");
		data.put("a2", n2 + "");
		data.put("a3", result + "");
		data.put("a4", simbol + "");
		
		ModelAndView mv = new ModelAndView("result", "dt", data);
		return mv;
}
}