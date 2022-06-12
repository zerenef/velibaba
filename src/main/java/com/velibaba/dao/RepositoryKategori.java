package com.velibaba.dao;

import java.util.List;

import com.velibaba.model.urunModel.Kategori;

public interface RepositoryKategori {
	List<Kategori> getAllKategori();
	Kategori getByName(String name);
	void createKategori(Kategori kategori);
	Kategori updateKategori(Kategori kategori);
	void deleteKategori(Long id);
	Kategori getKategori(Long id);
}
