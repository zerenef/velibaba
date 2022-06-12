package com.velibaba.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.velibaba.dao.RepositoryUstKategori;
import com.velibaba.model.urunModel.Kategori;
import com.velibaba.model.urunModel.UstKategori;

@Repository
public class JpaImplRepositoryUstKategori implements RepositoryUstKategori {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UstKategori> getAllKategori() {
		return entityManager.createQuery("from UstKategori", UstKategori.class).getResultList();
	}

	@Override
	public void createKategori(UstKategori kategori) {
		entityManager.persist(kategori);
	}

	@Override
	public UstKategori updateKategori(UstKategori kategori) {
		return entityManager.merge(kategori);
	}

	@Override
	public void deleteKategori(Long id) {
		entityManager.remove(entityManager.getReference(Kategori.class, id));
	}

	@Override
	public UstKategori getByName(String name) {
		return entityManager.createQuery("from UstKategori where ustKategoriAdi = :name", UstKategori.class)
				.setParameter("name", name).getSingleResult();
	}

	/*
	@Override
	public List<Tuple> getAllKategoriAdi() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> tupleCriteriaQuery = criteriaBuilder.createTupleQuery();
		Root<UstKategori> root = tupleCriteriaQuery.from(UstKategori.class);
		
		tupleCriteriaQuery.multiselect(root.get("ustKategoriAdi"));
		
		TypedQuery<Tuple> typedQuery = entityManager.createQuery(tupleCriteriaQuery);
		List<Tuple> resultList = typedQuery.getResultList();
		
		return resultList;
	}
*/

}
