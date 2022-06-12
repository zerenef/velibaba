package com.velibaba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velibaba.dao.RepositoryAltKategori;
import com.velibaba.model.urunModel.AltKategori;
import com.velibaba.service.ServiceAltKategori;

@Service
@Transactional
public class ImplServiceAltKategori implements ServiceAltKategori {

	private RepositoryAltKategori altKategoriRepository;
	
	// dependency injection
	// setter
	// constructor
	
	@Autowired
	public void setAltKategoriRepository(RepositoryAltKategori altKategoriRepository) {
		this.altKategoriRepository = altKategoriRepository;
	}
	
	@Override
	public List<AltKategori> getAllKategori() {
		return altKategoriRepository.getAllKategori();
	}

	@Override
	public void createKategori(AltKategori kategori) {
		altKategoriRepository.createKategori(kategori);
	}

	@Override
	public void updateKategori(AltKategori kategori) {
		altKategoriRepository.updateKategori(kategori);
	}

	@Override
	public void deleteKategori(Long id) {
		altKategoriRepository.deleteKategori(id);
	}

	@Override
	public AltKategori getByName(String name) {
		return altKategoriRepository.getByName(name);
	}

	@Override
	public String getAltKategoriAdi(Long id) {
		return altKategoriRepository.getAltKategoriAdi(id);
	}

	@Override
	public AltKategori getAltKategori(Long id) {
		return altKategoriRepository.getAltKategori(id);
	}

}
