package com.javaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaapp.Entity.Employee;
import com.javaapp.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired(required=true)
	public EmployeeRepo employeeRepo;

	public List<Employee> getAllEmps(){
		return employeeRepo.findAll();
	}
	
	public Employee addEmployees(Employee e) throws Exception{
		if(e.getName().length() > 5) {
			throw new Exception("sorry please add first five letters of name");
		}
			return employeeRepo.save(e);
	}
}
