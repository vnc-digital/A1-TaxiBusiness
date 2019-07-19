package com.vnc.TaxiManagement.Entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Driver")
public class Driver{

	@Id
	@Column(name="driver_id")
	private String driverId;
	
	@Column(name="driver_name")
	private String driverName;
	
	@Column(name="driver_address")
	private String driverAddress;
	
	@Column(name="mobile_no")
	private int mobileNo;
	
	@Column(name="driver_car_no")
	private String driverCarNo;
	
	@Column(name="driver_car_status")
	private int driverCarStatus;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	
	public int getDriverCarStatus() {
		return driverCarStatus;
	}



	public void setDriverCarStatus(int driverCarStatus) {
		this.driverCarStatus = driverCarStatus;
	}




	
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



	



	}
