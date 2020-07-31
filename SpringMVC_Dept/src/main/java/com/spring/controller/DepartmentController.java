package com.spring.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Department;

import com.spring.service.DepartmentService;
import com.spring.service.DepartmentServiceImpl;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService = new DepartmentServiceImpl();
	
	@RequestMapping(value = "/listDept", method=RequestMethod.GET)
	public ModelAndView listDepartment(HttpServletRequest request) {

		List<Department> lst = departmentService.getAllDepartments();
		ModelAndView modelAndView2 = new ModelAndView("departmentForm");
		modelAndView2.addObject("deptList", lst);
		HttpSession session = request.getSession();
		session.setAttribute("deptList", lst);
		return modelAndView2;
	}

	@RequestMapping(value = "/newDept", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model,HttpServletRequest request) {
		String Register  = "NewDept";
		HttpSession session1 = request.getSession();
		List<Department> lst =(List<Department>)session1.getAttribute("deptList");
		session1.setAttribute("deptList", lst);
		model.addObject("Register", Register);
		model.addObject("insertDept", "newDept");
		model.setViewName("departmentForm");
		Department department = new Department();
		model.addObject("department", department);
		return model;
	}

	@RequestMapping(value = "/saveDept", method = RequestMethod.POST)
	public ModelAndView saveDepartment( @ModelAttribute Department department) throws Exception {
		
		
		Department department1 = new Department();
		department1.setDeptId(department.getDeptId());
		department1.setDeptName(department.getDeptName());
		departmentService.insertDepartment(department1);
		return new ModelAndView("redirect:/listDept");
		}
	

	@RequestMapping(value = "/deleteDept", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(HttpServletRequest request) {
		int departId = Integer.parseInt(request.getParameter("id"));
		departmentService.deleteDepartment(departId);
		return new ModelAndView("redirect:/listDept");
	}

	@RequestMapping(value = "/updateDept", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int departId = Integer.parseInt(request.getParameter("id"));
		HttpSession session2 = request.getSession();
		Department department = departmentService.getDeptById(departId);
		session2.setAttribute("department",department);
		List<Department> lst =(List<Department>) session2.getAttribute("deptList");
		session2.setAttribute("deptList", lst);
		ModelAndView model = new ModelAndView("departmentForm");
		model.addObject("deptList", lst);
		model.addObject("departId", departId);    
		return model;
	}
}
