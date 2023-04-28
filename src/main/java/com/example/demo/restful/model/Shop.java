package com.example.demo.restful.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Shop {

	@Id
	@GeneratedValue
	private int id;
	
	private String shopName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Owner owner;

	public Shop() {
		super();
	}

	public Shop(int id, String shopName) {
		super();
		this.id = id;
		this.shopName = shopName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopName=" + shopName + "]";
	}
	
}
