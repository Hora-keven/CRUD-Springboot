package com.car.store.infra.exceptions;

import org.springframework.http.HttpStatus;

public class TokenResponse {
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	private String message;
	private HttpStatus status;

}
