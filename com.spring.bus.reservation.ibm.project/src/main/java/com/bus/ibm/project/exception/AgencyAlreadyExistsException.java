package com.bus.ibm.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class AgencyAlreadyExistsException extends Exception {
    String message;
	public AgencyAlreadyExistsException(String message) {
		this.message=message;
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	

}
