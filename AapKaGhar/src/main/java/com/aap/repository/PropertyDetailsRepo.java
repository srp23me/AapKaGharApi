package com.aap.repository;
	import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

import com.aap.model.CustomerDetails;
import com.aap.model.PropertyDetails;

@Repository
	public interface PropertyDetailsRepo extends CrudRepository<PropertyDetails, Long> {

	List<PropertyDetails>findByStatus(int no);
	}
