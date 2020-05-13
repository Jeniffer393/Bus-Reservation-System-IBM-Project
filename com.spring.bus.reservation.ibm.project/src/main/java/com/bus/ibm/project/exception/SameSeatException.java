package com.bus.ibm.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SameSeatException extends Exception {
    String message;
	public SameSeatException(String message) {
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
	
}
