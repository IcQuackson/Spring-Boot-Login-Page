package com.capgemini.springboot;

public interface UserService {
	
	void saveUser(User user);

	User findUserByUsername(String username);
	
	boolean isValidUser(String username, String password);
}
