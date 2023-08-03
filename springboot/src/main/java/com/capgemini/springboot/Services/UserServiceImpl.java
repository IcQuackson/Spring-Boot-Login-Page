package com.capgemini.springboot.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.entities.User;
import com.capgemini.springboot.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

	@Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
	public boolean isValidUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }
}
