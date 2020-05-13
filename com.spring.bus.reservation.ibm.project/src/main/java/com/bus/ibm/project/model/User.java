package com.bus.ibm.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user")
public class User {

  @Id
  private String userId;
  private String userName;
  private String password;
  
  @OneToMany(mappedBy="user")
  private Set<Booking>  booking=new HashSet<>();

  public String getUserId() {
	return userId;
  }


  public void setUserId(String userId) {
	this.userId = userId;
  }
  @JsonIgnore
  public String getUserName() {
	return userName;
  }

  public void setUserName(String userName) {
	this.userName = userName;
  }

  @JsonIgnore
  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }

  @JsonIgnore
  public Set<Booking> getBooking() {
	return booking;
  }

 public void setBooking(Set<Booking> booking) {
	this.booking = booking;
 }


 public User(String userId, String userName, String password) {

	this.userId = userId;
	this.userName = userName;
	this.password = password;
 }
 public User() {
	 
 }
	
}
