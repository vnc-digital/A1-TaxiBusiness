package com.vnc.TaxiManagement.Service;

import com.vnc.TaxiManagement.Entity.Car;

public interface CarService{

	Iterable<Car> getAllCars();

	String getNextCarId();

	void saveInfo(Car car);

	//String getNextCarId();

}
