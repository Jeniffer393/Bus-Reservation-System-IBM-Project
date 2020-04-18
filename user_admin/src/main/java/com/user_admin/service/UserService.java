package com.user_admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user_admin.model.User;
import com.user_admin.repository.UserRespository;

@Service
public class UserService {
	@Autowired
	UserRespository repo;

	public void signUp(User user) {
		repo.save(user);

	}

	public String login(String userName, String password) {
		return repo.findByUsernameAndPassword(userName, password);
	}

	public void updateProfile(User user) {
		repo.save(user);

	}

	public void deleteProfile(String userId) {
		repo.deleteById(userId);

	}

}
