package com.name.service;

import com.name.model.User;

public interface IUserService {

	public Integer saveUser(User user);
	public User getUserByEmail(String email);
	
}