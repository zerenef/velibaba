package com.velibaba.dao;

import com.velibaba.model.urunModel.UrunOzellikleri;
import com.velibaba.model.urunModel.Urunler;

public interface RepositoryUrunOzellikleri {
	void addUrunOzellik(UrunOzellikleri ozellik);
	UrunOzellikleri updateUrunOzellik(UrunOzellikleri ozellik);
	void deleteUrunOzellik(Long id);
	UrunOzellikleri getIdUrunOzellikleri(Long id);
	UrunOzellikleri getOzellikUrun(Urunler urun);
}
