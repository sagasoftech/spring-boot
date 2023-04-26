package com.example.demo.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restful.model.Employee;

@RestController
@RequestMapping("/restful")
public class FilteringController {

	@GetMapping("/filtering/static")
	public Employee getEmployee() {
		return new Employee(1, "Jack", "pass1", 10000.00);
	}
}
