package com.spring.controller;



import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class HelloController {
	
	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView helloWorld(@PathVariable("userName") String name, @PathVariable("countryName") String country){
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Hello..... "+name+ " You are from " +country);
		return modelAndView;
	}
	
	
	@RequestMapping("/hi/{countryName}/{userName}")
	public ModelAndView hiiWorld(@PathVariable Map<String, String> pathVars){
		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Hii ..... "+name+ " You are from " +country);
		return modelAndView;
	}
	

}
