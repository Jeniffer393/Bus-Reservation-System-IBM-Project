package com.user_admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user_admin.model.Route;


@Repository
public interface RouteRepository extends CrudRepository<Route, Integer> {

	List<Route> findByOrigin(String Origin);

	List<Route> findByDestination(String destination);
	
	List<Route> findByOriginAndDestination(String Origin,String destination);
	
	@Query(value = "delete from route where origin=?", nativeQuery = true)
	void deleteByOrigin(String origin);
	
	@Query(value = "delete from route where destination=?", nativeQuery = true)
	void deleteByDestination(String destination);
	

}
