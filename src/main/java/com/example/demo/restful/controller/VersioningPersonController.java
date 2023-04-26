package com.example.demo.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restful.model.Name;
import com.example.demo.restful.model.PersonV1;
import com.example.demo.restful.model.PersonV2;

@RestController
@RequestMapping("/restful")
public class VersioningPersonController {

	@GetMapping("/v1/persons")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/persons")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
