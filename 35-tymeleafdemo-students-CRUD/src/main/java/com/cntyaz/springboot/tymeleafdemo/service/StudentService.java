package com.cntyaz.springboot.tymeleafdemo.service;

import java.util.List;

import com.cntyaz.springboot.tymeleafdemo.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save(Student theEmployee);
	
	public void deleteById(int theId);
	
}

