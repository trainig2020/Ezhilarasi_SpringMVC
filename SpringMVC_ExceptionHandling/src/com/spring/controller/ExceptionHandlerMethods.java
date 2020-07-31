package com.spring.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerMethods {

	@ExceptionHandler(value = Exception.class) // --> If unknown exception
	// occurred, this generic
	// exception will handle
	public String handleException(Exception e) {
		System.out.println(" Exception occured : " + e);
		return "exception";
	}
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullException(Exception e) {
		System.out.println("Null Pointer Exception occured : " + e);
		return "nullPointerException";
	}

	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception e) {
		System.out.println("IO Exception occured : " + e);
		return "ioException";
	}

}
