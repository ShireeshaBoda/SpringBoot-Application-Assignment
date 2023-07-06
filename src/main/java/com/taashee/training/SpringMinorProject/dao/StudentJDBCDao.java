package com.taashee.training.SpringMinorProject.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taashee.training.SpringMinorProject.entity.Course;




@Repository
public class StudentJDBCDao implements StudentDao{
	Logger logger=LoggerFactory.getLogger(StudentJDBCDao.class);
	@Autowired
    private JdbcTemplate jdbcTemplate;
	public List<Course> getCourseById(int student_id) {
		 return jdbcTemplate.query("select course.course_id,course.cname, course.description from course join student_course_rel on course.course_id=student_course_rel.course_id where student_course_rel.student_id=?",

	               new BeanPropertyRowMapper<Course>(Course.class), new Object[] {student_id});
	

}}
