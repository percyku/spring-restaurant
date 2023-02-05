<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Percy - Access Denied</title>
</head>
<body>
	<h2>Access Denied - You are not authorized to access this resource.</h2>
	
	<hr>
	
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>


	<form:form action="${pageContext.request.contextPath}/logout" method ="POST">
    	<input type="submit" value="Logout"/>
    </form:form>

</body>
</html>