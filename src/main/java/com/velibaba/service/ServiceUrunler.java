package com.velibaba.service;

import java.util.List;

import javax.persistence.Tuple;

import com.velibaba.model.UrunFiltre;
import com.velibaba.model.urunModel.AltKategori;
import com.velibaba.model.urunModel.Kategori;
import com.velibaba.model.urunModel.Urunler;

public interface ServiceUrunler {
	void createUrun(Urunler urun);
	void updateUrun(Urunler urun);
	void deleteUrun(Long id);
	List<Urunler> getAllUrunler();
	Urunler getById(Long id);
	List<Urunler> getByMarka(String marka);
	List<Urunler> getEnCokSatilan(Kategori kategori);
	List<Urunler> getEnCokSatilan20();
	List<Urunler> getByIndirim(Kategori kategori);
	List<Urunler> getByIndirim20();
	List<Tuple> getAllMarka(AltKategori id);
	List<Urunler> getUrunler(AltKategori id, int pageNo, String sortBy, UrunFiltre urunFiltre);
}
