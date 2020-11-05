package com.student.registration.exceptions;

import java.util.List;

import lombok.Data;

@Data
public class ErrorMessage {

	public ErrorMessage(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	private String message;
	private List<String> details;
}
