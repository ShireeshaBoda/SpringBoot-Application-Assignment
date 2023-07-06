package com.taashee.training.SpringMinorProject.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taashee.training.SpringMinorProject.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer>{

	@Query("select s from Course s where id=?1")
	Set<Course> getCourseById(int course_id);
	@Query("select s from Course s where id=?1")
    Course getCoursesById(int cid);
	@Query("select s from Course s where instructor_id is null")
	List<Course> getAll();
    
}
