package com.bus.ibm.project.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bus.ibm.project.model.Booking;

public interface BookingRepository extends CrudRepository<Booking,String> {

	public  List<Booking> findAll();
	
	List<Booking>findByUserUserId(String userId);
	@Query(value="update booking set travelling_date=? where booking_id=?;",nativeQuery = true)
	public void  updateTravellingDate(Date rescheduledDate,String bookingId);
	
	
}
