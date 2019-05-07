package com.aap.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aap.bean.CustomerDetails;
import com.aap.bean.PropertyDetails;
import com.aap.bean.Registration_Bean;
import com.aap.bean.UserBean;
import com.aap.repository.CustomerDetailsRepo;
import com.aap.repository.PropertyDetailsRepo;
import com.aap.repository.UserRepo;

@RestController
@EnableJpaRepositories(basePackages = { "com" })
@EntityScan(basePackages = { "com" })
public class AapController {

	@Autowired
	UserRepo userRepo;

	@Autowired
	CustomerDetailsRepo customerDetailsRepo;

	@Autowired
	PropertyDetailsRepo propertyDetailsRepo;

	/*@PostMapping(value = "/Register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Registration_Bean validateRegister(@Valid @RequestBody Registration_Bean input) {

		return input;

	}
*/
	@PostMapping(value = "/newRegister")
	public UserBean insertRegister(@Valid @RequestBody UserBean input) {
		userRepo.save(input);
		return input;

	}

	@PostMapping(value = "/CustomerDetails")
	public CustomerDetails insertCustomerDetails(@Valid @RequestBody CustomerDetails input) {
		
		customerDetailsRepo.save(input);
		return input;

	}

	@PostMapping(value = "/PropertyDetails")
	public PropertyDetails insertPropertyDetails(@Valid @RequestBody PropertyDetails input) {
		
		Optional<CustomerDetails> customerDetails = customerDetailsRepo.findByCustomerNo(input.getCustomerDetails().getCustomerNo());
		CustomerDetails cd = customerDetails.isPresent()?customerDetails.get():null;
		input.setCustomerDetails(cd);
		propertyDetailsRepo.save(input);
		return input;

	}
	


	
	@GetMapping(value = "/getCustomerDetails")
	public List<CustomerDetails> getCustomerDetails() {
		
		List<CustomerDetails> customerDetails = customerDetailsRepo.findByPropertyDetails_Status(4);
		return customerDetails;

	}
	

}
