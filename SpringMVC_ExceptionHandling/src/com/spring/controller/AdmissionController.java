package com.spring.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Student;

@Controller
public class AdmissionController {

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public ModelAndView getAdmission() throws IOException {
		 String exceptionOccured = "NULL_POINTER";
		//String exceptionOccured = "ARITHMETIC_POINTER";
		if (exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null pointer Exception");
		} else if (exceptionOccured.equalsIgnoreCase("IO_POINTER")) {
			throw new IOException("IO pointer Exception");
		}
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		return modelAndView;
	}

	// ModelAttribute in method Argument Level
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public ModelAndView admissionForm(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("admissionForm");

			return modelAndView;
		} else {

			ModelAndView modelAndView = new ModelAndView("success");

			return modelAndView;
		}
	}

	// Model Attribute in Method level
	@ModelAttribute
	public void addComments(Model model) {
		model.addAttribute("headerMsg", "Sona College of Tech");
	}

	

}
