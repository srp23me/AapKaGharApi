package com.aap.service;

import java.util.List;

import com.aap.exception.ResourceNotFoundException;
import com.aap.model.CustomerDetails;
import com.aap.model.PropertyDetails;
import com.aap.model.UserBean;

public interface CustomerService {

	public String success = "SUCCESS";
	public String validateUser(String name) throws ResourceNotFoundException;
	public String insertRegister(UserBean input) throws ResourceNotFoundException;
	public String insertPropertyDetails(PropertyDetails input) throws ResourceNotFoundException;
	public String insertCustomerDetails(CustomerDetails input) throws ResourceNotFoundException;
	public List<CustomerDetails> getCustomerDetails(int status) throws ResourceNotFoundException;
}
