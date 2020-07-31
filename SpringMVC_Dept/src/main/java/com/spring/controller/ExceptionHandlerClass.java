package com.spring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {
	
	@ExceptionHandler(value = Exception.class) 
	public String handleException(Exception e) {
		System.out.println(" Exception occured : " + e);
		return "exception";
	}

}
