package com.vnc.TaxiManagement.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.vnc.TaxiManagement.Entity.BookingCar;

public interface BookingCarRepository extends CrudRepository<BookingCar, BookingCar> {

	BookingCar findFirstByOrderByBookingIdDesc();

	// List<BookingCar> findByCarNo();

	BookingCar findByBookingId(String bookingId);

	BookingCar findByDriverId(String driverId);

	List<BookingCar> findByCarNoAndDriverId(String carId, String driverId);

}
