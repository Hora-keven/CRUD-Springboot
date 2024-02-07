package com.car.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.store.dtos.CarDto;
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
	public ResponseEntity<List<Car>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(carService.findAll());
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
