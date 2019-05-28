package com.aap.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aap.model.UserBean;

@Repository
	public interface UserRepo extends JpaRepository<UserBean, Long> {

	List<UserBean>findByUserName(String name);
	
	Optional<UserBean>findByUserNameAndPassword(String userid,String password);
	
	//Optional<CustomerDetails>findByCustomerNo(int no);
	}
