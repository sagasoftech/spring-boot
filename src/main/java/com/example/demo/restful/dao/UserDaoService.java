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
	
	private static int userCnt = 0;
	
	static {
		userList.add(new User(++userCnt, "Jack", LocalDate.now().minusYears(25)));
		userList.add(new User(++userCnt, "Queen", LocalDate.now().minusYears(30)));
		userList.add(new User(++userCnt, "King", LocalDate.now().minusYears(40)));
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	public User findUser(int id) {
		Predicate<? super User> predicate = user -> user.getId() == id;
		return userList.stream().filter(predicate).findFirst().orElse(null);
	}

	public User save(User user) {
		user.setId(++userCnt);
		userList.add(user);
		return user;
	}

}
