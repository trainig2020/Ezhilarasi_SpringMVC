<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<a href="newDept"> <h3>Insert New Department</h3></a>
	
	<c:if test="${Register eq 'NewDept'}">
		<form action="saveDept" method="post">
	</c:if>
	<c:if test="${Register ne 'NewDept'}">
		<form action="saveDept" method="post">
	</c:if>

	<table border="1" style="width: 50%"background-color:#eee;>
		<thead>
			<tr>
				<th>DeptID</th>
				<th>DeptName</th>		
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deptList}" var="dept">
			      		
				<c:if test="${departId eq dept.deptId}">
					<tr>
						<td><input type="" name="deptId"
							value="${dept.deptId}" readonly="readonly" /></td>
						<td><input type="text" name="deptName"
							value="${dept.deptName}" /></td>
						
						<td><input type="submit" value="update" /></td>
					</tr>
				</c:if>
				<c:if test="${departId ne dept.deptId}">
					<tr>
						
                    <td>${dept.deptId}</td>
                    <td>${dept.deptName}</td>
                    
                    <td><a href="updateDept?id=${dept.deptId}">Update</a></td>
                     <td><a href="deleteDept?id=${dept.deptId}">Delete</a></td>
					</tr>
				</c:if>
				</c:forEach>
					<c:if test="${insertDept eq 'newDept'}">
						<tr>
							<td><input type="text" name="depId" /></td>
							<td><input type="text" name="deptName" /></td>
							
							<td colspan="2"><input type="submit" value="save"/></td>
						</tr>
					</c:if>	
		</tbody>
	</table>
</form>
</center>
</body>
</html>