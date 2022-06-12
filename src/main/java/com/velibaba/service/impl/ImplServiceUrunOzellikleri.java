package com.velibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velibaba.dao.RepositoryUrunOzellikleri;
import com.velibaba.model.urunModel.UrunOzellikleri;
import com.velibaba.model.urunModel.Urunler;
import com.velibaba.service.ServiceUrunOzellikleri;

@Service
@Transactional
public class ImplServiceUrunOzellikleri implements ServiceUrunOzellikleri {

	private RepositoryUrunOzellikleri urunOzellikleriRepository;
	
	@Autowired
	public void setUrunOzellikleriRepository(RepositoryUrunOzellikleri urunOzellikleriRepository) {
		this.urunOzellikleriRepository = urunOzellikleriRepository;
	}
	
	@Override
	public void addUrunOzellik(UrunOzellikleri ozellik) {
		urunOzellikleriRepository.addUrunOzellik(ozellik);
	}

	@Override
	public void updateUrunOzellik(UrunOzellikleri ozellik) {
		urunOzellikleriRepository.updateUrunOzellik(ozellik);
	}

	@Override
	public void deleteUrunOzellik(Long id) {
		urunOzellikleriRepository.deleteUrunOzellik(id);
	}

	@Override
	public UrunOzellikleri getIdUrunOzellikleri(Long id) {
		return urunOzellikleriRepository.getIdUrunOzellikleri(id);
	}

	@Override
	public UrunOzellikleri getOzellikUrun(Urunler urun) {
		return urunOzellikleriRepository.getOzellikUrun(urun);
	}

}
