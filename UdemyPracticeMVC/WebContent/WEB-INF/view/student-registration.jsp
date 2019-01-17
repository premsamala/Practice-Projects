<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Registration</title>
<style>
.error{color:red}
</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name: <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error"/>
		Last Name: <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"/>
		<form:select path="country">
			<form:options items= "${countryOptions}"/>
		</form:select>
		<form:errors path="country" cssClass="error"/>
	
		<input type="submit" value="Submit"/>"
	</form:form>
</body>
</html>