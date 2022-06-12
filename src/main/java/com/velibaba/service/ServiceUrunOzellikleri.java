package com.velibaba.service;

import com.velibaba.model.urunModel.UrunOzellikleri;
import com.velibaba.model.urunModel.Urunler;

public interface ServiceUrunOzellikleri {
	void addUrunOzellik(UrunOzellikleri ozellik);
	void updateUrunOzellik(UrunOzellikleri ozellik);
	void deleteUrunOzellik(Long id);
	UrunOzellikleri getIdUrunOzellikleri(Long id);
	UrunOzellikleri getOzellikUrun(Urunler urun);
}
