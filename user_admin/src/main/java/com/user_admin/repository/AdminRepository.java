package com.user_admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user_admin.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, String> {
	String findByUsernameAndPassword(String userName, String password);

}
