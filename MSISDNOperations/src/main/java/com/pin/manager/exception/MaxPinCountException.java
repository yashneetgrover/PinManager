package com.pin.manager.exception;

public class MaxPinCountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaxPinCountException(int maxCount) {
		
		super("Max PIN count Exceeded : "+maxCount);
		System.out.println("Max PIN count Exceeded : "+maxCount);
		
	}
}
