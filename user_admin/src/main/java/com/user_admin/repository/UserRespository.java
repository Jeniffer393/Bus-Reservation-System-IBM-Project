package com.user_admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user_admin.model.User;

@Repository
public interface UserRespository extends CrudRepository<User, String> {

	String findByUsernameAndPassword(String userName, String password);
}
