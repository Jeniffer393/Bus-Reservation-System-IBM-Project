package com.bus.ibm.project.model;

import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

//ManyToManyRelationalTable Of Bus And Route
@Entity
public class BusRouteDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int busRouteId;
	
	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
	
	
	@DateTimeFormat
	private LocalDateTime departure;
	
	@DateTimeFormat
	private  LocalDateTime arrival;
	
	@NotEmpty
	@NotNull
	private String duration;
	
	@OneToOne
	private BusSeatDetails busseatDetails;

	

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public LocalDateTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	public LocalDateTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public BusRouteDetails(int busRouteId, Bus bus, Route route, @NotEmpty  LocalDateTime departure,
			@NotEmpty @NotEmpty LocalDateTime arrival, @NotEmpty String duration) {
		this.busRouteId = busRouteId;
		this.bus = bus;
		this.route = route;
		this.departure = departure;
		this.arrival = arrival;
		this.duration = duration;
	}
	public int getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(int busRoute_Id) {
		this.busRouteId = busRoute_Id;
	}

	public BusRouteDetails() {
		
	}

}
