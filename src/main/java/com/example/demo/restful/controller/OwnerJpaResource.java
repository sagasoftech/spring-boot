package com.example.demo.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
}
