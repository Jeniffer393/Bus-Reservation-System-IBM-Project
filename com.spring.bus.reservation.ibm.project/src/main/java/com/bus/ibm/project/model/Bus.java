package com.bus.ibm.project.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Check;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="bus")

public class Bus {
     
	
	@Id
	@Column(name="bus_id")
	private String busId;

	//@Column(columnDefinition = "CHECK(busType IN('AC','NON-AC'))")
	@NotNull
	@Check(constraints = "busType IN('Sleeper','SemiSleeper')")
	private String busType;
	@NotNull
	private int totalSeats;
	/*@NotNull
	private int seatsRemaining;*/
	@NotNull
	private double busFarePerKm;
	/*@JsonFormat(pattern = "HH:MM")
	private String  departure;
	@JsonFormat(pattern = "HH:MM")
	private String arrival;
	private String duration;*/
	//@Column(columnDefinition = "CHECK(wifi IN('YES','NO'))")
	@Check(constraints = "wifi IN('YES','NO')")
	@NotEmpty
	private String wifi;
    //@Column(columnDefinition = "CHECK(watterBottle IN('YES','NO'))")
	@Check(constraints = "watterBottle IN('AC','NONAC')")
	private String watterBottle;
    //@Column(columnDefinition = "CHECK(chargingPoint IN('YES','NO'))")
    @Check(constraints = "chargingPoint IN('AC','NONAC')")
	private String chargingPoint;
    
    @Check(constraints = "AC IN('YES','NO')")
   	private String ac;
	
	@ManyToOne
	@JoinColumn(name="agency_id")
	private Agency agency;
	
	/*@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;*/
	
	/*@OneToMany
	private Set<Route> route=new HashSet<>();	*/
	
	@OneToMany
	private Set<Booking> booking=new HashSet<>();
	
	@OneToMany
	private Set<BusRouteDetails> busRouteDetails=new HashSet<>();

	public Bus(String busId, String busType, int totalSeats, int seatsRemaining, double busFarePerKm, String departure,
			String arrival, String duration, String wifi, String watterBottle, String chargingPoint,String ac) {
		super();
		this.busId = busId;
		this.busType = busType;
		this.totalSeats = totalSeats;
		/*this.seatsRemaining = seatsRemaining;*/
		this.busFarePerKm = busFarePerKm;
		/*this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;*/
		this.wifi = wifi;
		this.watterBottle = watterBottle;
		this.chargingPoint = chargingPoint;
		this.ac=ac;
	}
    public Bus() {
    	
    }
	public String getBusId() {
		return busId;
	}

	public void setBusId(String busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String bustype) {
		this.busType = bustype;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int toatalSeats) {
		this.totalSeats = toatalSeats;
	}

	/*public int getSeatsRemaining() {
		return seatsRemaining;
	}

	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}*/

	public double getBusFarePerKm() {
		return busFarePerKm;
	}

	public void setBusFarePerKm(double busFarePerKm) {
		this.busFarePerKm = busFarePerKm;
	}

	/*public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}*/

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getWatterBottle() {
		return watterBottle;
	}

	public void setWatterBottle(String watterBottle) {
		this.watterBottle = watterBottle;
	}

	public String getChargingPoint() {
		return chargingPoint;
	}

	public void setChargingPoint(String chargingPoint) {
		this.chargingPoint = chargingPoint;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public String getAc() {
		return ac;
	}
	public void setAc(String ac) {
		this.ac = ac;
	}


	/*public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}*/
	
	
	 
	
	

	
}
