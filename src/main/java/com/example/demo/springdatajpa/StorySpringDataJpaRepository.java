package com.example.demo.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StorySpringDataJpaRepository extends JpaRepository<Story, Long>{

	List<Story> findByAuthor(String author);
}
