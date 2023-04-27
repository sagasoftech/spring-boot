package com.example.demo.jpa.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private BookJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Book(1, "Java", "Herbert Schildt"));
		repository.insert(new Book(2, "Docker", "Docker Foundation"));
		repository.insert(new Book(3, "Kubernetes", "K8s Foundation"));
		
		repository.deleteById(2);
		
		System.out.println("Book: " + repository.findById(1));
		System.out.println("Book: " + repository.findById(3));
	}

	
}
