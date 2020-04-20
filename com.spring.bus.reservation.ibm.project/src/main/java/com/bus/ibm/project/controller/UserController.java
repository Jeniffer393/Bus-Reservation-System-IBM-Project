package com.bus.ibm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.ibm.project.model.Booking;
import com.bus.ibm.project.model.Bus;
import com.bus.ibm.project.model.BusRouteDetails;
import com.bus.ibm.project.model.TravellerDetails;
import com.bus.ibm.project.service.BookingService;
import com.bus.ibm.project.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	BookingService bookingService;
	
	
	
   //user can search bus
	@GetMapping("/searchbuses/{from}/{to}")
	 List<BusRouteDetails> getBuses(@PathVariable String from,@PathVariable String to){
		       return  service.getBuses(from, to);
	}
	
	//user booking the bus we generate the booking Id and bind it to path of request
	@PostMapping("/bookbus/{userId}/{busId}")
	public String bookBus(@PathVariable String userId,@RequestBody Booking booking,@PathVariable String busId){
                  return bookingService.bookSeats(userId, booking,busId);
	}
	
	//after busbooking the user entering the details of travellers
	@PostMapping("/bookbus/bookseats/{bookingId}")
	public String bookTravellerSeats(@PathVariable String bookingId,@RequestBody Iterable<TravellerDetails>travellers) {
		 return bookingService.addTravellerDetails(bookingId,travellers);
	}
	
	//user can get his bookings not the details regarding the passengers 
	
	@GetMapping("/bookings/{userId}")
	 public List<Booking>getAllBookingOfUser(@PathVariable String userId){
	   return bookingService.getBookingsOfUser(userId);
	}
    	
}
