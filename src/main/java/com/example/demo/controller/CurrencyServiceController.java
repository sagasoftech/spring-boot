package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.CurrencyServiceConfiguration;

@RestController
@RequestMapping("/demo")
public class CurrencyServiceController {

	@Autowired
	private CurrencyServiceConfiguration configuration;
	
	@RequestMapping("/currency")
	public CurrencyServiceConfiguration retriveAllCourses(){
		return configuration;
	}
}
