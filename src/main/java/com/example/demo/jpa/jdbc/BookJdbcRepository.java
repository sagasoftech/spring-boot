package com.example.demo.jpa.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	
	private static String DELETE_QUERY =
			"""
					DELETE FROM BOOK
					WHERE ID = ?;
			""";
	
	private static String SELECT_QUERY =
			"""
					SELECT ID, NAME, AUTHOR FROM BOOK
					WHERE ID = ?;
			""";
	
	public void insert(Book book) {
		springJdbcTemplate.update(INSERT_QUERY, book.getId(), book.getName(), book.getAuthor());
	}
	
	public void deleteById(int id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Book findById(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, 
				new BeanPropertyRowMapper<>(Book.class), id);
	}
}
