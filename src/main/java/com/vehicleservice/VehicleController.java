package com.vehicleservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicleservice.common.Registration;
import com.vehicleservice.common.Response;
import com.vehicleservice.entity.Vehicle;
import com.vehicleservice.pojo.VehicleDTO;
import com.vehicleservice.service.VehicleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/vehicleinfo")
@RefreshScope
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleservice;
	
	@Value("${message.vehicle}")
	String message;
	
	Logger logger=LoggerFactory.getLogger(VehicleController.class);

	
	@PostMapping("/createvehicledata")
	public String createVehicleData(@RequestBody VehicleDTO vehicledto) {
		logger.info("Beginning of createVehicleData method");
		String response = this.vehicleservice.createVehicleData(vehicledto);
		logger.info("End of createVehicleData method"+response);
		return response;
		
	}
	
	
	@GetMapping("/getalldata")
	public List<Vehicle> getAllVehicleInfo(){
	List<Vehicle> listobj = this.vehicleservice.getAllVehicleInfo();
		return listobj;
	}
	
	
	@GetMapping("/{vehiclenum}")
	public ResponseEntity<VehicleDTO> getVehicleInfo(@PathVariable int vehiclenum) {
		VehicleDTO dtoobj = this.vehicleservice.getVehicleInfo(vehiclenum);
		return new  ResponseEntity<>(dtoobj,HttpStatus.OK);
	}

	@GetMapping("/getvehicleserviceinfo")
	public List<Response> getVehicleServiceData() {
		logger.info("Beginning of getVehicleServiceData method");
		List<Response> reslisobj = this.vehicleservice.getVehicleServiceData();
		logger.info("End of getVehicleServiceData method"+reslisobj);
		return reslisobj;
	}
	
	@GetMapping("/print")
	public String printMessage() {
		return message;
	}
	
	@GetMapping("/getlandserviceinfo")
	public List<Registration> getLandServiceData(){
		logger.info("Beginning of getLandServiceData method");
		List<Registration> reglisobj = this.vehicleservice.getLandServiceData();
		logger.info("End of getLandServiceData method"+reglisobj);
		return reglisobj;
	}
}
