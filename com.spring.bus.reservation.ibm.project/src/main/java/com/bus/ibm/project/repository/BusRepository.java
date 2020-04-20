package com.bus.ibm.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bus.ibm.project.model.Bus;

@Repository
public interface BusRepository extends  CrudRepository<Bus, String> {

	
	 //List<Bus>findByRouteRouteId(String RouteId);

	

}
