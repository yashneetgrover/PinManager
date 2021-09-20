package com.pin.manager.exception;

public class InvalidMsisdnException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMsisdnException() {
		
		super("Invalid MSISDN.");
		System.out.println("Invalid MSISDN");
		
	}
}
