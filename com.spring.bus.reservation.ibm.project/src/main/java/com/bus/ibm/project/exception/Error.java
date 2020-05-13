package com.bus.ibm.project.exception;

public class Error {

	private String message;
	private String url;
	
	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Error() {
		// TODO Auto-generated constructor stub
	}



	public Error(String message, String url) {
	
		this.message = message;
		this.url = url;
	}

}
