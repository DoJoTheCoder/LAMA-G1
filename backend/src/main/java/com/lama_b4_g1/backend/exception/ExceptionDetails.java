package com.lama_b4_g1.backend.exception;

public class ExceptionDetails {
	
	private String message;
	private int statusCode;
	
	public ExceptionDetails(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
