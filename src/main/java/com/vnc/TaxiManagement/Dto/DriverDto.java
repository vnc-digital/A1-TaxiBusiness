package com.vnc.TaxiManagement.Dto;

import java.sql.Timestamp;
import java.util.Date;

public class DriverDto {

	private String driverId;

	private String driverName;

	private String driverAddress;

	private int mobileNo;

	private String driverCarNo;

	private int driverCarStatus;

	private Date createdAt;

	private Date updatedAt;

	public String getDriverId() {	
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverAddress() {
		return driverAddress;
	}

	public void setDriverAddress(String driverAddress) {
		this.driverAddress = driverAddress;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDriverCarNo() {
		return driverCarNo;
	}

	public void setDriverCarNo(String driverCarNo) {
		this.driverCarNo = driverCarNo;
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

	public int getDriverCarStatus() {
		return driverCarStatus;
	}

	public void setDriverCarStatus(int driverCarStatus) {
		this.driverCarStatus = driverCarStatus;
	}



}
