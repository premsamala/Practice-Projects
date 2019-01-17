<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Hi! Please enter your login details:</h1>
	<form:form action="verifyuser" method="post" modelAttribute="loginWelcome">
		<form:input type="text" path="username" />
		<form:input type="password" path="password" />
		<input type="submit" value="Submit" />
	</form:form>
	<p>${loginError}</p>
</body>
</html>