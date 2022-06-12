package com.velibaba.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.velibaba.dao.RepositoryAuthorities;
import com.velibaba.model.Authorities;

@Repository
public class JpaImplRepositoryAuthorities implements RepositoryAuthorities {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Authorities authorities) {
		entityManager.persist(authorities);
	}

}
