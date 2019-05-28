package com.aap.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aap.exception.ResourceNotFoundException;
import com.aap.model.CustomerDetails;
import com.aap.model.PropertyDetails;
import com.aap.model.UserBean;
import com.aap.repository.CustomerDetailsRepo;
import com.aap.repository.PropertyDetailsRepo;
import com.aap.repository.UserRepo;
import com.aap.service.CustomerService;

@RestController
@EnableJpaRepositories(basePackages = { "com" })
@EntityScan(basePackages = { "com" })
@CrossOrigin("*")
public class AapController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	UserRepo userRepo;

	/*@PostMapping(value = "/Register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Registration_Bean validateRegister(@Valid @RequestBody Registration_Bean input) {

		return input;

	}
*/
	@PostMapping(value = "/validateUser")
	public String validateUser(@Valid @RequestBody String input) throws ResourceNotFoundException {
		String result = customerService.validateUser(input);
		return result;

	}

	@PostMapping(value = "/Customer")
	public void insertRegister(@Valid @RequestBody UserBean input) throws ResourceNotFoundException {
		String result = customerService.insertRegister(input);
		
		//return result;
	}

	@PostMapping(value = "/Customer/Details")
	public String insertCustomerDetails(@Valid @RequestBody CustomerDetails input)  throws ResourceNotFoundException {
		String result = customerService.insertCustomerDetails(input);
		return result;
		

	}

	@PostMapping(value = "/Property/Details")
	public String insertPropertyDetails(@Valid @RequestBody PropertyDetails input) throws ResourceNotFoundException {
		
		String result = customerService.insertPropertyDetails(input);
		return result;
	}
	
	@GetMapping(value = "/Customer/Requests")
	public List<CustomerDetails> getCustomerDetails() throws ResourceNotFoundException {
		
		List<CustomerDetails> customerDetails = customerService.getCustomerDetails(4);
		return customerDetails;
	}
	
	
	
	@GetMapping(value = "/login",produces=MediaType.APPLICATION_JSON_VALUE)
	public UserBean getLogin(@NotNull(message="UserId is Mandatory") @RequestParam(required=false) String userid,@NotNull(message="Password is mandatory") @RequestParam(required=false) String password) {
	//  Optional<User> user = userReop.findByUserid(userid);
	 System.out.println("************* user id ::: "+userid);
	 System.out.println("************* password ::: "+password);
	 Optional<UserBean> user = userRepo.findByUserNameAndPassword(userid,password);
	 UserBean userdata = user.isPresent()?user.get():null;
	 
	/* if(!user.isPresent()) {
	  throw new SampleRestControllerException("User Not Found...");
	 }

	 System.out.println("response ::::: "+userdata.getUserid()+":::::::"+userdata.getPassword());
	 */
	 return userdata;
	}

	
	
	@PostMapping(value = "/Customer/Details1")
	public ResponseEntity<CustomerDetails> insertCustomerDetails1(@Valid @RequestBody CustomerDetails input)  throws ResourceNotFoundException {
		String result = customerService.insertCustomerDetails(input);
		return ResponseEntity.ok().body(input);
		

	}
}
