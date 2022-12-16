package com.vehicleservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vehicleservice.common.Registration;
import com.vehicleservice.common.Response;
import com.vehicleservice.entity.Vehicle;
import com.vehicleservice.pojo.VehicleDTO;
import com.vehicleservice.repository.VehicleRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;

@Service
@RefreshScope
public class VehicleServiceImp implements VehicleService{
	
	
	@Autowired
	private VehicleRepository vehiclerepository;
	
	@Autowired
	@Lazy
	private RestTemplate resttemplate;
	
	@Value("${vehicle.provider.url}")
	private String ENDPOINT_URI;

	@Override
	public String createVehicleData(VehicleDTO vehicledto) {
		Vehicle  vehobj = Vehicle.builder().vehiclename(vehicledto.getVehiclename())
							.vehiclenum(vehicledto.getVehiclenum())
							.vehicleownername(vehicledto.getVehicleownername())
							.vehicletype(vehicledto.getVehicletype())
							.build();
		vehiclerepository.save(vehobj);	
			return "Vehicle data created and successfully stored in db";	
	}
	
	

	@Override
	public List<Vehicle> getAllVehicleInfo() {
		List<Vehicle> vehiclelistobj = vehiclerepository.findAll();
		//List<VehicleDTO> dtolistobj = new ArrayList<>(); 
		//dtolistobj.add(vehiclelistobj);
		return vehiclelistobj;
	}

	@Override
	public VehicleDTO getVehicleInfo(int vehiclenum) {
		Vehicle vehobj = vehiclerepository.findByVehiclenum(vehiclenum);
		VehicleDTO dtoobj = VehicleDTO.builder()
				.vehiclename(vehobj.getVehiclename())
				.vehiclenum(vehobj.getVehiclenum())
				.vehicleownername(vehobj.getVehicleownername())
				.vehicletype(vehobj.getVehicletype())
				.build();
		return dtoobj;
	}
		
	@CircuitBreaker(name = "VehicleRegistrationService",fallbackMethod = "dummygetVehicleServiceData")	
	public List<Response> getVehicleServiceData() {
		List<Vehicle> veholistbj = vehiclerepository.findAll();
	Registration[] restobj = resttemplate
				.getForObject(ENDPOINT_URI, Registration[].class);
		List<Response> lisobj = new ArrayList<>();
		Response res = new Response();
		List l1obj  = Arrays.asList(restobj);
		res.setVehicle(veholistbj);
		res.setRegistration(l1obj);
		lisobj.add(res);
		return lisobj;
	}
	
	public List<Response> dummygetVehicleServiceData(Exception e){
		List<Response> lisobj = new ArrayList<>();
		Response res = new Response();
		List<Vehicle> vehlisobj = new ArrayList<>();
		Vehicle vehobj = new Vehicle();
		vehobj.setVehiclename("dummyvehiclename");
		vehobj.setVehiclenum(1);
		vehobj.setVehicleownername("dummyvehicleownername");
		vehobj.setVehicletype("dummyvehicletype");
		vehlisobj.add(vehobj);
		List<Registration>  listobj = new ArrayList<>();
		Registration regobj = new Registration();
		regobj.setRegistrationid(1);
		regobj.setRegistrationLocation("dummyreglocation");
		regobj.setRegistrationownername("dummyregownername");
		regobj.setRegistrationservicename("dummyregservicename");
		regobj.setRegistrationfees(2000);
		listobj.add(regobj);
		res.setRegistration(listobj);
		res.setVehicle(vehlisobj);
		lisobj.add(res);
		return lisobj;
	}
	
	

		

}
