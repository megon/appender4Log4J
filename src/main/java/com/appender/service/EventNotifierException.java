package com.appender.service;

/**
 * Exception utilizada na classe EventNotifierImpl.
 * 
 * @author Marco Rojo
 * Data: 29/01/2010
 */
public class EventNotifierException extends Exception {

	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String status;

	public EventNotifierException() {
	}

	public EventNotifierException(String arg0) {
		super(arg0);
	}

	public EventNotifierException(Throwable arg0) {
		super(arg0);
	}

	public EventNotifierException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	public EventNotifierException(int statusCode, String status){
		this.setStatusCode(statusCode);
		this.setStatus(status);
	}
	
	public String getMessage(){
		return "Invalid request! ".concat(getStatus());
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
