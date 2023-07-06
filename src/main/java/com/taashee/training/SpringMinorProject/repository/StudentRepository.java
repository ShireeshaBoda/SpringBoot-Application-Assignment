package com.taashee.training.SpringMinorProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.taashee.training.SpringMinorProject.entity.Student;
@Repository
public interface StudentRepository  extends CrudRepository<Student,Integer>  {
	
    @Query("select s from Student s where username=?1")
	UserDetails getUserByUsername(String username);
    @Query("select s from Student s where id=?1")
	Student getUserById(int student_id);
    @Query("select s from Student s where username=?1")
	Student getStudent(String username);
   

}
