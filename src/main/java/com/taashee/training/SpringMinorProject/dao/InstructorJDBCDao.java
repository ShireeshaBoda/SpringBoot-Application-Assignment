package com.taashee.training.SpringMinorProject.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.taashee.training.SpringMinorProject.entity.Course;
import com.taashee.training.SpringMinorProject.entity.Instructor;
@Repository
public class InstructorJDBCDao implements InstructorDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Override
	public List<Instructor> getAll() {
		
		return jdbcTemplate.query("select * from instructor where course_id is null",  new BeanPropertyRowMapper<Instructor>(Instructor.class));
	}
	public List<Integer> getIds(){ 
		return jdbcTemplate.queryForList("select instructor_id from instructor where course_id is null",Integer.class);
	}

}
