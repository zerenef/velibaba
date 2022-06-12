package com.velibaba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velibaba.dao.RepositoryUstKategori;
import com.velibaba.model.urunModel.UstKategori;
import com.velibaba.service.ServiceUstKategori;

@Service
@Transactional
public class ImplServiceUstKategori implements ServiceUstKategori {

	private RepositoryUstKategori ustKategoriRepository;
	
	@Autowired
	public void setUstKategoriRepository(RepositoryUstKategori ustKategoriRepository) {
		this.ustKategoriRepository = ustKategoriRepository;
	}
	
	@Override
	public List<UstKategori> getAllKategori() {
		return ustKategoriRepository.getAllKategori();
	}

	@Override
	public void createKategori(UstKategori kategori) {
		ustKategoriRepository.createKategori(kategori);
	}

	@Override
	public void updateKategori(UstKategori kategori) {
		ustKategoriRepository.updateKategori(kategori);
	}

	@Override
	public void deleteKategori(Long id) {
		ustKategoriRepository.deleteKategori(id);
	}

	@Override
	public UstKategori getByName(String name) {
		return ustKategoriRepository.getByName(name);
	}

	/*
	@Override
	public List<Tuple> getAllKategoriAdi() {
		return ustKategoriRepository.getAllKategoriAdi();
	}
	*/
	
}
