package com.javaapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaapp.Entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
	
}
