package com.example.demo.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.restful.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer>{

}
