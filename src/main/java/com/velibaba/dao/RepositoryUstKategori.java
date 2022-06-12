package com.velibaba.dao;

import java.util.List;

import com.velibaba.model.urunModel.UstKategori;

public interface RepositoryUstKategori {
	List<UstKategori> getAllKategori();
	UstKategori getByName(String name);
	void createKategori(UstKategori kategori);
	UstKategori updateKategori(UstKategori kategori);
	void deleteKategori(Long id);
	//List<Tuple> getAllKategoriAdi();
}
