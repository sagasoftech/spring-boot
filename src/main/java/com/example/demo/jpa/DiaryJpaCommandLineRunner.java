package com.example.demo.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DiaryJpaCommandLineRunner implements CommandLineRunner{

	@Autowired
	private DiaryJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Diary(1, "Java", "Herbert Schildt"));
		repository.insert(new Diary(2, "Docker", "Docker Foundation"));
		repository.insert(new Diary(3, "Kubernetes", "K8s Foundation"));
		
		repository.deleteById(2);
		
		System.out.println("Diary: " + repository.findById(1));
		System.out.println("Diary: " + repository.findById(3));
	}

	
}
