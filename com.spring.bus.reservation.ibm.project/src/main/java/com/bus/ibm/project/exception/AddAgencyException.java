package com.bus.ibm.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AddAgencyException extends Exception {
    String  messsage="Agency is not added add agency first";
	public AddAgencyException(String message) {
	      this.messsage=message;
		// TODO Auto-generated constructor stub
	}
	public String getMesssage() {
		return messsage;
	}
    
}
