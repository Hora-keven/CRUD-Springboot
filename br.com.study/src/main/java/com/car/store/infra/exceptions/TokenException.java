package com.car.store.infra.exceptions;

import org.springframework.http.HttpStatus;

public class TokenException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	
	
	public TokenException() {
		super("Token invalid!!");
	}
	public TokenException(String message) {
		super(message);
	}
}
