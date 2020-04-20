package com.bus.ibm.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bus.ibm.project.model.Booking;

public interface BookingRepository extends CrudRepository<Booking,String> {

	public  List<Booking> findAll();
	
	List<Booking>findByUserUserId(String userId);
	
	
}
