package com.example.demo.restful.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;

@Entity
public class Owner {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Length(min=2, message = "Name should have atleast two charactors")
	private String name;
	
	@Past(message = "Birth Date should be in past")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy = "owner")
	@JsonIgnore
	private List<Shop> shops;
	
	public Owner() {
		super();
	}

	public Owner(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
