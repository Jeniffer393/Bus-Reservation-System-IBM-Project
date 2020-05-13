package com.bus.ibm.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="route")
public class Route {

	@Id
	private String routeId;
	
	@NotNull
    @NotEmpty
	private String source;
	
	@NotNull
	@NotEmpty
	private String destination;
	
	private  int   distance;
	
	/*@OneToMany(mappedBy = "route")
	private Set<Bus> buses=new HashSet<>();*/
	
	/*@ManyToOne
	@JoinColumn(name="bus_id")
	private Bus bus;*/

	@OneToMany(mappedBy = "route")
	private Set<BusRouteDetails> busRouteDetails=new HashSet<>();
	
	
	
	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Route(String routeId, @NotEmpty String source, @NotEmpty String destination, int distance) {
		
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
    /*@JsonIgnore
	public Set<Bus> getBuses() {
		return buses;
	}

	public void setBuses(Set<Bus> buses) {
		this.buses = buses;
	}*/
	
	
   public Route() {
	   
   }

  /* public Bus getBus() {
	return bus;
  }

  public void setBus(Bus bus) {
	this.bus = bus;
  }*/
 //need to add getters and setters of busrouteDetails
	
	
}
