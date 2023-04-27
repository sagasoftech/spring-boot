package com.example.demo.jpa.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY =
			"""
					INSERT INTO BOOK ( ID, NAME, AUTHOR)
					VALUES(?, ?, ?);
			""";
	
	public void insert(Book book) {
		springJdbcTemplate.update(INSERT_QUERY, book.getId(), book.getName(), book.getAuthor());
	}
}
