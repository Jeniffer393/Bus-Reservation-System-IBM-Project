package com.bus.ibm.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BusSeatDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busSeatDetailId;
	
	@OneToOne
	@JoinColumn(name="bus_route_id")
	private BusRouteDetails busRouteDetails;
	
	@ElementCollection
	@Column(name="booked_seats_numbers")
	private Set<String> bookedSeatsNumbers=new HashSet<>();
	
	private int totalSeats;
	
	private int seatsRemaining;

	public int getBusSeatDetailId() {
		return busSeatDetailId;
	}

	public void setBusSeatDetailId(int busSeatDetailId) {
		this.busSeatDetailId = busSeatDetailId;
	}

	public BusRouteDetails getBusRouteDetails() {
		return busRouteDetails;
	}

	public void setBusRouteDetails(BusRouteDetails busRouteDetails) {
		this.busRouteDetails = busRouteDetails;
	}

	
    
	public Set<String> getBookedSeatsNumbers() {
		return bookedSeatsNumbers;
	}

	public void setBookedSeatsNumbers(Set<String> bookedSeatsNumbers) {
		this.bookedSeatsNumbers = bookedSeatsNumbers;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public int getSeatsRemaining() {
		return seatsRemaining;
	}

	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}

	
	public BusSeatDetails(int busSeatDetailId, Set<String> bookedSeatsNumbers, int totalSeats, int seatsRemaining) {
		this.busSeatDetailId = busSeatDetailId;
		this.bookedSeatsNumbers = bookedSeatsNumbers;
		this.totalSeats = totalSeats;
		this.seatsRemaining = seatsRemaining;
	}

	public BusSeatDetails() {
		
	}
	

}
