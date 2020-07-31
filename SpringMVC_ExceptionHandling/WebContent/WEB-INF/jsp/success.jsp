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
StudentName : ${student.studentName}<br>
Age :${student.age}<br>
StudentHobby : ${student.studentHobby}<br>
StudentNumber :${student.mobileNo}<br>
DOB :${student.dob}<br>
StudentSkills : ${student.skills}<br>

<h3>Student address :</h3><br>
Street : ${student.address.street}<br>
city :${student.address.city}<br>
state :${student.address.state}<br>
Pincode :${student.address.pincode}

</body>
</html>