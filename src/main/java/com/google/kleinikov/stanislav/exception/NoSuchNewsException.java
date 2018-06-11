package com.google.kleinikov.stanislav.exception;

public class NoSuchNewsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchNewsException() {
		super();
	}

	public NoSuchNewsException(String message) {
		super(message);
	}
}
