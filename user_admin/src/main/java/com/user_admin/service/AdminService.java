package com.user_admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user_admin.model.*;
import com.user_admin.repository.*;

@Service
public class AdminService {
	@Autowired
	AdminRepository repo;
	@Autowired
	UserRespository repo1;
	@Autowired
	RouteRepository repo2;

	public void signUp(Admin user) {
		repo.save(user);

	}

	public String login(String userName, String password) {
		return repo.findByUsernameAndPassword(userName, password);
	}

	public void updateProfile(Admin user) {
		repo.save(user);

	}

	public void deleteProfile(String userId) {
		repo.deleteById(userId);

	}

	public Iterable<User> getAllUser() {
		return repo1.findAll();
	}

	public Optional<User> getUserById(String userId) {
		return repo1.findById(userId);
	}

	public Iterable<Route> getAllRoute() {
		return repo2.findAll();
	}

	public Optional<Route> getRouteById(Integer routeId) {
		return repo2.findById(routeId);
	}

	public void addRoute(Route route) {
		repo2.save(route);
	}

	public void updateRoute(Route route) {
		repo2.save(route);
	}

	public void deleteRoute(Integer routeId) {
		repo2.deleteById(routeId);
	}

	public List<Route> getRouteByOrigin(String Origin) {
		return repo2.findByOrigin(Origin);
	}

	public List<Route> getRouteByDestination(String destination) {
		return repo2.findByDestination(destination);
	}

	public List<Route> getRouteByOriginAndDestination(String origin, String destination) {
		return repo2.findByOriginAndDestination(origin, destination);
	}

	public void deleteRouteByOrigin(String origin) {
		repo2.deleteByOrigin(origin);

	}

	public void deleteRouteByDestination(String destination) {
		repo2.deleteByDestination(destination);

	}

}
