package com.aap.repository;
	//import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

import com.aap.bean.UserBean;

@Repository
	public interface UserRepo extends CrudRepository<UserBean, Long> {

		
	}
