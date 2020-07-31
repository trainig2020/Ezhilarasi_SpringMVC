<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Congratulation</h1>
<h2>${headerMsg}</h2>

<h3> Details Submitted by you :</h3>
StudentName : ${student.studentName}
Age :${student.age}
StudentNumber :${student.mobileNo}
DOB :${student.dob}
StudentSkills : ${student.skills}

<h3>Student address :</h3>
Street : ${student.address.street}
city :${student.address.city}
state :${student.address.state}
Pincode :${student.address.pincode}

</body>
</html>