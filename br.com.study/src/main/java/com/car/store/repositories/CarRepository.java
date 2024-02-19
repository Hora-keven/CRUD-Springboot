package com.car.store.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.car.store.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

}
