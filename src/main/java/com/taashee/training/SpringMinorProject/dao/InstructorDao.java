package com.taashee.training.SpringMinorProject.dao;

import java.util.List;

import com.taashee.training.SpringMinorProject.entity.Instructor;

public interface InstructorDao {
   List<Instructor> getAll();

List<Integer> getIds();
}
