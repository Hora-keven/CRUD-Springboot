package com.car.store.model;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="cars")
public class Car extends RepresentationModel<Car> implements Serializable{
	/////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100)
	private String brand;
	
	@Column(nullable = false, length = 100)
	private String lisensePlate;
	
	@Column(nullable = false, length = 100)
	private int numberOfPlaces;
	
	@Column(nullable = false, length = 100)
	private String owner;
	
	@Column(nullable = false, length = 100)
	private Category category;

	
	
	public Car(String brand, String lisensePlate, int numberOfPlaces, String owner, Category category) {
		
		this.brand = brand;
		this.lisensePlate = lisensePlate;
		this.numberOfPlaces = numberOfPlaces;
		this.owner = owner;
		this.category = category;
	}
	


	public Car() {
		
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getLisensePlate() {
		return lisensePlate;
	}
	public void setLisensePlate(String lisensePlate) {
		this.lisensePlate = lisensePlate;
	}
	public int getNumberOfPlaces() {
		return numberOfPlaces;
	}
	public void setNumberOfPlaces(int numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	

}
