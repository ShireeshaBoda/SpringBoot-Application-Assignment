package com.taashee.training.SpringMinorProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taashee.training.SpringMinorProject.entity.Student;
import com.taashee.training.SpringMinorProject.repository.StudentRepository;

@RestController
@RequestMapping("/oneToMany")
public class ManyToMany {
	@Autowired
	StudentRepository studentRepo;
	@GetMapping("/students")
	   public List<Student> getPersons(){
		   return (List<Student>)studentRepo.findAll();
	   }
	   @PostMapping("/student")
	   public Student savePerson(@RequestBody Student student)
	   {
		   return studentRepo.save(student);
	   }

}
