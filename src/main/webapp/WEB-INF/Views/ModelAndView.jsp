<html>
<body>
	<h2>Hello World! I am from Spring MVC</h2>
</body>


<% 
    
    StringBuilder sb = new StringBuilder();

    String[] strArr = (String[]) request.getAttribute("full name");

    for(String name : strArr){
          
    	sb.append("<li> "+ name+ " </li>");
    	
    }
	
%>

<h1>My Name is:</h1>

<%= sb.toString()%>

</html>
