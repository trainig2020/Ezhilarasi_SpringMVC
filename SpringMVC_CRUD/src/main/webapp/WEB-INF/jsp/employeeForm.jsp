<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/SpringMVC_DeptEmp/listEmp?siteLanguage=en">English</a>|
	<a href="/SpringMVC_DeptEmp/listEmp?siteLanguage=fr">French</a>

	<a href="newEmp"> <h3>Insert New Employee</h3></a>
	
	<c:if test="${employeeVa != null}">
		<form action="updateEmp" >
	</c:if>
	<c:if test="${employeeVa == null}">
		<form action="saveEmp" method="post">
	</c:if>

	<table border="1" style="width: 50%"background-color:#eee;>
		<thead>
			<tr>
				<th>EmpID</th>
				<th>EmpName</th>
				<th>EmpAge</th>
				<th>DeptId</th>		
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listEmployee}" var="lstEmp">
			      		
				<c:if test="${employeeVa.empId eq lstEmp.empId}">
					<tr>
						<td><input type="" name="empId"
							value="${lstEmp.empId}" readonly="readonly" /></td>
						<td><input type="text" name="empName"
							value="${lstEmp.empName}" /></td>
							<td><input type="text" name="age"
							value="${lstEmp.age}" /></td>
							<td><input type="text" name="deptId"
							value="${lstEmp.deptId}" /></td>
						
						<td><input type="submit" value="update" /></td>
					</tr>
				</c:if>
				<c:if test="${employeeVa.empId ne lstEmp.empId}">
					<tr>
						
                    <td>${lstEmp.empId}</td>
                    <td>${lstEmp.empName}</td>
                    <td>${lstEmp.age}</td>
                    <td>${lstEmp.deptId}</td>
                    
                    <td><a href="editEmp?empId=${lstEmp.empId}">Update</a></td>
                     <td><a href="deleteEmp?empId=${lstEmp.empId}">Delete</a></td>
					</tr>
				</c:if>
				</c:forEach>
					<c:if test="${addEmp eq 'regEmp'}">
						<tr>
							<td><input type="text" name="empId" /></td>
							<td><input type="text" name="empName" /></td>
							<td><input type="text" name="age" /></td>
							<td><input type="text" name="deptId" /></td>
							
							<td colspan="2"><input type="submit" value="save"/></td>
						</tr>
					</c:if>	
		</tbody>
	</table>
</form>
</body>
</html>