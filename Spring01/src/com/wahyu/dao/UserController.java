package com.wahyu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wahyu.model.UserLogin;

@RestController
public class UserController {

	@Autowired
	RegisterDAO dao;
	
	@GetMapping(value="/user")
	public List<UserLogin> all()
	{
		return dao.get_all();
	}
	
	@PostMapping(value="/user")
	public void add(@RequestBody UserLogin data)
	{
		dao.add(data);
		//return "ok";
	}
	
	@PutMapping(value="/user")
	public boolean edit(@RequestBody UserLogin data)
	{
		dao.update(data);
		return true;
	}
	
	@DeleteMapping(value="/user/{id}")
	public boolean delete(@PathVariable int id)
	{
		dao.delete(id);
		return true;
	}
}
