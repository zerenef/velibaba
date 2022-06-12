package com.velibaba.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velibaba.dao.RepositoryAuthorities;
import com.velibaba.model.Authorities;
import com.velibaba.service.ServiceAuthorities;

@Service
@Transactional
public class ImplServiceAuthorities implements ServiceAuthorities {

	private RepositoryAuthorities authoritiesRepository;
	
	@Autowired
	public void setAuthoritiesRepository(RepositoryAuthorities authoritiesRepository) {
		this.authoritiesRepository = authoritiesRepository;
	}
	
	@Override
	public void createAuthorities(Authorities authorities) {
		authoritiesRepository.create(authorities);
	}

}
