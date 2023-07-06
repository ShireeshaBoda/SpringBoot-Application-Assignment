package com.taashee.training.SpringMinorProject.dao;

import java.util.List;

import com.taashee.training.SpringMinorProject.entity.Course;

public interface StudentDao {

	List<Course> getCourseById(int student_id);

}
