package com.capgemini.springboot.Services;

import com.capgemini.springboot.entities.User;

public interface UserService {
	
	void saveUser(User user);

	User findUserByUsername(String username);
	
	boolean isValidUser(String username, String password);
}
