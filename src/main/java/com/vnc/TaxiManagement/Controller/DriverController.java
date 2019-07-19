package com.vnc.TaxiManagement.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vnc.TaxiManagement.Dto.BookingCarDto;
import com.vnc.TaxiManagement.Dto.DriverDto;
import com.vnc.TaxiManagement.Entity.BookingCar;
import com.vnc.TaxiManagement.Entity.Driver;
import com.vnc.TaxiManagement.ServiceImpl.BookingCarServiceImpl;
import com.vnc.TaxiManagement.ServiceImpl.CarServiceImpl;
import com.vnc.TaxiManagement.ServiceImpl.DriverServiceImpl;

@RestController
@RequestMapping("taxi")
public class DriverController {

	@Autowired
	DriverServiceImpl driverServiceImpl;

	@Autowired
	CarServiceImpl carServiceImpl;

	@Autowired
	BookingCarServiceImpl bookingServiceImpl;

	@Autowired
	BookingCarServiceImpl bookingCarServiceImpl;

	Driver driver = new Driver();

	/**
	 * 
	 * @param driverdto
	 */
	@RequestMapping(value = "/driver", method = RequestMethod.POST)
	public void saveInfo(@RequestBody DriverDto driverdto) {

		BeanUtils.copyProperties(driverdto, driver);

		driverServiceImpl.createDriver(driver);

	}

	/**
	 * 
	 * @param driver
	 * @param driverId
	 */
	@RequestMapping(value = "/driver/{driverId}", method = RequestMethod.PUT)
	public void updateCar(@RequestBody Driver driver, @PathVariable("driverId") String driverId) {

		driverServiceImpl.updateDriverDetails(driver, driverId);

	}

	/**
	 * 
	 * @return DriverList
	 */
	@RequestMapping(value = "/driver", method = RequestMethod.GET)
	public Iterable<Driver> getAllDrivers() {
		return driverServiceImpl.getAllDrivers();
	}

	/**
	 * 
	 * @param booking
	 * @param driverId
	 * @param carId    Assign Car to Driver
	 */
	@RequestMapping(value = "/booking/{driverId}/{carId}", method = RequestMethod.POST)
	public void createBooking(@RequestBody BookingCarDto booking, @PathVariable("driverId") String driverId,
			@PathVariable("carId") String carId) {

		BookingCar book = new BookingCar();

		BeanUtils.copyProperties(booking, book);

		bookingServiceImpl.createBookingDeatils(book, driverId, carId);

	}

	/**
	 * 
	 * @return get All Bookings
	 */
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public Iterable<BookingCar> getAllBookings() {
		return bookingCarServiceImpl.getAllBookings();
	}

	/**
	 * 
	 * @param booking
	 * @param bookingId
	 * 
	 *                  update Booking
	 */
	@RequestMapping(value = "/booking/{bookingId}", method = RequestMethod.PUT)
	public void updateBooking(@RequestBody BookingCar booking, @PathVariable("bookingId") String bookingId) {

		BookingCar book = bookingCarServiceImpl.findByBookingId(bookingId);

		BeanUtils.copyProperties(booking, book);

		bookingCarServiceImpl.updateBookingDeatils(book, bookingId);

	}

	/**
	 * 
	 * @param bookingId Delete Booking
	 */
	@RequestMapping(value = "/booking/{bookingId}", method = RequestMethod.DELETE)
	public void deleteBooking(@PathVariable("bookingId") String bookingId) {

		BookingCar book = bookingCarServiceImpl.findByBookingId(bookingId);
		bookingCarServiceImpl.deleteBookingDetails(book,bookingId);

	}

	/**
	 * 
	 * @param driverId Delete Driver
	 */
	@RequestMapping(value = "/booking/{driverId}", method = RequestMethod.DELETE)
	public void deleteDriver(@PathVariable("driverId") String driverId) {

		Driver driver = driverServiceImpl.findByDriverId(driverId);
		driverServiceImpl.deleteDriverDetails(driver, driverId);

	}
}
