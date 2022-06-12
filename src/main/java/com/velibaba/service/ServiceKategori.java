package com.velibaba.service;

import java.util.List;

import com.velibaba.model.urunModel.Kategori;

public interface ServiceKategori {
	List<Kategori> getAllKategori();
	Kategori getByName(String name);
	void createKategori(Kategori kategori);
	void updateKategori(Kategori kategori);
	void deleteKategori(Long id);
	Kategori getKategori(Long id);
}
