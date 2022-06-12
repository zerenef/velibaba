package com.velibaba.service.impl;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velibaba.dao.RepositoryUrunler;
import com.velibaba.model.UrunFiltre;
import com.velibaba.model.urunModel.AltKategori;
import com.velibaba.model.urunModel.Kategori;
import com.velibaba.model.urunModel.Urunler;
import com.velibaba.service.ServiceUrunler;

@Service
@Transactional
public class ImplServiceUrunler implements ServiceUrunler {

	private RepositoryUrunler urunlerRepository;
	
	@Autowired
	public void setUrunlerRepository(RepositoryUrunler urunlerRepository) {
		this.urunlerRepository = urunlerRepository;
	}
	
	@Override
	public void createUrun(Urunler urun) {
		urunlerRepository.createUrun(urun);
	}

	@Override
	public void updateUrun(Urunler urun) {
		urunlerRepository.updateUrun(urun);
	}

	@Override
	public void deleteUrun(Long id) {
		urunlerRepository.deleteUrun(id);
	}

	@Override
	public List<Urunler> getAllUrunler() {
		return urunlerRepository.getAllUrunler();
	}

	@Override
	public Urunler getById(Long id) {
		return urunlerRepository.getById(id);
	}

	@Override
	public List<Urunler> getByMarka(String marka) {
		return urunlerRepository.getByMarka(marka);
	}

	@Override
	public List<Urunler> getEnCokSatilan(Kategori kategori) {
		return urunlerRepository.getEnCokSatilan(kategori);
	}
	
	@Override
	public List<Urunler> getEnCokSatilan20() {
		return urunlerRepository.getEnCokSatilan20();
	}

	@Override
	public List<Urunler> getByIndirim(Kategori kategori) {
		return urunlerRepository.getByIndirim(kategori);
	}
	
	@Override
	public List<Urunler> getByIndirim20() {
		return urunlerRepository.getByIndirim20();
	}

	@Override
	public List<Tuple> getAllMarka(AltKategori id) {
		return urunlerRepository.getAllMarka(id);
	}

	@Override
	public List<Urunler> getUrunler(AltKategori id, int pageNo, String sortBy, UrunFiltre urunFiltre) {
		return urunlerRepository.getUrunler(id, pageNo, sortBy, urunFiltre);
	}


}
