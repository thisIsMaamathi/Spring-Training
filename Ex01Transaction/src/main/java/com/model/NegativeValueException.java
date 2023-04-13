package com.model;

public class NegativeValueException extends Exception{
	/**
	 * 
	 * This class represents an exception that occurs when a user tries to enter a negative value for amount .
	 */

	 
	String message;
	public NegativeValueException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return message;
	}
}
