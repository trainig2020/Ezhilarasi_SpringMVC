package com.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertEmployee(Employee emp) {

		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();
			session.save(emp);
			System.out.println("Datas Inserted");
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee emp) {

		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();
			session.update(emp);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployees(int deptId) {

		Employee emp_det = null;
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		emp_det = (Employee) session.get(Employee.class, deptId);

		System.out.println("EmpID  : " + emp_det.getEmpId() + " EmpName  :" + emp_det.getEmpName() + " Age  : "
				+ emp_det.getAge() + " DeptId  : " + emp_det.getDeptId());

		return emp_det;

	}

	
	@Override
	public void deleteEmployee(int empId) {

		
		
			Session session = sessionFactory.getCurrentSession();


			Employee emp1 = (Employee) session.get(Employee.class, empId);

			session.delete(emp1);

			
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() {
		//List<Employee> lstOfEmp = null;
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();

		List<Employee> lstOfEmp = session.createQuery("from Employee").list();

		for (Employee emp : lstOfEmp) {
			System.out.println("EmpID is : " + emp.getEmpId() + " EmpName is :" + emp.getEmpName());
		}

		return lstOfEmp;

	}

}
