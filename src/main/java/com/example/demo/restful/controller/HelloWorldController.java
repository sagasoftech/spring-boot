package com.example.demo.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restful")
public class HelloWorldController {

	/*
	 * Can replace RequestMapping with more specific method
	 * 
	 * Note: If we add multiple mapping then only first mapping get resolved
	 */
	//@RequestMapping(method = RequestMethod.GET, path = "/")
	@GetMapping(path = "/")
	public String helloWorld() {
		return "Welcome to first Restful endpoint";
	}
}
