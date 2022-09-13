package com.cntyaz.springboot.tymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cntyaz.springboot.tymeleafdemo.dao.StudentRepository;
import com.cntyaz.springboot.tymeleafdemo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository employeeRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	
	public List<Student> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	
	public Student findById(int theId) {
		Optional<Student> result = employeeRepository.findById(theId);
		
		Student theEmployee = null;
		
		if (result.isPresent()) {
			
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Do not find the employee id -" + theId);
		}
		
		return theEmployee;
	}

	@Override
	
	public void save(Student theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
