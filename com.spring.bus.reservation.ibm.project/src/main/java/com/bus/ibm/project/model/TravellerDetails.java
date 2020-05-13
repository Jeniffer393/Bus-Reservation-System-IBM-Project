package com.bus.ibm.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Check;

@Entity
public class TravellerDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int travellerId;
	private String  seatNo;
	/*@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;*/
	
	@NotNull
	@NotEmpty
	private String travellerName;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "[0-9]{10}")
	private String travellerPhoneNo;
	
	@NotEmpty
	@NotNull
	@Check(constraints = "CHECK gender IN('Male','Female')")
	private String gender;
	
	private int age;
	
	
	public TravellerDetails(String seatNo, @NotNull @NotEmpty String travellerName,
			@NotEmpty @NotNull String travellerPhoneNo, @NotEmpty @NotNull String gender,int age) {
		super();
		this.seatNo = seatNo;
		this.travellerName = travellerName;
		this.travellerPhoneNo = travellerPhoneNo;
		this.gender = gender;
		this.age=age;
	}


	public TravellerDetails() {
		// TODO Auto-generated constructor stub
	}


	

	public String getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}


	/*public Booking getBooking() {
		return booking;
	}


	public void setBooking(Booking booking) {
		this.booking = booking;
	}*/


	public String getTravellerName() {
		return travellerName;
	}


	public void setTravellerName(String travellerName) {
		this.travellerName = travellerName;
	}


	public String getTravellerPhoneNo() {
		return travellerPhoneNo;
	}


	public void setTravellerPhoneNo(String travellerPhoneNo) {
		this.travellerPhoneNo = travellerPhoneNo;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	

	

}
