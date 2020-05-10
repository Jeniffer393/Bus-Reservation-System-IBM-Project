package com.bus.ibm.project.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bus.ibm.project.exception.SameSeatException;
import com.bus.ibm.project.exception.SeatBookedException;
import com.bus.ibm.project.model.Booking;
import com.bus.ibm.project.model.Bus;
import com.bus.ibm.project.model.BusRouteDetails;
import com.bus.ibm.project.model.BusSeatDetails;
import com.bus.ibm.project.model.TravellerDetails;
import com.bus.ibm.project.repository.BookingRepository;
import com.bus.ibm.project.repository.BusRepository;
import com.bus.ibm.project.repository.BusRouteRepository;
import com.bus.ibm.project.repository.BusSeatDetailsRepository;
import com.bus.ibm.project.repository.RouteRepository;

@Service
public class BusSeatDetailsService {
	@Autowired
	BookingRepository bookingRepo;
	@Autowired
	RouteRepository   routeRepo;
	@Autowired
	BusRouteRepository  busRouteRepo;
	@Autowired
	BusSeatDetailsRepository busSeatDetailRepo;
	@Autowired
	BusRepository busRepo;
	
	    /*  public void  addbusSeatDetails(Iterable<TravellerDetails> travellers,String  bookingId) throws SeatBookedException, SameSeatException {
	    	     Optional<Booking> booking=bookingRepo.findById(bookingId);
	    	     String busId=booking.get().getBus().getBusId();
	    	     String source=booking.get().getPickUpPoint();
	    	     String destination=booking.get().getDroppingPoint();
	    	     String routeId=routeRepo.getRouteId(source,destination);
	    	     int  busRouteTypeId=busRouteRepo.searchBusRoute(busId, routeId).getBusRouteId();
	    	     Set<String> seats=new HashSet<>();
	    	     BusSeatDetails busSeatDetails=busSeatDetailRepo.findByBusRouteDetailsBusRouteId(busRouteTypeId);
	    	     if(busSeatDetails==null) {
	    	    	 int travellerCount=0;
	    	    	 Set<String> travellerSeats=new HashSet<>();
	    	    	  for(TravellerDetails traveller:travellers) {
	    	    		  travellerSeats.add(traveller.getSeatNo());
	    	    		  travellerCount++;
	    	    		  
	    	    	  }
	    	    	  if(travellerCount>travellerSeats.size()) {
	    	    		  bookingRepo.deleteById(bookingId);
	    	    		  throw new SameSeatException("Travellers cannot have same seat");
	    	    	  }
	    	    	  else {
	    	    		  int totalSeats=busRepo.findById(busId).get().getTotalSeats();
	    		    	     BusSeatDetails newBusSeatDetails=new BusSeatDetails();
	    		    	     newBusSeatDetails.setBookedSeatsNumbers(travellerSeats);
	    		    	     newBusSeatDetails.setTotalSeats(totalSeats);
	    		    	     newBusSeatDetails.setSeatsRemaining(totalSeats-travellerSeats.size());
	    		    	     newBusSeatDetails.setBusRouteDetails(new BusRouteDetails(busRouteTypeId, null, null,null, null, ""));
	    		    	     busSeatDetailRepo.save(newBusSeatDetails);
	    	    	  }
	    	    	 
	    	     }else {
	    	    	  
	    	     for(TravellerDetails traveller:travellers) {
	    	    	if(busSeatDetailRepo.findByBusRouteDetailsBusRouteId(busRouteTypeId).getBookedSeatsNumbers().contains(traveller.getSeatNo())) {
	    	    		bookingRepo.deleteById(bookingId);//user needs to be redirected to again booking page
	    	    		throw new SeatBookedException("Seat No with"+traveller.getSeatNo()+"is already booked");
	    	    	 }else {
	   
	    	    		   seats.add(traveller.getSeatNo());
	    	    	 }
	    	     }
	    	     int totalSeats=busRepo.findById(busId).get().getTotalSeats();
	    	     int seatsRemaining=busSeatDetails.getSeatsRemaining()-seats.size();
	    	     int busSeatId=busSeatDetailRepo.getBusSeatDetails(busRouteTypeId);
	    	     //BusSeatDetails newbusSeatDetails=new BusSeatDetails();
	    	     // newbusSeatDetails.setBookedSeatsNumbers(seats);
	    	     // newbusSeatDetails.setTotalSeats(totalSeats);
	    	     //newbusSeatDetails.setSeatsRemaining(totalSeats-seats.size());
	    	     //newbusSeatDetails.setBusRouteDetails(new BusRouteDetails(busRouteTypeId, null, null, "", "", ""));
	    	     busSeatDetailRepo.updateRemainingSeats(seatsRemaining, busRouteTypeId); 
	    	     for(String  seat:seats) {
	    	     busSeatDetailRepo.updateBookedSeats(busSeatId,seat);
	    	     
	    	     }
	         
	    	     
	       }
	      }*/
	     
	  public void  addbusSeatDetails(Booking booking,int busRouteId) throws SeatBookedException, SameSeatException {
	    /* Optional<Booking> booking=bookingRepo.findById(bookingId);
	     String busId=booking.get().getBus().getBusId();
	     String source=booking.get().getPickUpPoint();
	     String destination=booking.get().getDroppingPoint();
	     String routeId=routeRepo.getRouteId(source,destination);
	     int  busRouteTypeId=busRouteRepo.searchBusRoute(busId, routeId).getBusRouteId();*/
	     Set<String> seats=new HashSet<>();
	     Optional<BusRouteDetails> busRouteDetails=busRouteRepo.findById(busRouteId);
	     Bus bus=busRouteDetails.get().getBus();
	     BusSeatDetails busSeatDetails=busSeatDetailRepo.findByBusRouteDetailsBusRouteId(busRouteId);
	     if(busSeatDetails==null) {
	    	 int travellerCount=0;
	    	 Set<String> travellerSeats=new HashSet<>();
	    	  for(String busSeats:booking.getBookedSeats()) {
	    		  travellerSeats.add(busSeats);
	    		  travellerCount++;
	    		  
	    	  }
	    	  if(travellerCount>travellerSeats.size()) {
	    		 // bookingRepo.deleteById(bookingId);
	    		  throw new SameSeatException("Travellers cannot have same seat");
	    	  }
	    	  else {
	    		  int totalSeats=busRepo.findById(bus.getBusId()).get().getTotalSeats();
		    	     BusSeatDetails newBusSeatDetails=new BusSeatDetails();
		    	     newBusSeatDetails.setBookedSeatsNumbers(travellerSeats);
		    	     newBusSeatDetails.setTotalSeats(totalSeats);
		    	     newBusSeatDetails.setSeatsRemaining(totalSeats-travellerSeats.size());
		    	     newBusSeatDetails.setBusRouteDetails(new BusRouteDetails(busRouteId, null, null,null, null, ""));
		    	     busSeatDetailRepo.save(newBusSeatDetails);
	    	  }
	    	 
	     }else {
	    	  
	     for(String busSeats :booking.getBookedSeats()) {
	    	if(busSeatDetailRepo.findByBusRouteDetailsBusRouteId(busRouteId).getBookedSeatsNumbers().contains(busSeats)) {
	    		//bookingRepo.deleteById(bookingId);//user needs to be redirected to again booking page
	    		throw new SeatBookedException("Seat No with"+busSeats+"is already booked");
	    	 }else {

	    		   seats.add(busSeats);
	    	 }
	     }
	     int totalSeats=busRepo.findById(bus.getBusId()).get().getTotalSeats();
	     int seatsRemaining=busSeatDetails.getSeatsRemaining()-seats.size();
	     int busSeatId=busSeatDetailRepo.getBusSeatDetails(busRouteId);
	     //BusSeatDetails newbusSeatDetails=new BusSeatDetails();
	     // newbusSeatDetails.setBookedSeatsNumbers(seats);
	     // newbusSeatDetails.setTotalSeats(totalSeats);
	     //newbusSeatDetails.setSeatsRemaining(totalSeats-seats.size());
	     //newbusSeatDetails.setBusRouteDetails(new BusRouteDetails(busRouteTypeId, null, null, "", "", ""));
	     busSeatDetailRepo.updateRemainingSeats(seatsRemaining, busRouteId); 
	     for(String  seat:seats) {
	     busSeatDetailRepo.updateBookedSeats(busSeatId,seat);
	     
	     }
     
	     
   }
  }
	    	       
	      
	       public Iterable<BusSeatDetails> getBookedSeatsOfBus(){
	    	   return busSeatDetailRepo.findAll();
	       }
	       
	       
	       public void DeleteBusSeatDetails(List<Integer> busRouteId) {
	    	    for(Integer existingbusRouteId:busRouteId) {
	    	    	 busSeatDetailRepo.deleteByBusRouteDetailsBusRouteId(existingbusRouteId);
	    	    }
	       }

		
}
