package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Student;

@RestController
public class StudentRestController {
	
	@RequestMapping(value = "/students", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentList(){
		Student student1 = new Student();
		student1.setStudentName("Ezhilarasi");
		Student student2 = new Student();
		student2.setStudentName("Sandhiya");
		Student student3 = new Student();
		student3.setStudentName("Ratheesh");
		
		List<Student> studentList  = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		return studentList;
	}
	
	
	@RequestMapping(value = "/students/{name}", method=RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName){
		Student student1 = new Student();
		student1.setStudentName(studentName);
		return student1;

}
}
