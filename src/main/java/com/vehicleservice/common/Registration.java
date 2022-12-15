package com.vehicleservice.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Registration {
	
	
	private int registrationid;
	private String registrationservicename;
	private String registrationownername;
	private double registrationfees;
	private String registrationLocation;


}
