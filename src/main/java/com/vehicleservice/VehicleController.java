package com.vehicleservice;

import java.util.List;

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

@RestController
@RequestMapping("/vehicleinfo")
@RefreshScope
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleservice;
	
	@Value("${message.vehicle}")
	String message;
	
	@PostMapping("/createvehicledata")
	public String createVehicleData(@RequestBody VehicleDTO vehicledto) {
		String response = this.vehicleservice.createVehicleData(vehicledto);
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
		List<Response> reslisobj = this.vehicleservice.getVehicleServiceData();
		return reslisobj;
	}
	
	@GetMapping("/print")
	public String printMessage() {
		return message;
	}
	
	@GetMapping("/getlandserviceinfo")
	public List<Registration> getLandServiceData(){
		List<Registration> reglisobj = this.vehicleservice.getLandServiceData();
		return reglisobj;
	}
}
