package com.student.registration.exceptions;

public class NoSuchStudent extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NoSuchStudent(String message) {
		super(message);
	}
	
}
