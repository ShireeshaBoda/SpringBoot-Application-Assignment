package com.taashee.training.SpringMinorProject.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="course_id")
   private int id;
   private String cname;
   private String description;
  
   
@OneToOne
 @JoinColumn(name="instructor_id",unique=true)
    private Instructor instructor;
   @ManyToMany(mappedBy="course")
  
public int getId() {
	return id;
}
public Instructor getInstructor() {
	return instructor;
}
public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}
@Override
public String toString() {
	return cname;
}
public void setId(int id) {
	this.id = id;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}


}
