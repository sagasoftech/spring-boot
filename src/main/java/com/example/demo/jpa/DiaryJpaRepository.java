package com.example.demo.jpa;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DiaryJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Diary diary) {
		entityManager.merge(diary);
	}
	
	public Diary findById(long id) {
		return entityManager.find(Diary.class, id);
	}
	
	public void deleteById(long id) {
		Diary diary = entityManager.find(Diary.class, id);
		entityManager.remove(diary);
	}
	
}
