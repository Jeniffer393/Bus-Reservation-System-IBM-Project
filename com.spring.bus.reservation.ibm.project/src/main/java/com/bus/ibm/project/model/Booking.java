package com.bus.ibm.project.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Booking {

	@Id
	@Length(max=10)
	private String bookingId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="bus_id")
	private Bus bus;
	
	/*@OneToMany
	private Set<TravellerDetails> bookingDetails=new HashSet<>();*/
	
	@UpdateTimestamp
	private Timestamp bookedDate;
	
	
	private Date travellingDate;
	
	@NotNull
	@NotEmpty
	private String pickUpPoint;
	
	@NotNull
	@NotEmpty
	private String droppingPoint;
	
	private double totalFare;
	
	private int  totalSeatsBooked;
	
	private String bookedSeats[];

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   /* @JsonIgnore
	public Set<TravellerDetails> getBookingDetails() {
		return bookingDetails;
	}

	/*public void setBookingDetails(Set<TravellerDetails> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
    
	
	/*public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}*/

	public Timestamp getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Timestamp bookedDate) {
		this.bookedDate = bookedDate;
	}

	public Date getTravellingDate() {
		return travellingDate;
	}

	public void setTravellingDate(Date travellingDate) {
		this.travellingDate = travellingDate;
	}

	public String getPickUpPoint() {
		return pickUpPoint;
	}

	public void setPickUpPoint(String pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}

	public String getDroppingPoint() {
		return droppingPoint;
	}

	public void setDroppingPoint(String droppingPoint) {
		this.droppingPoint = droppingPoint;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	/*public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}*/

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	public Booking(@Length(max = 10) String bookingId, User user, Bus bus, Timestamp bookedDate, Date travellingDate,
			@NotEmpty String pickUpPoint, @NotEmpty String droppingPoint, double totalFare, int totalSeatsBooked,
			String[] bookedSeats) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.bus = bus;
		this.bookedDate = bookedDate;
		this.travellingDate = travellingDate;
		this.pickUpPoint = pickUpPoint;
		this.droppingPoint = droppingPoint;
		this.totalFare = totalFare;
		this.totalSeatsBooked = totalSeatsBooked;
		this.bookedSeats = bookedSeats;
	}


	/*public Booking(String bookingId, Timestamp bookedDate, Date travellingDate, @NotEmpty String pickUpPoint,
			@NotEmpty String droppingPoint, double totalFare, int bookedSeats) {
		this.bookingId = bookingId;
		this.bookedDate = bookedDate;
		this.travellingDate = travellingDate;
		this.pickUpPoint = pickUpPoint;
		this.droppingPoint = droppingPoint;
		this.totalFare = totalFare;
		this.bookedSeats = bookedSeats;
	}*/
	public Booking() {
		
	}

	

	public String[] getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(String[] bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	
	public int getTotalSeatsBooked() {
		return totalSeatsBooked;
	}

	public void setTotalSeatsBooked(int totalSeatsBooked) {
		this.totalSeatsBooked = totalSeatsBooked;
	}

	
    
	
	
	
	
	
	
	
}
