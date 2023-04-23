package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Course;

@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retriveAllCourses(){
		return Arrays.asList(
			new Course(1, "Learn AWS", "AWS"),
			new Course(2, "Learn Java", "Oracle"),
			new Course(3, "Learn Azure", "Mocrosoft")
		);
	}
}
