package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDao;
import com.spring.dao.EmployeeDaoImpl;
import com.spring.model.Employee;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao dao = new EmployeeDaoImpl();

	

	@Override
	public void insertEmployee(Employee emp) {
		 dao.insertEmployee(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		 dao.updateEmployee(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		
		 dao.deleteEmployee(id);
	}

	@Override
	public Employee getEmployees(int deptId) {

		return dao.getEmployees(deptId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
