package com.velibaba.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.velibaba.dao.RepositoryUrunOzellikleri;
import com.velibaba.model.urunModel.UrunOzellikleri;
import com.velibaba.model.urunModel.Urunler;

@Repository
public class JpaImplRepositoryUrunOzellikleri implements RepositoryUrunOzellikleri {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addUrunOzellik(UrunOzellikleri ozellik) {
		entityManager.persist(ozellik);
	}

	@Override
	public UrunOzellikleri updateUrunOzellik(UrunOzellikleri ozellik) {
		return entityManager.merge(ozellik);
	}

	@Override
	public void deleteUrunOzellik(Long id) {
		entityManager.remove(entityManager.getReference(UrunOzellikleri.class, id));
	}

	@Override
	public UrunOzellikleri getIdUrunOzellikleri(Long id) {
		return entityManager.find(UrunOzellikleri.class, id);
	}

	@Override
	public UrunOzellikleri getOzellikUrun(Urunler urun) {
		return entityManager.createQuery("from UrunOzellikleri where urun = :id", UrunOzellikleri.class)
				.setParameter("id", urun).getSingleResult();
	}

}
