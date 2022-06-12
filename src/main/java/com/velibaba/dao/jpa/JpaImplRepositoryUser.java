package com.velibaba.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.velibaba.dao.RepositoryUser;
import com.velibaba.model.User;

@Repository
public class JpaImplRepositoryUser implements RepositoryUser{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(User kullanici) {
		entityManager.persist(kullanici);
	}

	@Override
	public String getByUsername(String username) {
		return entityManager.createQuery("from User where username=:username", String.class).setParameter("username", username).getSingleResult();
	}
	
}
