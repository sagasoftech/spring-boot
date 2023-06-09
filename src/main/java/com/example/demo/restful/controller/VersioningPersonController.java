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
	
	@GetMapping(path = "/persons", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParam() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/persons", params = "version=2")
	public PersonV2 getSecondVersionOfPersonRequestParam() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "/persons/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonHeaders() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/persons/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonHeaders() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(path = "/persons/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonAcceptHeaders() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/persons/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeaders() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
