package com.wahyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// crtl + shift + o
// @Controller
public class WebController {
	
	// http://localhost:8080/
	//Output :"Welcome to my website"
	@RequestMapping(value = "/")
	@ResponseBody
	public String index() {
		return "Welcome to my website";
	}
	//http://localhost:8080/about
	@RequestMapping(value = "/about")
	@ResponseBody
	public String about_us() {
		return "Created by Wahyu";
	}
	
	//http//localthost:8080/product/samsung
	@RequestMapping(value = "/product/samsung")
	@ResponseBody
	public String product() {
		return "Samsung";
	}
	
	//http://localhost:8080/products/samsung
	//Output : Product Samsung
	//http://localhost:8080/products/lenovo
	//Output : Product Lenovo
	//http://localhost:8080/products/asus
	//Output : Product Asus
	@RequestMapping(value = "/products/{brand}")
	@ResponseBody
	public String products2(@PathVariable String brand) {
		if (brand.equals("samsung"))
			return "samsung galaxy, samsung s1";
		else if (brand.equals("lenovo"))
			return "a6000, a7000";
		else
			return "";
	}
	//http://localhost:8080/products/samsung/galaxy
	//http://localhost:8080/products/samsung/s1
	//http://localhost:8080/products/lenovo/a7000
	//http://localhost:8080/products/lenovo/a6000
	@RequestMapping(value = "/products/{brand}/{tipe}")
	@ResponseBody
	public String products3(@PathVariable String brand, 
			@PathVariable String tipe) {
		return "product" + brand + "with tipe" + tipe;
	}
	
	// PR
	// http://localhost:8080/calculator/add/1/3 === 4
	// http://localhost:8080/calculator/subtract/5/3 === 2
	// http://localhost:8080/calculator/multiple/5/3 === 15
	// http://localhost:8080/calculator/divide/9/3 === 3
	
}
