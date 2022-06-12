package com.velibaba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velibaba.dao.RepositoryKategori;
import com.velibaba.model.urunModel.Kategori;
import com.velibaba.service.ServiceKategori;

@Service
@Transactional
public class ImplServiceKategori implements ServiceKategori {

	private RepositoryKategori kategoriRepository;
	
	@Autowired
	public void setKategoriRepository(RepositoryKategori kategoriRepository) {
		this.kategoriRepository = kategoriRepository;
	}
	
	@Override
	public List<Kategori> getAllKategori() {
		return kategoriRepository.getAllKategori();
	}

	@Override
	public void createKategori(Kategori kategori) {
		kategoriRepository.createKategori(kategori);
	}

	@Override
	public void updateKategori(Kategori kategori) {
		kategoriRepository.updateKategori(kategori);
	}

	@Override
	public void deleteKategori(Long id) {
		kategoriRepository.deleteKategori(id);
	}

	@Override
	public Kategori getByName(String name) {
		return kategoriRepository.getByName(name);
	}

	@Override
	public Kategori getKategori(Long id) {
		
		return kategoriRepository.getKategori(id);
	}

}
