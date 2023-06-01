package com.javaapp.controller.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.javaapp.Entity.Employee;

@Aspect
@Component
public class EmployeeAspect {
	
	
	/* 
	 * Adding the below changes for controller layer
	 * 
	 * */
	@Before(value = "execution(* com.javaapp.controller.EmployeeController.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Requesting to fetch" + joinPoint.getSignature()+ "Started at "  + new Date());
	}
	
	@After(value = "execution(* com.javaapp.controller.EmployeeController.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("Requesting to fetch" + joinPoint.getSignature()+ "ended_at"  + new Date());
	}
	
	
	/* 
	 * Adding the below changes for Service layer
	 * 
	 * */
	
	@Before(value = "execution(* com.javaapp.service.EmployeeService.*(..))")
	public void beforeAdviceService(JoinPoint joinPoint) {
		System.out.println("Requesting to fetch" + joinPoint.getSignature()+ "Started at Service layer "  + new Date());
	}
	
	@After(value = "execution(* com.javaapp.service.EmployeeService.*(..))")
	public void afterAdviceService(JoinPoint joinPoint) {
		System.out.println("Requesting to fetch" + joinPoint.getSignature()+ "ended at Service layer"  + new Date());
	}
	
	@AfterReturning(value = "execution(* com.javaapp.service.EmployeeService.addEmployee(..))" , returning = "employee")
	public void afterreturningAdviceService(JoinPoint joinPoint,  Employee employee) {
		System.out.println("Saved the employee successfully ended at Service layer"  + employee.getId());
	}
	
	@AfterThrowing(value = "execution(* com.javaapp.service.EmployeeService.addEmployee(..))", throwing = "exception")
	public void afterthrowingAdviceService(JoinPoint joinPoint,  Exception exception) {
		System.out.println("Saved the employee successfully ended at Service layer"  + exception.getMessage());
	}
	
	@Around(value="execution(* com.javaapp.service.EmployeeService.addEmployee(..))")
	public Employee aroundAdviceService(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println(" Inside Around Advice : Saved the employee successfully started  at Service layer " + new Date());
		try {
			Employee employee = (Employee)proceedingJoinPoint.proceed();
			return employee;
		}catch(Throwable e) {
			System.out.println(" Inside Around for throwing an exception failed to save in DB"+ e.getMessage());
		} 
		
		System.out.println("Inside Around Advice : After executed Saved the employee successfully ended at Service layer \" + new Date()");
		return null;
	}
	
}
