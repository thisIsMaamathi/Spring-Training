package com.model;

public class InsufficientBalance extends Exception {

	/**
	 * This class represents an exception that occurs when a user tries to perform
	 * an operation that requires a balance greater than the current balance.
	 */

	String message;
	public InsufficientBalance(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return message;
	}
}