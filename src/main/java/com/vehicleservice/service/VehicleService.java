package com.vehicleservice.service;

import java.util.List;

import com.vehicleservice.common.Registration;
import com.vehicleservice.common.Response;
import com.vehicleservice.entity.Vehicle;
import com.vehicleservice.pojo.VehicleDTO;

public interface VehicleService {
	
	String createVehicleData(VehicleDTO vehicledto);
	
	List<Vehicle> getAllVehicleInfo();
	
	VehicleDTO getVehicleInfo(int vehiclenum);
	
	List<Response> getVehicleServiceData();
	
	List<Registration> getLandServiceData();

}
