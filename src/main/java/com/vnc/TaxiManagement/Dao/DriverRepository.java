package com.vnc.TaxiManagement.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vnc.TaxiManagement.Entity.BookingCar;
import com.vnc.TaxiManagement.Entity.Driver;

public interface DriverRepository extends CrudRepository<Driver, String>{

	Driver findFirstByOrderByDriverIdDesc();

	Driver findByDriverId(String id);
	
	
	
}
