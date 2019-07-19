package com.vnc.TaxiManagement.Service;

import com.vnc.TaxiManagement.Entity.Driver;

public interface DriverService {

	String getNextDriverId();

	void createDriver(Driver driver);

	


}
