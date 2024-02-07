package com.car.store.services;

import java.util.List;
import java.util.Optional;

import com.car.store.dtos.CarDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.store.dtos.CarDto;
import com.car.store.infra.exceptions.CarException;
import com.car.store.model.Car;
import com.car.store.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;
	
	public List<Car> findAll(){
		List<Car> cars = repository.findAll();
		
		if(cars.isEmpty()) {
			throw new CarException();
		}
		return cars;
	}
	public Car findById(long id) {
		Optional<Car> car = repository.findById(id);
		if(car.isEmpty()) {
			throw new CarException();
		}
		
		
		return car.get();
	}
	public CarDto update(CarDto carDto, long id) {
		Optional<Car> car = repository.findById(id);
		if(car.isEmpty()) {
			throw new CarException();
		}
		var carEntity = car.get();
		repository.save(carEntity);
		return carDto;
		
	}
	public CarDtoResponse create(CarDto carDto) {
		var carEntity = new Car(carDto.brand(), carDto.lisensePlate(), carDto.numberOfPlaces(), carDto.owner(), carDto.category());
		repository.save(carEntity);
		return new CarDtoResponse(carEntity);
	}
	
	public void delete(long id) {
		Optional<Car> car = repository.findById(id);
		if(car.isEmpty()) {
			throw new CarException();
		}
		repository.delete(car.get());
	}
}
