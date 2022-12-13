package com.customer.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private String message;
	
	public ResourceNotFoundException(String message) {
		this.message = message;
	}
}
