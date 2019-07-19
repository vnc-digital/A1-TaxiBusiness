package com.vnc.TaxiManagement.ServiceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnc.TaxiManagement.Dao.BookingCarRepository;
import com.vnc.TaxiManagement.Dao.DriverRepository;
import com.vnc.TaxiManagement.Entity.BookingCar;

import com.vnc.TaxiManagement.Entity.Driver;
import com.vnc.TaxiManagement.Service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepo;

	@Autowired
	BookingCarRepository bookingRepo;

	@Autowired
	CarServiceImpl carServiceImpl;

	@Autowired
	DriverServiceImpl driverServiceImpl;

	@Autowired
	BookingCarServiceImpl bookingCarServiceImpl;

	public Driver save(Driver driver) {
		return driverRepo.save(driver);
	}

	@Override
	public String getNextDriverId() {
		Driver driver = driverRepo.findFirstByOrderByDriverIdDesc();
		String nextDriver = null;
		if (driver == null) {
			nextDriver = "DR00000001";
		} else {
			String lastDriver = driver.getDriverId();

			int carIntId = Integer.parseInt(lastDriver.substring(3));
			carIntId += 1;
			nextDriver = "DR" + String.format("%08d", carIntId);
		}
		return nextDriver;
	}

	@Override
	public void createDriver(Driver driver) {
		driver.setDriverId(getNextDriverId());
		driver.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		driver.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

		driverRepo.save(driver);

	}

	public Driver findByDriverId(String driverId) {

		return driverRepo.findByDriverId(driverId);
	}

	public void updateDriverDetails(Driver driverDetail, String driverId) {

		// Driver driverDetails = driverServiceImpl.findByDriverId(driverId);
		driverDetail.setDriverId(driverId);

		driverDetail.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

		driverRepo.save(driverDetail);

	}

	public Iterable<Driver> getAllDrivers() {

		return driverRepo.findAll();
	}

	public void deleteDriverDetails(Driver driver, String driverId) {
		BookingCar bookCar = bookingCarServiceImpl.findByDriverId(driverId);
		if (bookCar != null) {
			driverRepo.delete(driver);
		} else {
			throw new RuntimeException("Driver Cannot be Deleted");
		}

	}

}
