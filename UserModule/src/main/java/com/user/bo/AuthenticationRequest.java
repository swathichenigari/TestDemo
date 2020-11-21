package com.user.bo;

import lombok.Data;

@Data
public class AuthenticationRequest {

	private String username;
	private String password;

	public AuthenticationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public AuthenticationRequest() {
		super();
	}
	
}
