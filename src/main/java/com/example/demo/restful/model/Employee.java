package com.example.demo.restful.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("salary")
public class Employee {

	private int eid;
	private String username;
	
	@JsonIgnore
	private String userpass;
	
	private double salary;

	public Employee(int eid, String username, String userpass, double salary) {
		super();
		this.eid = eid;
		this.username = username;
		this.userpass = userpass;
		this.salary = salary;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
