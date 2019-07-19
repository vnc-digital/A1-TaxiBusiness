package com.vnc.TaxiManagement.ServiceImpl;

import java.sql.Timestamp;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnc.TaxiManagement.Dao.CarRepository;
import com.vnc.TaxiManagement.Entity.Car;

import com.vnc.TaxiManagement.Service.CarService;

@Service
public class CarServiceImpl implements CarService {

	
	@Autowired
	CarRepository carRepo;
	
	@Autowired
	DriverServiceImpl driverServiceImpl;
	
	@Autowired
	CarServiceImpl carServiceImpl;
	
	public Car save(Car car) {
		return carRepo.save(car);
	}

	public List<Car> getCar() {
		
		return (List<Car>) carRepo.findAll();
	}


	public Car findByCarId(String carId) {
		
		return carRepo.findByCarId(carId);
	}
	
	@Override
	public String getNextCarId() {
		Car car= carRepo.findFirstByOrderByCarIdDesc();
		String nextCar=null;
		if(car==null)
		{
			nextCar="CR00000001";
		}
		else
		{
			String lastCar=car.getCarId();
			
			int carIntId=Integer.parseInt(lastCar.substring(3));
			carIntId+=1;
			nextCar="CR"+String.format("%08d",carIntId );
		}
		return nextCar;
	}

	@Override
	public Iterable<Car> getAllCars() {
		return carRepo.findAll();
	}
	
	@Override
	public void saveInfo(Car car) {
		car.setCarId(getNextCarId());
		car.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		car.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		carRepo.save(car);
		
	}

	public Car updateCarDetails(Car carDetail,String carId) {
		
		Car carInfo = carServiceImpl.findByCarId(carId);
		
		
		if(carDetail.getCarId()!=null && carDetail.getUpdatedAt()!=null)
		{
			carDetail.setCarId(carId);
		
			carDetail.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
		
		}
		
		return carRepo.save(carDetail);
		
		
	}

	public void deleteCar(Car carDetail, String carId) {


		carRepo.delete(carDetail);
	}
	

	

}
