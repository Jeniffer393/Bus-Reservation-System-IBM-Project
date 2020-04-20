package com.bus.ibm.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.ibm.project.model.Booking;
import com.bus.ibm.project.model.Bus;
import com.bus.ibm.project.model.BusRouteDetails;
import com.bus.ibm.project.model.TravellerDetails;
import com.bus.ibm.project.model.User;
import com.bus.ibm.project.repository.BookingRepository;
import com.bus.ibm.project.repository.BusRepository;
import com.bus.ibm.project.repository.BusRouteRepository;
import com.bus.ibm.project.repository.RouteRepository;
import com.bus.ibm.project.repository.TravellerRepository;
import com.bus.ibm.project.repository.UserRepository;
@Service
public class UserService {

	@Autowired
	RouteRepository routeRepo;
	@Autowired
	BusRepository busRepo;
	@Autowired
	BookingRepository bookingRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	TravellerRepository travellerRepo;
	@Autowired
	BusRouteRepository busRouteRepo;
	
	//searching the bus based on user values
     public List<BusRouteDetails>	getBuses(String from,String to){
		   String routeId=routeRepo.getRouteId(from, to);
		   return  busRouteRepo.findByRouteRouteId(routeId);          
	}
    
    public String bookSeats(String userId,Booking booking,String busId) {
    	//just to demonstrate
    	User user=new User();
    	user.setUserId(userId);
    	userRepo.save(user);
    	Optional<Bus> bus=busRepo.findById(busId);
    	double totalFare=bus.get().getBusFarePerKm()*booking.getBookedSeats();
        
    	
    	
       List<Booking> bookings=bookingRepo.findAll();
       if(bookings.isEmpty()) {
    	  booking.setBookingId("RB00000001");
    	  booking.setUser(user);
    	  booking.setBus(new Bus(busId,"",0,0,0.0,"","","","","",""));
    	  booking.setTotalFare(totalFare);
    	  bookingRepo.save(booking);	
    	  return "RB00000001";
       }else {
    	int maxId=0;
    	int lastZeroIndex=0;
    	String  newBookingId;
    	for(Booking newBooking:bookings) {
    		int bookingId=Integer.parseInt(newBooking.getBookingId().substring(2));
    		if((bookingId)>maxId) {
    			maxId=bookingId;
    		 lastZeroIndex=newBooking.getBookingId().lastIndexOf('0');
    		}
    	}
    	   int newMaxId=maxId+1;
    	   if(lastZeroIndex==2) {
    		  newBookingId="RB"+""+newMaxId+"";
    		  } else {  
    	        int formatingValue=lastZeroIndex-1;
    	        newBookingId ="RB"+String.format("%0"+lastZeroIndex+"d", newMaxId);	    
              }
    	   
    	   booking.setBookingId(newBookingId);
    	   booking.setUser(user);
    	   booking.setBus(new Bus(busId,"",0,0,0.0,"","","","","",""));
    	   booking.setTotalFare(totalFare);
    	   bookingRepo.save(booking);
    	   return newBookingId;   
    	   //this bookingId need to be binded in frontEnd
       }
        
	}
    public  String  addTravellerDetails(String bookingId,Iterable<TravellerDetails> travellers){
    	  for(TravellerDetails traveller:travellers) {
    		   traveller.setBooking(new Booking(bookingId,null, null, "","",0.0,0));
    	  }
    	  travellerRepo.saveAll(travellers);
    	  return bookingId;
    	  
    }
    
       
}
