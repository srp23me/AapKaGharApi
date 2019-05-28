package com.aap.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aap.exception.ResourceNotFoundException;
import com.aap.model.CustomerDetails;
import com.aap.model.PropertyDetails;
import com.aap.model.UserBean;
import com.aap.repository.CustomerDetailsRepo;
import com.aap.repository.PropertyDetailsRepo;
import com.aap.repository.UserRepo;
import com.aap.service.CustomerService;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	UserRepo userRepo;

	@Autowired
	CustomerDetailsRepo customerDetailsRepo;

	@Autowired
	PropertyDetailsRepo propertyDetailsRepo;
	
	@Override
	public String validateUser(String name) throws ResourceNotFoundException {
		String result = "AVAILABLE";
		try {
			List<UserBean> userNamer= userRepo.findByUserName(name);
			
			if(userNamer.size() !=0)
				result = "NOT AVAILABLE";
		}
		catch (Exception e) {
			throw new ResourceNotFoundException("Please Try Again!!!");
		}
		return result;
	}

	@Override
	public String insertRegister(UserBean input) throws ResourceNotFoundException {
		try {
			UserBean user = userRepo.save(input);
			if(user == null)
			{
				throw new ResourceNotFoundException("Please Try Again!!!");
			}
			
		}
		catch (Exception e) {
			throw new ResourceNotFoundException("Please Try Again!!!");
		}

		return success;
	}

	@Override
	public String insertCustomerDetails(CustomerDetails input) throws ResourceNotFoundException {
		try {
			CustomerDetails customerDetails = customerDetailsRepo.save(input);
			if(customerDetails == null)
			{
				throw new ResourceNotFoundException("Please Try Again!!!");
			}
			
		}
		catch (Exception e) {
			throw new ResourceNotFoundException("Please Try Again!!!");
		}

		return success;
	}

	@Override
	public String insertPropertyDetails(PropertyDetails input) throws ResourceNotFoundException {
		try {
		Optional<CustomerDetails> customerDetails = customerDetailsRepo.findByCustomerNo(input.getCustomerDetails().getCustomerNo());
		CustomerDetails cd = customerDetails.isPresent()?customerDetails.get():null;
		input.setCustomerDetails(cd);
		PropertyDetails propertyDetails = propertyDetailsRepo.save(input);
		if(propertyDetails == null)
		{
			throw new ResourceNotFoundException("Please Try Again!!!");
		}
		}
		catch (Exception e) {
			throw new ResourceNotFoundException("Please Try Again!!!");
		}
		return success;
	}

	@Override
	public List<CustomerDetails> getCustomerDetails(int status) throws ResourceNotFoundException {
		try {
		List<CustomerDetails> customerDetails = customerDetailsRepo.findByPropertyDetails_Status(status);
		return customerDetails;
		}
		catch (Exception e) {
			throw new ResourceNotFoundException("Please Try Again!!!");
		}
	}

}
