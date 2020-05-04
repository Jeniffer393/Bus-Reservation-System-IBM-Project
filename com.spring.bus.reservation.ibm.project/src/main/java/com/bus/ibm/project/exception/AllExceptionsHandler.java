package com.bus.ibm.project.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
@RestController
public class AllExceptionsHandler  extends ResponseEntityExceptionHandler{
	;

	 @ExceptionHandler(BusNotFoundException.class)
	 public org.springframework.http.ResponseEntity<Error> busNotFoundHandler(BusNotFoundException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());   
		    error.setUrl(request.getDescription(false));
		    return new org.springframework.http.ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	  }
	 
	 
	 
	 @ExceptionHandler(SeatBookedException.class)
	 public org.springframework.http.ResponseEntity<Error>  bookedSeatHandler(SeatBookedException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());  
		    error.setUrl(request.getDescription(false));
		    return new org.springframework.http.ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 
	 @ExceptionHandler(SameSeatException.class)
	 public org.springframework.http.ResponseEntity<Error>  sameSeatHandler(SameSeatException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());  
		    error.setUrl(request.getDescription(false));
		    return new org.springframework.http.ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 @ExceptionHandler(AgencyAlreadyExistsException.class)
	 public org.springframework.http.ResponseEntity<Error>  agencyHandler(AgencyAlreadyExistsException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());   
		    error.setUrl(request.getDescription(false));
		    return new org.springframework.http.ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 @ExceptionHandler(RouteAlreadyExistsException.class)
	 public Error  routeHandler(RouteAlreadyExistsException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());   
		    error.setUrl(request.getDescription(false));
		    return (error);
	  }
	 
	 @ExceptionHandler(BusAlreadyExistsException.class)
	 public org.springframework.http.ResponseEntity<Error>  busHandler(BusAlreadyExistsException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());   
		    error.setUrl(request.getDescription(false));
		    return new org.springframework.http.ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	  }
	 
	 @ExceptionHandler(AddAgencyException.class)
	 public org.springframework.http.ResponseEntity<Error>  addAgencyFirstHandler(AddAgencyException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());   
		    error.setUrl(request.getDescription(false));
		    return new org.springframework.http.ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 @ExceptionHandler(BusRouteException.class)
	 public org.springframework.http.ResponseEntity<Error>  busRouteHandler(BusRouteException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());   
		    error.setUrl(request.getDescription(false));
		    return new org.springframework.http.ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 @ExceptionHandler(NoseatsBookedException.class)
	 public org.springframework.http.ResponseEntity<Error>  seatHandler(NoseatsBookedException exception,WebRequest request){
		    Error error=new Error();
	        error.setMessage(exception.getMessage());   
		    error.setUrl(request.getDescription(false));
		    return new org.springframework.http.ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }

	 
	 
	 
}
