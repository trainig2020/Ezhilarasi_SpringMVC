package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.model.Employee;

@ControllerAdvice
public class ExceptionHandlingClass {
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullException(Exception e, @ModelAttribute Employee employee) {
		if(employee.getEmpName()== null || employee.getEmpName()=="")
		System.out.println("Null Pointer Exception occured : " + e);
		return "nullPointerException";
	}

}
