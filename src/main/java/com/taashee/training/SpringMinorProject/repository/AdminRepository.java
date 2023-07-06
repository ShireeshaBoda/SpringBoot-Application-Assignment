package com.taashee.training.SpringMinorProject.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.taashee.training.SpringMinorProject.entity.Admin;
@Repository

public interface AdminRepository  extends CrudRepository<Admin,Integer>  {

	@Query("select s from Admin s where username=?1")
	UserDetails getUserByUsername(String username);

}
