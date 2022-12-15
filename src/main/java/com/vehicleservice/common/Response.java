package com.vehicleservice.common;

import java.util.List;

import com.vehicleservice.entity.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
	
	
	private List<Registration> registration;
	private List<Vehicle> vehicle;
	
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	/*
	 * public void setRegistration(Registration[] restobj) { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 */
	
	

}
