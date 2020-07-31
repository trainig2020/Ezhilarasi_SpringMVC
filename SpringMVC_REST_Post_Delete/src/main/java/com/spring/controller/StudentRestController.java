package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.model.Student;

@RestController
public class StudentRestController {

	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentList() {
		Student student1 = new Student();
		student1.setStudentName("Ezhilarasi");
		Student student2 = new Student();
		student2.setStudentName("Sandhiya");
		Student student3 = new Student();
		student3.setStudentName("Ratheesh");

		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		return studentList;
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {
		Student student1 = new Student();
		student1.setStudentName(studentName);
		return student1;

	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName,
			@RequestBody Student student) {
		System.out.println("Student Name :" + studentName);
		System.out.println("StudentName : " + student.getStudentName() + " Age is " + student.getAge());

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("key1", "value1");
		httpHeaders.add("key2", "value2");
		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.OK);

	}

	@RequestMapping(value = "/student", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createStudent(@RequestBody Student student) {

		System.out.println("StudentName : " + student.getStudentName() + " Age is " + student.getAge());
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
				.buildAndExpand(student.getStudentName()).toUri().toString());
		return new ResponseEntity<Boolean>(true, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/students/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName) {
		System.out.println("Student Name :" + studentName);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = "/students", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAllStudent() {

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}