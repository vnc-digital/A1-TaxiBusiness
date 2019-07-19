package com.vnc.TaxiManagement.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vnc.TaxiManagement.Entity.Car;

public interface CarRepository extends CrudRepository<Car, String>{

	List<Car> findAll();

	Car findByCarId(String carId);

	Car findFirstByOrderByCarIdDesc();

	
}
