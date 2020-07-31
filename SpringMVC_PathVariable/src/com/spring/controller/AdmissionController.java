package com.spring.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdmissionController {
	
	@RequestMapping(value = "welcome1", method=RequestMethod.GET)
	public ModelAndView getAdmission(){
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		return modelAndView;
	}
	
	@RequestMapping(value = "submit", method=RequestMethod.POST)
	public ModelAndView admissionForm(@RequestParam(value = "studentName" , defaultValue="Mr.xyz") String name,@RequestParam("studentAge") int age){
		ModelAndView modelAndView = new ModelAndView("success");
		modelAndView.addObject("msg", "Details submitted by you where Name : "+name+" Ur age is "+age);
		return modelAndView;
	}

}
