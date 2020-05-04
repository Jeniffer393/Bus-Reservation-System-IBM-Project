package com.bus.ibm.project.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bus.ibm.project.model.BusSeatDetails;
@Repository
public interface BusSeatDetailsRepository extends CrudRepository<BusSeatDetails,Integer> {
	
	 BusSeatDetails findByBusRouteDetailsBusRouteId(int busRouteTypeId);
	 @Query(value="Select bus_seat_detail_id from bus_seat_details where bus_route_id=?;",nativeQuery=true)
	 int  getBusSeatDetails(int busRouteId);
	 
	 @Transactional
	 @Modifying
	 void deleteByBusRouteDetailsBusRouteId(int busRouteId);
	 
	 @Transactional
	 @Modifying
	 @Query(value="update bus_seat_details set seats_remaining=?  where bus_route_id=?;",nativeQuery = true)
	 public void updateRemainingSeats(int remainingSeats,int busRouteId);
	 
	 @Transactional
	 @Modifying
	 @Query(value="insert into bus_seat_details_booked_seats_numbers values(?,?)",nativeQuery = true)
	 public void updateBookedSeats(int busSeatId,String bookedSeats);
	
    
	 //for executing the update and delete transactional is required

	 
	 
	

}
