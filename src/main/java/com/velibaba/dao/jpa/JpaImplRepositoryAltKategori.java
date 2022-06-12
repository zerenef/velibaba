package com.velibaba.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.velibaba.dao.RepositoryAltKategori;
import com.velibaba.model.urunModel.AltKategori;
import com.velibaba.model.urunModel.Kategori;

@Repository
public class JpaImplRepositoryAltKategori implements RepositoryAltKategori {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<AltKategori> getAllKategori() {
		return entityManager.createQuery("from AltKategori", AltKategori.class).getResultList();
	}

	@Override
	public void createKategori(AltKategori kategori) {
		entityManager.persist(kategori);
	}

	@Override
	public AltKategori updateKategori(AltKategori kategori) {
		return entityManager.merge(kategori);
	}

	@Override
	public void deleteKategori(Long id) {
		entityManager.remove(entityManager.getReference(Kategori.class, id));
	}

	@Override
	public AltKategori getByName(String name) {
		return entityManager.createQuery("from AltKategori where altKategoriAdi = :name", AltKategori.class)
				.setParameter("name", name).getSingleResult();
	}

	@Override
	public String getAltKategoriAdi(Long id) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> tupleCriteriaQuery = criteriaBuilder.createTupleQuery();
		Root<AltKategori> root = tupleCriteriaQuery.from(AltKategori.class);
		
		tupleCriteriaQuery.multiselect(
				root.get("altKategoriAdi").alias("altKategoriAdi"));
		tupleCriteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
		
		TypedQuery<Tuple> typedQuery = entityManager.createQuery(tupleCriteriaQuery);
		
		String altKategoriIsmi = typedQuery.getSingleResult().get("altKategoriAdi").toString();
			
		return altKategoriIsmi;
	}

	@Override
	public AltKategori getAltKategori(Long id) {
		return entityManager.createQuery("from AltKategori where id=:id", AltKategori.class).setParameter("id", id).getSingleResult();
	}

}
