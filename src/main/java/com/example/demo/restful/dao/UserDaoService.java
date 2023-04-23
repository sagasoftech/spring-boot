package com.example.demo.restful.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.example.demo.restful.model.User;

@Component
public class UserDaoService {
	
	public static List<User> userList = new ArrayList<>();
	
	static {
		userList.add(new User(1, "Jack", LocalDate.now().minusYears(25)));
		userList.add(new User(2, "Queen", LocalDate.now().minusYears(30)));
		userList.add(new User(3, "King", LocalDate.now().minusYears(40)));
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	public User findUser(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return userList.stream().filter(predicate).findFirst().get();
	}

}
