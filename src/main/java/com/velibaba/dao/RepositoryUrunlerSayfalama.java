package com.velibaba.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.velibaba.model.urunModel.AltKategori;
import com.velibaba.model.urunModel.Kategori;
import com.velibaba.model.urunModel.Urunler;

@Repository
public interface RepositoryUrunlerSayfalama extends PagingAndSortingRepository<Urunler, Long> {
	Page<Urunler> findAllByAltKategori(AltKategori altKategori, Pageable pageable);
	Page<Urunler> findAllByKategori(Kategori kategori, Pageable pageable);	
	
	Page<Urunler> findAllByAltKategoriAndUrunAktifmiAndStokGreaterThan(AltKategori altKategori, Boolean urunAktifmi, int stok, Pageable pageable);
	Page<Urunler> findAllByKategoriAndUrunAktifmiAndStokGreaterThan(Kategori kategori, Boolean urunAktifmi, int stok, Pageable pageable);

	Page<Urunler> findAllByAltKategoriAndUrunAktifmiAndStokGreaterThanAndMarkaAndFiyatLessThanAndFiyatGreaterThanAndIndirimGreaterThan(
			AltKategori kategori, Boolean urunAktifmi, int stok, String marka, double min, double max, int indirim, Pageable pageable);
}
