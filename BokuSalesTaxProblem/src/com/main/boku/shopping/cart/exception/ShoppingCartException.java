package com.main.boku.shopping.cart.exception;

public class ShoppingCartException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String mistake;

	// Default constructor - initializes instance variable to unknown
	public ShoppingCartException() {
		super(); // call superclass constructor
		mistake = "unknown";
	}

	// Constructor receives some kind of message that is saved in an instance
	// variable.
	public ShoppingCartException(String err) {
		super(err); // call super class constructor
		mistake = err; // save message
	}

	// public method, callable by exception catcher. It returns the error
	// message.
	public String getError() {
		return mistake;
	}
}
