package com.model;

public class NullException extends Exception {
	/**
	 * 
	 * This class represents an exception that occurs when a user tries to enter a null value for amount .
	 */
	String message;
	public NullException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return message;
	}
}
