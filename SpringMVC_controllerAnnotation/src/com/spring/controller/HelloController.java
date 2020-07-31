package com.spring.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/greet")
public class HelloController {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(){
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Hii.....Welcome to Spring MVC application");
		return modelAndView;
	}
	
	@RequestMapping("/hii")
	public ModelAndView heWorld(){
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("welcomeMessage", "Ezhil.....Welcome to Spring MVC application");
		return modelAndView;
	}

}
