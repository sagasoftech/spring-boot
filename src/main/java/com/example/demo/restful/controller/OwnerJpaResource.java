package com.example.demo.restful.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.restful.exception.UserNotFoundException;
import com.example.demo.restful.model.Owner;
import com.example.demo.restful.repository.OwnerRepository;

@RestController
@RequestMapping("/restful")
public class OwnerJpaResource {

	@Autowired
	private OwnerRepository repository;

	@GetMapping("/owner-jpa")
	public List<Owner> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/owner-jpa/{id}")
	public Optional<Owner> findOwner(@PathVariable Long id) {
		Optional<Owner> owner = repository.findById(id);
		
		if(owner.isEmpty()) {
			throw new UserNotFoundException("id: "+ id);
		}
		return owner;
	}
	
	@DeleteMapping("/owner-jpa/{id}")
	public void deleteOwnerById(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
