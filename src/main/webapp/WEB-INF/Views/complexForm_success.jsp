<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>Name: ${student.name}</p>
	<p>Age: ${student.age}</p>
	<p>Subjects: ${student.subjects}</p>
	<p>Address Street: ${student.address.street}</p>
	<p>Address City: ${student.address.city}</p>

</body>
</html>