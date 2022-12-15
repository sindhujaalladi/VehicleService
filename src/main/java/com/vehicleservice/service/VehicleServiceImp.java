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

		

}
