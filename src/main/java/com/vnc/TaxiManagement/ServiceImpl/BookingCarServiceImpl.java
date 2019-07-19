package com.vnc.TaxiManagement.ServiceImpl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vnc.TaxiManagement.Dao.BookingCarRepository;
import com.vnc.TaxiManagement.Dao.DriverRepository;
import com.vnc.TaxiManagement.Entity.BookingCar;
import com.vnc.TaxiManagement.Entity.Car;
import com.vnc.TaxiManagement.Entity.Driver;

@Service
public class BookingCarServiceImpl {

	@Autowired
	BookingCarRepository bookingRepo;

	@Autowired
	BookingCarServiceImpl bookingServiceImpl;

	@Autowired
	CarServiceImpl carServiceImpl;

	@Autowired
	DriverServiceImpl driverServiceImpl;

	@Autowired
	DriverRepository driverRepo;

	public BookingCar findByBookingId(String bookingId) {
		return bookingRepo.findByBookingId(bookingId);
	}

	public String getBookingId() {
		BookingCar bookCar = bookingRepo.findFirstByOrderByBookingIdDesc();
		String nextBooking = null;
		if (bookCar == null) {
			nextBooking = "BK00000001";
		} else {
			String lastCar = bookCar.getBookingId();

			int bookingIntId = Integer.parseInt(lastCar.substring(3));
			bookingIntId += 1;
			nextBooking = "BK" + String.format("%08d", bookingIntId);
		}
		return nextBooking;
	}

	public void updateBookingDeatils(BookingCar book, String bookingId) {

		// Driver driverDetail = driverServiceImpl.findByDriverId(book.getDriverId());

		book.setBookingId(bookingId);
		book.setBookingStatus(false);

		book.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

		bookingRepo.save(book);

	}

	public void deleteBookingDetails(BookingCar book, String bookingId) {

		bookingRepo.delete(book);

	}

	public BookingCar findByDriverId(String driverId) {
		return bookingRepo.findByDriverId(driverId);
	}

	public Iterable<BookingCar> getAllBookings() {
		return bookingRepo.findAll();
	}

	public void createBookingDeatils(BookingCar book, String driverId, String carId) {

		String status = null;
		Car carDetail = carServiceImpl.findByCarId(carId);
		Driver driverDetail = driverServiceImpl.findByDriverId(driverId);

		List<BookingCar> bookedCar = bookingServiceImpl.findByCarNoAndDriverId(carId, driverId);
		if (!bookedCar.isEmpty()) {
			for (BookingCar booking : bookedCar) {
				if (carDetail.getCarId() != null && driverDetail != null && !booking.getCarNo().equals(carId)) {
					status = "true";

					break;

				} else {
					status = "false";

				}
			}

		} else {
			status = "true";
		}

		if (driverDetail != null && carDetail != null) {
			if (driverDetail.getDriverCarStatus() == 0 && driverDetail.getDriverCarNo() == null && status == "true") {
				book.setBookingId(getBookingId());
				book.setBookingStatus(true);
				book.setCarNo(carDetail.getCarId());
				book.setDriverId(driverDetail.getDriverId());
				book.setCreatedAt(new Timestamp(System.currentTimeMillis()));
				book.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				bookingRepo.save(book);

				driverDetail.setDriverCarNo(book.getCarNo());
				driverDetail.setDriverCarStatus(1);

				driverRepo.save(driverDetail);
			}

			else {
				throw new RuntimeException("Select Another Car");
			}
		} else {
			throw new RuntimeException("No Car/Driver is Available");
		}

	}

	private List<BookingCar> findByCarNoAndDriverId(String carId, String driverId) {
		return bookingRepo.findByCarNoAndDriverId(carId, driverId);
	}

}
