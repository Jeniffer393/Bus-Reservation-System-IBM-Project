package com.bus.ibm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bus.ibm.project.model.Bus;

@Repository
public interface BusRepository extends  CrudRepository<Bus, String> {

	
	 //List<Bus>findByRouteRouteId(String RouteId);
	 @Query(value="Select * from bus where bus_id=?;",nativeQuery=true)
     public Bus getBus(String busId);
	

}
