package com.velibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velibaba.dao.RepositoryUser;
import com.velibaba.model.User;
import com.velibaba.service.ServiceUser;

@Service
@Transactional
public class ImplServiceUser implements ServiceUser{

	private RepositoryUser kullaniciRepository;
	
	@Autowired
	public void setKullaniciRepository(RepositoryUser kullaniciRepository) {
		this.kullaniciRepository = kullaniciRepository;
	}
	
	@Override
	public void createKullanici(User kullanici) {
		kullaniciRepository.create(kullanici);
	}

}
