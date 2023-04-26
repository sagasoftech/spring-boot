package com.example.demo.restful.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restful.model.Employee;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/restful")
public class FilteringController {

	@GetMapping("/filtering/static")
	public Employee getEmployee() {
		return new Employee(1, "Jack", "pass1", 10000.00);
	}
	
	@GetMapping("/filtering/dynamic")
	public MappingJacksonValue getEmployeeDynamic() {
		Employee employee = new Employee(1, "Jack", "pass1", 10000.00);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(employee);
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("eid", "username");
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("EmployeeDynamicFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		
	}
}
