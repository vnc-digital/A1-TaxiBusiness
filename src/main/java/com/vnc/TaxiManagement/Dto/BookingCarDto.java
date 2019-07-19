package com.vnc.TaxiManagement.Dto;

import java.sql.Timestamp;
import java.util.Date;


public class BookingCarDto {

	
	private String bookingId;
	

	private String carNo;
	
	
	private String driverId;
	
	private boolean bookingStatus;
	
	
	private Date createdAt;
	
	private Date updatedAt;
	

	public String getBookingId() {
		return bookingId;
	}


	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}


	public String getCarNo() {
		return carNo;
	}


	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}


	public String getDriverId() {
		return driverId;
	}


	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	
	
	


	public boolean isBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



}
