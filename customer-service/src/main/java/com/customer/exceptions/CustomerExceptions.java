package com.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptions {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResourceNotFoundException> handleException(ResourceNotFoundException message) {
		return new ResponseEntity<ResourceNotFoundException>(message, HttpStatus.NOT_FOUND);
	}

}
