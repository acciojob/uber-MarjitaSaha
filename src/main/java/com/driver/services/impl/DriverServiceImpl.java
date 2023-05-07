package com.driver.services.impl;

import com.driver.model.Cab;
import com.driver.repository.CabRepository;
import com.driver.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Driver;
import com.driver.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository driverRepository3;

	@Autowired
	CabRepository cabRepository3;

	@Override
	public void register(String mobile, String password){
		//Save a driver in the database having given details and a cab with ratePerKm as 10 and availability as True by default.
         Driver driver =new Driver();
		 driver.setMobile(mobile);
		 driver.setPassword(password);
		 Cab cab= new Cab();
		 cab.setDriver(driver);
		 cab.setPerKmRate(10);
		 cab.setAvailable(true);
		 driver.setCab(cab);
		 driverRepository3.save(driver);
	}

	@Override
	public void removeDriver(int driverId){
		// Delete driver without using deleteById function
      driverRepository3.deleteById(driverId);
	}

	@Override
	public void updateStatus(int driverId){
		//Set the status of respective car to unavailable
      Driver driver=driverRepository3.findById(driverId).get();
	  Cab cab=driver.getCab();
	  cab.setAvailable(false);
	  driver.setCab(cab);
	  driverRepository3.save(driver);
	}
}
