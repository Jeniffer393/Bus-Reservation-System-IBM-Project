package com.user_admin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user_admin.model.Admin;
import com.user_admin.model.Route;
import com.user_admin.model.User;
import com.user_admin.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService service;

	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	void signUp(@RequestBody Admin admin) {
		service.signUp(admin);
	}

	@RequestMapping("/login/{adminName}/{password}")
	String login(@PathVariable String userName, @PathVariable String pasword) {
		return service.login(userName, pasword);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/admin/{adminId}")
	void updateProfile(@RequestBody Admin admin) {
		service.updateProfile(admin);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/{adminId}")
	void deleteProfile(@PathVariable String adminId) {
		service.deleteProfile(adminId);
	}

	@RequestMapping("/admin")
	Iterable<User> getAllUser() {
		return service.getAllUser();
	}

	@RequestMapping("/admin/{userId}")
	Optional<User> getUserById(@PathVariable String userId) {
		return service.getUserById(userId);
	}

	/*
	 * @RequestMapping(method = RequestMethod.POST, value = "/admin/bus") void
	 * addbus(@RequestBody Bus bus) { service.addbus(bus); }
	 * 
	 * @RequestMapping(method = RequestMethod.PUT, value = "/admin/bus/{busId}")
	 * void updateBus(@RequestBody Bus bus) { service.updateBus(bus); }
	 * 
	 * 
	 * @RequestMapping(method = RequestMethod.DELETE, value = "/admin/bus/{busId}")
	 * void deleteBus(@PathVariable String busId) { service.deleteBus(busId); }
	 */

	@RequestMapping("/admin/route")
	Iterable<Route> getAllRoute() {
		return service.getAllRoute();
	}

	@RequestMapping("/admin/route/{routeId}")
	Optional<Route> getRouteById(@PathVariable Integer routeId) {
		return service.getRouteById(routeId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/admin/route")
	void addRoute(@RequestBody Route route) {
		service.addRoute(route);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/admin/route/{routeId}")
	void updateRoute(@RequestBody Route route) {
		service.updateRoute(route);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/route/{routeId}")
	void deleteRoute(@PathVariable Integer routeId) {
		service.deleteRoute(routeId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/route/{origin}")
	void deleteRouteByOrigin(@PathVariable String origin) {
		service.deleteRouteByOrigin(origin);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/admin/route/{destination}")
	void deleteRouteByDestination(@PathVariable String destination) {
		service.deleteRouteByDestination(destination);
	}

	@RequestMapping("/admin/route/origin/{origin}")
	List<Route> getRouteByOrigin(@PathVariable String origin) {
		return service.getRouteByOrigin(origin);
	}

	@RequestMapping("/admin/route/destination/{destination}")
	List<Route> getRouteByDestination(@PathVariable String destination) {
		return service.getRouteByDestination(destination);
	}

	@RequestMapping("/admin/route/origin/destination/{origin}/{destination}")
	List<Route> getRouteByOriginAndDestination(@PathVariable String origin, @PathVariable String destination) {
		return service.getRouteByOriginAndDestination(origin, destination);
	}

}
