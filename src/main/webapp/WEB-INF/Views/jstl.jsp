<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<html>

<body>
	<h2>Hello World! I am from Spring MVC</h2>
</body>


<% 
    
    StringBuilder sb = new StringBuilder();

    String[] strArr = (String[]) request.getAttribute("full_name");

    for(String name : strArr){
          
    	sb.append("<li> "+ name+ " </li>");
    	
    }
	
%>

<h1>My Name is using JSP model and view:</h1>

<%= sb.toString()%>

<br></br>

<h1>My Name is using JSTL:</h1>

<c:forEach var="item" items = "${full_name}" >

<li> ${ item }</li>

</c:forEach>

<h1>My Roll Number using JSP expression lanuaguage is: ${roll_number}</h1>

</html>
