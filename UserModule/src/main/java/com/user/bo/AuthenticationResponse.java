package com.user.bo;

import lombok.Data;

@Data
public class AuthenticationResponse {

	public AuthenticationResponse(String jwtToken2) {
		this.jwtToken = jwtToken2;
	}

	private String jwtToken;

	public AuthenticationResponse() {
		super();
	}
}
