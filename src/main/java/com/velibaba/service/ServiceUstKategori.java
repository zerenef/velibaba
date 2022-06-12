package com.velibaba.service;

import java.util.List;

import com.velibaba.model.urunModel.UstKategori;

public interface ServiceUstKategori {
	List<UstKategori> getAllKategori();
	UstKategori getByName(String name);
	void createKategori(UstKategori kategori);
	void updateKategori(UstKategori kategori);
	void deleteKategori(Long id);
}
