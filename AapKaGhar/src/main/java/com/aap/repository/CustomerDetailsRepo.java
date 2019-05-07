package com.aap.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aap.bean.CustomerDetails;
import com.aap.bean.PropertyDetails;
import com.aap.bean.UserBean;

@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, Long> {
	//CustomerDetails findByCustomerNo(int no);

	Optional<List<CustomerDetails>> findByFirstName(String name);
	@Query(value = "SELECT a.firstName, a.email FROM CustomerDetails a")
	Optional<List<CustomerDetails>> lissst();
	
	List<CustomerDetails> findByPropertyDetails_Status(int s);
	
	Optional<CustomerDetails>findByCustomerNo(int no);
	
	//Optional<List<CustomerDetails>>findByStatus(int no);
	
	//CustomerDetails findById();
	
	//List<User> findUserByNameList(@Param("names") Collection<String> names);
	
	//Query createNativeQuery(String s);
}
