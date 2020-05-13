package com.bus.ibm.project.exception;

public class BusRouteException extends Exception{
    String message;
	public BusRouteException(String message) {
		this.message=message;
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	
}
