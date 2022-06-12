package com.velibaba.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.velibaba.dao.RepositoryKategori;
import com.velibaba.model.urunModel.Kategori;

@Repository
public class JpaImplRepositoryKategori implements RepositoryKategori {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Kategori> getAllKategori() {
		return entityManager.createQuery("from Kategori", Kategori.class).getResultList();
	}

	@Override
	public void createKategori(Kategori kategori) {
		entityManager.persist(kategori);
	}

	@Override
	public Kategori updateKategori(Kategori kategori) {
		return entityManager.merge(kategori);
	}

	@Override
	public void deleteKategori(Long id) {
		entityManager.remove(entityManager.getReference(Kategori.class, id));
	}

	@Override
	public Kategori getByName(String name) {
		return entityManager.createQuery("from Kategori where kategoriAdi = :name", Kategori.class)
				.setParameter("name", name).getSingleResult();
	}

	@Override
	public Kategori getKategori(Long id) {
		return entityManager.createQuery("from Kategori where id=:id", Kategori.class).setParameter("id", id).getSingleResult();
	}

}
