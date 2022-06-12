package com.velibaba.dao;

import java.util.List;

import com.velibaba.model.urunModel.AltKategori;

public interface RepositoryAltKategori {
	List<AltKategori> getAllKategori();
	AltKategori getByName(String name);
	void createKategori(AltKategori kategori);
	AltKategori updateKategori(AltKategori kategori);
	void deleteKategori(Long id);
	String getAltKategoriAdi(Long id);
	AltKategori getAltKategori(Long id);
}
