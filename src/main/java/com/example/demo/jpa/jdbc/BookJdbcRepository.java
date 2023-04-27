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
					VALUES(1, 'JAVA', 'Herbert Schildt');
			""";
	
	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}
}
