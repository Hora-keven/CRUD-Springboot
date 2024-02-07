package com.car.store.infra.exceptions;

public class UserException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public UserException() {
		super("User not found!");
	}
	public UserException(String message) {
		super(message);
	}
}
