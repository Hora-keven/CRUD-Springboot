package com.car.store.dtos;

import com.car.store.model.Car;
import com.car.store.model.Category;

public record CarDtoResponse (long id, String brand, String lisensePlate, int numberOfPlaces, String owner, Category category){
	
	public CarDtoResponse(Car car) {
		this(car.getId(), car.getBrand(), car.getLisensePlate(), car.getNumberOfPlaces(), car.getOwner(), car.getCategory());
	}
}
