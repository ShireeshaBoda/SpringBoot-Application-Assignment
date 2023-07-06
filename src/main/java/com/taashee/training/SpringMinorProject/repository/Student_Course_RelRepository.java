package com.taashee.training.SpringMinorProject.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taashee.training.SpringMinorProject.entity.Student;
import com.taashee.training.SpringMinorProject.entity.Student_Course_Rel;
@Repository
public interface Student_Course_RelRepository extends JpaRepository<Student_Course_Rel,Integer> {

	@Query("SELECT s from Student_Course_Rel s where student_id=?1 ")
	List<Student_Course_Rel> findAllByCommonKey(int student_id);
     
	 
}
