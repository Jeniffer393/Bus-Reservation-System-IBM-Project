package com.user_admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user_admin.model.User;
import com.user_admin.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	void signUp(@RequestBody User user) {
		service.signUp(user);
	}

	@RequestMapping("/login/{userName}/{password}")
	String login(@PathVariable String userName, @PathVariable String pasword) {
		return service.login(userName, pasword);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user/{userId}")
	void updateProfile(@RequestBody User user) {
		service.updateProfile(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{userId}")
	void deleteProfile(@PathVariable String userId) {
		service.deleteProfile(userId);
	}

}
