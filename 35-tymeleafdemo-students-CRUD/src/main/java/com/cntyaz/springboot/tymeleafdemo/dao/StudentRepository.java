package com.cntyaz.springboot.tymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cntyaz.springboot.tymeleafdemo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	// thats it no need to write any more code.
	
	// add a method sort by last name
	
	public List<Student> findAllByOrderByLastNameAsc();
}
