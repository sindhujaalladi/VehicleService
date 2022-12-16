package com.vehicleservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.vehicleservice.common.Registration;

@FeignClient(value="RegistrationService",url="http://localhost:9595/registration")
public interface FeigClient {
	
	
	@GetMapping("/servicetype/LAND-SERVICE")
	List<Registration> getLandServiceData();

	
}
