package com.car.store.dtos;

import com.car.store.model.Category;

public record CarDto (String brand, String lisensePlate, int numberOfPlaces, String owner, Category category){



}
