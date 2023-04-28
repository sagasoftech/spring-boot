package com.example.demo.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.restful.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer>{

}
