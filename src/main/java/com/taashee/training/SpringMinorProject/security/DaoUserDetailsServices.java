package com.taashee.training.SpringMinorProject.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taashee.training.SpringMinorProject.repository.AdminRepository;
import com.taashee.training.SpringMinorProject.repository.InstructorRepository;
import com.taashee.training.SpringMinorProject.repository.StudentRepository;



@Service
public class DaoUserDetailsServices implements UserDetailsService
{
    @Autowired
    private StudentRepository studentRepo;   
    @Autowired
    private AdminRepository adminRepo; 
    @Autowired
    private InstructorRepository instructorRepo; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		UserDetails student=studentRepo.getUserByUsername(username);
		 if (student == null) {
			 UserDetails admin =adminRepo.getUserByUsername(username);
			 if(admin==null) {
				 UserDetails instructor =instructorRepo.getUserByUsername(username);
				  return instructor;
			 }
			 else
			     return admin;

		    }
		 
		    return student;
		  }

}
