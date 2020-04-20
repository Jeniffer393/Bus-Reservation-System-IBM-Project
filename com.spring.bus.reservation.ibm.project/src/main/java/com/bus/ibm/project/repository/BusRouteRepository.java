package com.bus.ibm.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bus.ibm.project.model.BusRouteDetails;

@Repository
public interface BusRouteRepository  extends CrudRepository<BusRouteDetails,Integer>{
	public List<BusRouteDetails> findByRouteRouteId(String RouteId);
    //to be used in sending the mail in BookingService
	@Query(value="select * from bus_route_details where bus_id=? and route_id=?;",nativeQuery=true)
	public BusRouteDetails searchBusRoute(String busId,String routeId);
	//to get the active bus details based on busId
	public List<BusRouteDetails> findByBusBusId(String busId);
	//to delete the busRouteDetails of particular bus when bus got deleted from the database
	@Transactional
	@Modifying
	@Query(value="DELETE FROM bus_route_details where bus_id=?;",nativeQuery = true)
	public void deleteByBusBusId(String busId);

	
	//public void  deleteByBusBusId(String busId);
	
}
