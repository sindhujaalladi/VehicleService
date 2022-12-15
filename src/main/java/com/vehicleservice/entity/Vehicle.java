package com.vehicleservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vehicleservice.pojo.VehicleDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Vehicle")
public class Vehicle {
	
	@Id
	private int vehiclenum;
	
	@Column(name = "VehicleOwnerName")
	private String vehicleownername;
	
	@Column(name = "VehicleType")
	private String vehicletype;
	
	@Column(name = "VehicleName")
	private String vehiclename;

}
