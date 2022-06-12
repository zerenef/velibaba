package com.velibaba.service;

import java.util.List;

import com.velibaba.model.urunModel.AltKategori;

public interface ServiceAltKategori {

	List<AltKategori> getAllKategori();
	AltKategori getByName(String name);
	void createKategori(AltKategori kategori);
	void updateKategori(AltKategori kategori);
	void deleteKategori(Long id);
	String getAltKategoriAdi(Long id);
	AltKategori getAltKategori(Long id);
}
