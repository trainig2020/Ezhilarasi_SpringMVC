<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${headerMsg}</h2>
	<form:errors path="student.*" />
	<form action="submit" method="post">

		StudentName : <input type="text" name="studentName"><br>
		StudentAge : <input type="text" name="age"><br>
		StudentHobby : <input type="text" name="studentHobby"><br>
		StudentNumber : <input type="text" name="mobileNo"><br>
		StudentDOB : <input type="text" name="dob"><br>
		StudentSkills : <select name="skills" multiple>

			<option value="java">Java</option>
			<option value=".net">.net</option>
		</select><br>
		<h3>Student Address:</h3>
		<br> Street : <input type="text" name="address.street"><br>
		City : <input type="text" name="address.city"><br> State
		: <input type="text" name="address.state"><br> Pincode :
		<input type="text" name="address.pincode"><br> <input
			type="submit" value="submit">


	</form>
</body>
</html>