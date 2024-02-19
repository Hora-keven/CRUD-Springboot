package com.car.store.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.car.store.dtos.CarDtoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.car.store.dtos.CarDto;
import com.car.store.infra.exceptions.CarException;
import com.car.store.model.Car;
import com.car.store.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;
	
	public List<CarDtoResponse> findAll(int pageNumber, int pageSize){
		Page<Car> pageCars = repository.findAll(PageRequest.of(pageNumber, pageSize));
		List<Car> cars = pageCars.get().toList();
		List<CarDtoResponse> carsDto = new ArrayList<>();
		
		if(cars.isEmpty()) {
			throw new CarException();
		}
		for (Car car : cars) {
			var dto = new CarDtoResponse(car);
			carsDto.add(dto);
		}
		return carsDto;
	}
	public CarDtoResponse findById(long id) {
		Optional<Car> car = repository.findById(id);
		
		if(car.isEmpty()) {
			throw new CarException();
		}
		
		
		return new CarDtoResponse(car.get());
	}
	public CarDtoResponse update(CarDto carDto, long id) {
		Optional<Car> car = repository.findById(id);
		if(car.isEmpty()) {
			throw new CarException();
		}
		var carEntity = car.get();
		repository.save(carEntity);
		return new CarDtoResponse(carEntity);
		
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
