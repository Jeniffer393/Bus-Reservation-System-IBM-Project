package com.bus.ibm.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NoseatsBookedException extends Exception {
    String message;
	public NoseatsBookedException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
	

}
