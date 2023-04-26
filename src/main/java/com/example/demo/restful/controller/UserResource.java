package com.example.demo.restful.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.restful.dao.UserDaoService;
import com.example.demo.restful.exception.UserNotFoundException;
import com.example.demo.restful.model.User;

import jakarta.validation.Valid;

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
		User user = service.findUser(id);
		
		if(user == null) {
			throw new UserNotFoundException("id: "+ id);
		}
		return user;
	}
	
	/*
	 * POST - Create a new resource
	 */
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(savedUser.getId())
						.toUri();
		return ResponseEntity.created(location ).build();
	}
	
	/*
	 * DELETE - Delete the resource
	 */
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		service.deleteUserById(id);
	}
	
}
