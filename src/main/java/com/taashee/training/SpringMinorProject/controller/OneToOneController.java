package com.taashee.training.SpringMinorProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taashee.training.SpringMinorProject.entity.Course;
import com.taashee.training.SpringMinorProject.entity.Instructor;
import com.taashee.training.SpringMinorProject.repository.CourseRepository;
import com.taashee.training.SpringMinorProject.repository.InstructorRepository;



@RestController
@RequestMapping("/oneToOne")
public class OneToOneController {
	@Autowired
	InstructorRepository instructorRepo;
	@Autowired
	CourseRepository courseRepo;
   @GetMapping("/instructors")
   public List<Instructor> getCitizens(){
	   return (List<Instructor>)instructorRepo.findAll();
   }
   @GetMapping("/course/{:id}")
   public Course getAadhar(@PathVariable int id){
	   return courseRepo.findById(id).get();
   }
   @PostMapping("/instructor")
   public Instructor saveInstructor(@RequestBody Instructor instructor)
   {
	   return instructorRepo.save(instructor);
   }
   @PostMapping("/course")
   public Course saveCourse(@RequestBody Course course)
   {
	   return courseRepo.save(course);
   }
}

