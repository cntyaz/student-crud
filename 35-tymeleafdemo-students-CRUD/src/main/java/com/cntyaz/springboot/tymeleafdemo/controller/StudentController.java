package com.cntyaz.springboot.tymeleafdemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cntyaz.springboot.tymeleafdemo.entity.Student;
import com.cntyaz.springboot.tymeleafdemo.service.StudentService;

@Controller
@RequestMapping("/employees")
public class StudentController {
	
	private StudentService employeeService;
	
	public StudentController(StudentService theEmployeeService) {
		
		employeeService = theEmployeeService;
	}

	// load employee data
	private List<Student> theEmployees;
	
	// add mapping for "/list" 
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get the employees from db
		List<Student> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Student theEmployee = new Student();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		Student theEmployee = employeeService.findById(theId);
		
		theModel.addAttribute("employee",theEmployee);
		
		
		return "employees/employee-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Student theEmployee) {
		
		employeeService.save(theEmployee);
		
		return "redirect:/employees/list";
	}
	

	
}
