package com.velibaba.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.velibaba.dao.RepositoryUrunler;
import com.velibaba.model.UrunFiltre;
import com.velibaba.model.urunModel.AltKategori;
import com.velibaba.model.urunModel.Kategori;
import com.velibaba.model.urunModel.Urunler;
import com.velibaba.web.PageCount;

@Repository
public class JpaImplRepositoryUrunler implements RepositoryUrunler {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void createUrun(Urunler urun) {
		entityManager.persist(urun);
	}

	@Override
	public Urunler updateUrun(Urunler urun) {
		return entityManager.merge(urun);
	}

	@Override
	public void deleteUrun(Long id) {
		entityManager.remove(entityManager.getReference(Urunler.class, id));
	}

	@Override
	public List<Urunler> getAllUrunler() {
		return entityManager.createQuery("from Urunler", Urunler.class).getResultList();
	}

	@Override
	public Urunler getById(Long id) {
		return entityManager.createQuery("from Urunler where id = :id", Urunler.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Urunler> getByMarka(String marka) {
		return entityManager.createQuery("from Urunler where marka = :marka", Urunler.class)
				.setParameter("marka", marka).getResultList();
	}

	@Override
	public List<Urunler> getEnCokSatilan(Kategori kategori) {
		return entityManager.createQuery("from Urunler where kategori = :id and urunAktifmi = true and stok > 0 order by satisMiktari desc", Urunler.class)
				.setParameter("id", kategori).setFirstResult(0).setMaxResults(20).getResultList();
	}
	
	@Override
	public List<Urunler> getEnCokSatilan20() {
		return entityManager.createQuery("from Urunler where urunAktifmi = true and stok > 0 order by satisMiktari desc", Urunler.class)
				.setFirstResult(0).setMaxResults(20).getResultList();
	}

	@Override
	public List<Urunler> getByIndirim(Kategori kategori) {
		return entityManager.createQuery("from Urunler where kategori = :id and urunAktifmi = true and stok > 0 order by indirim desc", Urunler.class)
				.setParameter("id", kategori).setFirstResult(0).setMaxResults(20).getResultList();
	}
	
	@Override
	public List<Urunler> getByIndirim20() {
		return entityManager.createQuery("from Urunler where urunAktifmi = true and stok > 0 order by indirim desc", Urunler.class)
				.setFirstResult(0).setMaxResults(20).getResultList();
	}

	@Override
	public List<Tuple> getAllMarka(AltKategori id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> tupleCriteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Urunler> root = tupleCriteriaQuery.from(Urunler.class);
		
		tupleCriteriaQuery.multiselect(root.get("marka").alias("marka")).distinct(true);
		tupleCriteriaQuery.where(criteriaBuilder.equal(root.get("altKategori"), id));
		TypedQuery<Tuple> typedQuery = entityManager.createQuery(tupleCriteriaQuery);
		List<Tuple> resultList = typedQuery.getResultList();
		
		return resultList;
	}

	@Override
	public List<Urunler> getUrunler(AltKategori id, int pageNo, String sortBy, UrunFiltre urunFiltre) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Urunler> criteriaQuery = criteriaBuilder.createQuery(Urunler.class);
		Root<Urunler> root = criteriaQuery.from(Urunler.class);
		
		List<Predicate> orPredicate = new ArrayList<>();
		List<Predicate> andPredicate = new ArrayList<>();
		Predicate[] predicatesAnd = null;
		Predicate[] predicatesOr = null;
		if(urunFiltre != null) {
			if(urunFiltre.getMarkalar().length > 0) {
				for (int i = 0; i < urunFiltre.getMarkalar().length; i++) {
					orPredicate.add(criteriaBuilder.equal(root.get("marka"), urunFiltre.getMarkalar()[i]));
				}
			}
			predicatesOr = new Predicate[orPredicate.size()];
			for (int i = 0; i < predicatesOr.length; i++) {
				predicatesOr[i] = orPredicate.get(i);
			}
			
			if(!urunFiltre.getFiyatMin().equals("")) {
				andPredicate.add(criteriaBuilder.greaterThan(root.get("fiyat"), Double.valueOf(urunFiltre.getFiyatMin())));
			}
			if(!urunFiltre.getFiyatMax().equals("")) {
				andPredicate.add(criteriaBuilder.lessThan(root.get("fiyat"), Double.valueOf(urunFiltre.getFiyatMax())));
			}
			if(urunFiltre.getIndirim() != null) {
				andPredicate.add(criteriaBuilder.greaterThan(root.get("indirim"), 0));
			}
			predicatesAnd = new Predicate[andPredicate.size()];
			for (int i = 0; i < predicatesAnd.length; i++) {
				predicatesAnd[i] = andPredicate.get(i);
			}
		}
		
		if(sortBy.equals("id")) {
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));
		}else if(sortBy.equals("artan")) {
			criteriaQuery.orderBy(criteriaBuilder.asc(root.get("fiyat")));
		}else if(sortBy.equals("azalan")) {
			criteriaQuery.orderBy(criteriaBuilder.desc(root.get("fiyat")));
		}else if(sortBy.equals("en-cok-satan")) {
			criteriaQuery.orderBy(criteriaBuilder.desc(root.get("satisMiktari")));
		}
		
		if(urunFiltre != null){
			if(urunFiltre.getMarkalar().length != 0 && (!urunFiltre.getFiyatMin().equals("") || 
					!urunFiltre.getFiyatMax().equals("") || urunFiltre.getIndirim() != null)) {
				criteriaQuery.where(criteriaBuilder.or(predicatesOr), criteriaBuilder.and(predicatesAnd), criteriaBuilder.equal(root.get("altKategori"), id),
						criteriaBuilder.greaterThan(root.get("stok"), 0), criteriaBuilder.equal(root.get("urunAktifmi"), true));
			}else if(urunFiltre.getMarkalar().length == 0 && (!urunFiltre.getFiyatMin().equals("") || 
					!urunFiltre.getFiyatMax().equals("") || urunFiltre.getIndirim() != null)) {
				criteriaQuery.where(criteriaBuilder.and(predicatesAnd), criteriaBuilder.equal(root.get("altKategori"), id),
						criteriaBuilder.greaterThan(root.get("stok"), 0), criteriaBuilder.equal(root.get("urunAktifmi"), true));
			}else if(urunFiltre.getMarkalar().length != 0 && (urunFiltre.getFiyatMin().equals("") || 
					urunFiltre.getFiyatMax().equals("") || urunFiltre.getIndirim() == null)) {
				criteriaQuery.where(criteriaBuilder.or(predicatesOr), criteriaBuilder.equal(root.get("altKategori"), id),
						criteriaBuilder.greaterThan(root.get("stok"), 0), criteriaBuilder.equal(root.get("urunAktifmi"), true));
			}else {
				criteriaQuery.where(criteriaBuilder.equal(root.get("altKategori"), id), criteriaBuilder.greaterThan(root.get("stok"), 0), 
						criteriaBuilder.equal(root.get("urunAktifmi"), true));
			}
		}else {
			criteriaQuery.where(criteriaBuilder.equal(root.get("altKategori"), id), criteriaBuilder.greaterThan(root.get("stok"), 0), 
					criteriaBuilder.equal(root.get("urunAktifmi"), true));
		}
		
		List<Urunler> urunlerCount = entityManager.createQuery(criteriaQuery).getResultList();
		int pageCount = urunlerCount.size() / 12;
		pageCount += urunlerCount.size() % 12 != 0 ? 1:0;
		PageCount s = new PageCount();
		s.setSayfaSayisi(pageCount);
		
		TypedQuery<Urunler> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(pageNo*12);
		typedQuery.setMaxResults(12);
		List<Urunler> resultList = typedQuery.getResultList();
		
		return resultList;
	}
	
}
