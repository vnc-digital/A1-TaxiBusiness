package com.vnc.TaxiManagement.Helper;

import org.springframework.stereotype.Component;

@Component
public class CarRegenerator {

	private String nextCarId;

	public CarRegenerator() {
		super();
	}

	public CarRegenerator(String nextCarId) {
		super();
		this.nextCarId = nextCarId;
	}

	public String getNextCarId() {
		return nextCarId;
	}

	public void setNextCarId(String nextCarId) {
		this.nextCarId = nextCarId;
	}
	
	
	
	
}
