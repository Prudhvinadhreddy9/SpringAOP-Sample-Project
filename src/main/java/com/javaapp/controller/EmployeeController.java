package com.javaapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaapp.Entity.Employee;
import com.javaapp.service.EmployeeService;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	
	@Autowired(required=true)
	EmployeeService employeeService;
	
	@GetMapping("/all")
	public  ResponseEntity<?> fetchAllEmployees(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmps(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public  ResponseEntity<?> addEmployee(@RequestBody Employee e) throws Exception{
		return new ResponseEntity<Employee>(employeeService.addEmployees(e), HttpStatus.OK);
	}
	
}
