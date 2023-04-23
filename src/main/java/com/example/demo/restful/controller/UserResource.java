package com.example.demo.restful.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restful.dao.UserDaoService;
import com.example.demo.restful.model.User;

@RestController
@RequestMapping("/restful")
public class UserResource {

	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping(path = "/users")
	public List<User> findAll(){
		return service.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User findUser(@PathVariable int id) {
		return service.findUser(id);
	}
	
}
