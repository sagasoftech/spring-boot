package com.example.demo.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StorySpringDataJpaCommandLineRunner implements CommandLineRunner{

	@Autowired
	private StorySpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Story(1, "Java", "Herbert Schildt"));
		repository.save(new Story(2, "Docker", "Docker Foundation"));
		repository.save(new Story(3, "Kubernetes", "K8s Foundation"));
		
		repository.deleteById(2l);
		
		System.out.println("Story: " + repository.findById(1l));
		System.out.println("Story: " + repository.findById(3l));
		
		System.out.println("All Diary" + repository.findAll());
		System.out.println("Count of Diaries: " + repository.count());
	}

	
}
