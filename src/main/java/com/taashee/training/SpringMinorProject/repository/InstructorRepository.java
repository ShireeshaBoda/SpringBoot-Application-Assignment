package com.taashee.training.SpringMinorProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.taashee.training.SpringMinorProject.entity.Course;
//import com.taashee.training.SpringMinorProject.entity.Course;
import com.taashee.training.SpringMinorProject.entity.Instructor;
@Repository

public interface InstructorRepository extends CrudRepository<Instructor,Integer> {

	
	@Query("select s from Instructor s where username=?1")
	UserDetails getUserByUsername(String username);

	@Query("select s from Instructor s where id=?1")
	Instructor getUserById(int iid);
    @Query("Select s from Instructor s where username=?1")
	Instructor getUser(String username);

	
	

}
