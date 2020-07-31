package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import com.spring.model.Employee;
import com.spring.service.EmployeeService;
import com.spring.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService = new EmployeeServiceImpl();

	@RequestMapping(value = "listEmp", method = RequestMethod.GET)
	public ModelAndView listEmployee(ModelAndView modelAndView) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		modelAndView.addObject("listEmployee", listEmployee);
		modelAndView.setViewName("employeeForm");
		return modelAndView;
	}

	@RequestMapping(value = "newEmp", method = RequestMethod.GET)
	public ModelAndView showFormForAdd(ModelAndView modelAndView) {
		//modelAndView.addObject("newtab", "ntabl");
		modelAndView.addObject("addEmp", "regEmp");
		List<Employee> listEmployee = employeeService.getAllEmployees();
		modelAndView.addObject("listEmployee", listEmployee);
		Employee employee = new Employee();
		modelAndView.addObject("employee", employee);
		modelAndView.setViewName("employeeForm");
		return modelAndView;
	}

	@RequestMapping(value = "saveEmp")
	public ModelAndView saveEmployee( @ModelAttribute("employee") Employee employee) {
		Employee employee1 = new Employee();
		employee1.setEmpId(employee.getEmpId());
		employee1.setEmpName(employee.getEmpName());
		employee1.setAge(employee.getAge());
		employee1.setDeptId(employee.getDeptId());
		employeeService.insertEmployee(employee1);

		return new ModelAndView("redirect:/listEmp");
	}

	@RequestMapping(value = "/editEmp", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request,ModelAndView modelAndView) {
		int id = Integer.parseInt(request.getParameter("empId"));
		Employee employee = employeeService.getEmployees(id);
		List<Employee> lstEmp = employeeService.getAllEmployees();
		modelAndView.addObject("employeeVa", employee);
		modelAndView.addObject("listEmployee", lstEmp);
		modelAndView.setViewName("employeeForm");
		return modelAndView;
		
		
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
	public ModelAndView updateEmployee(HttpServletRequest request, @ModelAttribute Employee employee) {
		
		
		  Employee employee1 = new Employee();
		  employee1.setEmpId(employee.getEmpId());
		  employee1.setEmpName(employee.getEmpName());
		  employee1.setAge(employee.getAge());
		  employee1.setDeptId(employee.getDeptId());
		 
		employeeService.updateEmployee(employee1);

		return new ModelAndView("redirect:/listEmp");

	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("empId"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/listEmp");
	}

}
