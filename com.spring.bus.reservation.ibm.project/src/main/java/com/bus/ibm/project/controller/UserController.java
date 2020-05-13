package com.bus.ibm.project.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.ibm.project.exception.BusNotFoundException;
import com.bus.ibm.project.exception.NoseatsBookedException;
import com.bus.ibm.project.exception.SameSeatException;
import com.bus.ibm.project.exception.SeatBookedException;
import com.bus.ibm.project.model.Booking;
import com.bus.ibm.project.model.Bus;
import com.bus.ibm.project.model.BusRouteDetails;
import com.bus.ibm.project.model.BusSeatDetails;
import com.bus.ibm.project.model.TravellerDetails;
import com.bus.ibm.project.repository.BusSeatDetailsRepository;
import com.bus.ibm.project.service.BookingService;
import com.bus.ibm.project.service.UserService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders="*")
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	BookingService bookingService;
	@Autowired
	BusSeatDetailsRepository bus;
	
	
	
   //user can search bus
	@GetMapping("/searchbuses/{from}/{to}")
	 List<BusRouteDetails> getBuses(@PathVariable String from,@PathVariable String to) throws BusNotFoundException{
		          return  service.getBuses(from, to);
		         
	}
	@GetMapping("/searchseats/{busRouteId}")
	BusSeatDetails searchSeats(@PathVariable int busRouteId) throws NoseatsBookedException {
		         return service.searchSeats(busRouteId);
	}
	@GetMapping("/searchseats/bus/{busRoutetypeId}")
	BusSeatDetails searchSeats1(@PathVariable int busRouteId) throws NoseatsBookedException {
		         return bus.findByBusRouteDetailsBusRouteId(busRouteId);
	}
	        
	
	//user booking the bus we generate the booking Id and bind it to path of request
	@PostMapping("/bookbus/{userId}/{busRouteId}")
	public String bookBus(@PathVariable String userId,@RequestBody Booking booking,@PathVariable int busRouteId) throws SeatBookedException, SameSeatException{
                  return bookingService.bookSeats(userId, booking,busRouteId);
	}
	
	//after busbooking the user entering the details of travellers
	/*@PostMapping("/bookbus/bookseats/{bookingId}")
	public String bookTravellerSeats(@PathVariable String bookingId,@RequestBody Iterable<TravellerDetails>travellers) throws SeatBookedException, SameSeatException  {
		 return bookingService.addTravellerDetails(bookingId,travellers);
	}*/
	
	//user can get his bookings not the details regarding the passengers 
	
	@GetMapping("/bookings/{userId}")
	 public List<Booking>getAllBookingOfUser(@PathVariable String userId){
	   return bookingService.getBookingsOfUser(userId);
	}
	
	
	//Rescheduling the ticket
	//returning just succesfull message later we need to send message 
	@PutMapping("/booking/reschedule/{bookingId}")
	public String rescheduleBooking(@PathVariable String booKingId,@RequestBody Date rescheduledDate) {
		   return bookingService.rescheduleBooking(rescheduledDate, booKingId);
	}
	
	//just to test the angular part
	
	@GetMapping("/getuser/{userName}")
	public String getUserName(@PathVariable String userName) {
		 return userName;
	}

    	
}
