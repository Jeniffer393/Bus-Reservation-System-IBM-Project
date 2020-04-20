package com.bus.ibm.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.bus.ibm.project.model.User;

public interface UserRepository  extends CrudRepository<User, String>{


}
