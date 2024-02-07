package com.car.store.infra.exceptions;

public class CarException extends RuntimeException {
	private String message;

	public CarException(String message) {
		super(message);
	
	}
	public CarException(){
		super("Car not found!");
	}
}
