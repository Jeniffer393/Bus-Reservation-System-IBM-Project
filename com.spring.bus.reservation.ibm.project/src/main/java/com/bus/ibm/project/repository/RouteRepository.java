package com.bus.ibm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bus.ibm.project.model.Route;

public interface RouteRepository extends CrudRepository<Route, String> {

	@Query(value="select route_id from route where source=? and destination=?; ",nativeQuery = true)
	public String getRouteId(String from,String to);
	//have to add equals ignore cases
	@Query(value="select * from route where source=? and destination=?;",nativeQuery = true)
    public Route getRoute(String source,String destination);
	
	List<Route> findAll();
}
