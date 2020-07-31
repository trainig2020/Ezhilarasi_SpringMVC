<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<link rel="stylesheet"
		href="<spring:theme code='styleSheet'></spring:theme>" type="text/css" />

	<a href="/SpringMVC_Internationalization/welcome?siteTheme=green">Green</a>|
	<a href="/SpringMVC_Internationalization/welcome?siteTheme=red">Red</a><br>

	<a href="/SpringMVC_Internationalization/welcome?siteLanguage=en">English</a>|
	<a href="/SpringMVC_Internationalization/welcome?siteLanguage=fr">French</a>
	<h3>
		<spring:message code="welcome.message" />
	</h3>
	<h2>${headerMsg}</h2>
	<form:errors path="student.*" />
	<form action="submit" method="post">

		<spring:message code="label.studentName" />
		<input type="text" name="studentName"><br> StudentAge : <input
			type="text" name="age"><br> StudentHobby : <input
			type="text" name="studentHobby"><br> StudentNumber : <input
			type="text" name="mobileNo"><br> StudentDOB : <input
			type="text" name="dob"><br> StudentSkills : <select
			name="skills" multiple>

			<option value="java">Java</option>
			<option value=".net">.net</option>
		</select><br>
		<h4>Student Address:</h4>
		<br> Street : <input type="text" name="address.street"><br>
		City : <input type="text" name="address.city"><br> State
		: <input type="text" name="address.state"><br> Pincode :
		<input type="text" name="address.pincode"><br> <input
			type="submit" value="submit">


	</form>
</body>
</html>