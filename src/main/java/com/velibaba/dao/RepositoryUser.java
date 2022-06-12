package com.velibaba.dao;

import com.velibaba.model.User;

public interface RepositoryUser {
	void create(User kullanici);
	String getByUsername(String username);
}
