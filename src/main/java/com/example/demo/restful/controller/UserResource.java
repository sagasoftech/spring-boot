package com.example.demo.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restful.dao.UserDaoService;
import com.example.demo.restful.model.User;

@RestController
@RequestMapping("/restful")
public class UserResource {

	@Autowired
	private UserDaoService service;
	
	/*
	 * GET - Retrieve details of Resources
	 */
	@GetMapping("/users")
	public List<User> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findUser(@PathVariable int id) {
		return service.findUser(id);
	}
	
	/*
	 * POST - Create a new resource
	 */
	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		service.save(user);
	}
	
	
}
