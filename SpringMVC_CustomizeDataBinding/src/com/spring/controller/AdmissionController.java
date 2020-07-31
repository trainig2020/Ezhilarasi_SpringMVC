package com.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Student;



@Controller
public class AdmissionController {
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		//binder.setDisallowedFields(new String[]{"mobileNo"});
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName", new NameEditor());
	}
	
	@RequestMapping(value = "welcome1", method=RequestMethod.GET)
	public ModelAndView getAdmission(){
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		return modelAndView;
	}
	
	
	
	//ModelAttribute in method Argument Level
	@RequestMapping(value = "submit", method=RequestMethod.POST)
	public ModelAndView admissionForm(@ModelAttribute("student") Student student, BindingResult result){
		if(result.hasErrors()){
			ModelAndView modelAndView = new ModelAndView("admissionForm");
			
			
			return modelAndView;
		}
		else{
		
		ModelAndView modelAndView = new ModelAndView("success");
		
		
		return modelAndView;
		}
	}
	
	//Model Attribute in Method level
	@ModelAttribute
	public void addingCommonObjects(Model model){
		model.addAttribute("headerMsg", "Sona College of Tech");
	}

}
