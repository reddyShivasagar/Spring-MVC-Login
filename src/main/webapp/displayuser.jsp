<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


		<table border="3px">
		
		<tr>
		
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Action</th>
		
		</tr>
		
		<c:forEach var="user" items="${alluser}">
		
		
		<tr>
		
		<td>${user.id}</td>
		<td>${user.name }</td>
		<td>${user.email }</td>
		<td>${user.password }</td>
		<td><a href="deleteUser?id=${user.id}"><input type="submit" value="DELETE"></a></td>
		
		</tr>
		
		</c:forEach>
		
		
		</table>

</body>
</html>