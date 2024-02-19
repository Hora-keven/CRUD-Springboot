package com.car.store.controllers;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.car.store.dtos.CarDto;
import com.car.store.dtos.CarDtoResponse;
import com.car.store.model.Car;
import com.car.store.services.CarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id")long id)throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(carService.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<CarDtoResponse>> findAll(@RequestParam(defaultValue = "0") @PositiveOrZero int page, @RequestParam(defaultValue = "10") @Positive @Max(100) int pageSize){

		return ResponseEntity.status(HttpStatus.OK).body(carService.findAll(page, pageSize));
	}
	
	@PostMapping()
	public ResponseEntity<Object> create(@RequestBody @Valid CarDto carDto)throws Exception{
		return ResponseEntity.status(HttpStatus.CREATED).body(carService.create(carDto));
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") long id, @RequestBody @Valid CarDto carDto) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(carService.update(carDto, id));
	}
}
