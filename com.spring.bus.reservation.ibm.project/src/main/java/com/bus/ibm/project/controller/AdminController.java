package com.bus.ibm.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.GroupSequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.ibm.project.model.Agency;
import com.bus.ibm.project.model.Bus;
import com.bus.ibm.project.model.BusRouteDetails;
import com.bus.ibm.project.model.Route;
import com.bus.ibm.project.service.AgencyService;
import com.bus.ibm.project.service.BusRouteService;
import com.bus.ibm.project.service.BusService;
import com.bus.ibm.project.service.RouteService;

@RestController
public class AdminController {
	@Autowired 
	BusService    service;
	@Autowired
	RouteService  routeService;
	@Autowired
	AgencyService agencyService;
	@Autowired
	BusRouteService busRouteService;
	//adding the bus
	@PostMapping("/addbus")
	void  addBus(@RequestBody Bus bus) {
		  service.addBus(bus);
		
	}
	//getting the busbyId
	@GetMapping("/bus/{busId}")
	   Optional<Bus> getBus(@PathVariable String busId){
		return service.getBus(busId);
	}
	//getAll buses
	@GetMapping("/getallbuses")
	  Iterable<Bus> getAllBuses(){
		return service.getAllBuses();
	}
	
	//adding the route
	@PostMapping("/route")
	String addRoute(@RequestBody Route route){
		 return routeService.addRoute(route);
	 }
	//getting all the routes
	@GetMapping("/route")
	public  List<Route> getRoutes(){
		return routeService.getAllRoutes();
	}
	//adding the agency
	@PostMapping("/agency")
	 String addAgency(@RequestBody Agency agency){
		return agencyService.addAgency(agency);
	}
	//get the agencyList
	@GetMapping("/agency")
	List<Agency> getAgencies(){
		return agencyService.getAllAgencies();
	}
	//adding the route to bus
	@PostMapping("/busRoute")
	void addBusToRoute(@RequestBody BusRouteDetails busRoute){
		busRouteService.addBusToRoute(busRoute);
	}
	//get the allactive buses
	@GetMapping("/activebuses")
	Iterable<BusRouteDetails> getAllActiveBuses(){
		return busRouteService.getAllActiveBuses();
	}
	//getAllActivebusesbasedOnBusId
	@GetMapping("/activebuses/{busId}")
	List<BusRouteDetails> getAllActiveBusesByBusId(@PathVariable String busId){
		return busRouteService.getAllActiveBusesByBusId(busId);
	}
	//delete the bus
	@DeleteMapping("/bus/{busId}")
	void deleteBus(@PathVariable String busId) {
		service.deleteBus(busId);
	}
	//updating the condtions of bus like change of fare,change of amenities
	@PutMapping("/bus/{busId}")
	void updateBus(@RequestBody Bus bus,@PathVariable String busId) {
		service.updateBus(bus);
    }
	
	//updating the route of the bus and arrival ,departure timings
	@PutMapping("/bus/update/routeofBus")
	 void updateRouteOfBus(@RequestBody Iterable<BusRouteDetails> busRouteDetails) {
		busRouteService.updateRouteOfBus(busRouteDetails);
	}
}
