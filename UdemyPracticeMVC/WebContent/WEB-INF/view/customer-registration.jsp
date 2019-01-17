<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Registration Form</title>

<style>
table, th, td {
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
}

.error {
	color: red
}
</style>
</head>
<body>
	<h1>Enter the following details to complete registration</h1>
	<form:form action="processForm" modelAttribute="customer">
		<table style="width: 100%">
			<tr>
				<th>First Name:</th>
				<td><form:input path="firstName" />
				<form:errors path="firstName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><form:input path="lastName" /> <form:errors
						path="lastName" cssClass="error"></form:errors></td>

			</tr>
			<tr>
				<th>Customer ID:</th>
				<td><form:input path="customerId" /> <form:errors
						path="customerId" cssClass="error"></form:errors></td>

			</tr>
			<tr>
				<th>Gender</th>
				<td><form:radiobutton path="gender" value="Male" label="Male" />
					<form:radiobutton path="gender" value="Female" label="Female" /> <form:errors
						path="gender" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Age:</th>
				<td><form:input path="address.age" /> <form:errors
						path="address.age" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<th>Country:</th>
				<td><form:select path="country">
						<li><form:options items="${countryOptions}" /></li>
					</form:select></td>
			</tr>
			<!--  <tr>
				<th>Games:</th>
				<c:forEach var="temp" items="${favGames}">
				<td><form:checkbox path="favGames" value="${temp}" label="${temp}"/></td>
				</c:forEach>
				</tr> -->
			<tr>
				<th>Games:</th>
				<td colspan="3"><form:checkboxes path="favGames"
						items="${favGames}" value="${favGames}" /></td>
			</tr>
			<tr>
				<th>Address:</th>
			</tr>
			<tr>
				<th>Street Address:</th>
				<td><form:input path="address.streetAddress" /> <form:errors
						path="address.streetAddress" cssClass="error">
					</form:errors></td>

				<th>City:</th>
				<td><form:input path="address.city" /> <form:errors
						path="address.city" cssClass="error"></form:errors></td>
				<th>State:</th>
				<td><form:input path="address.state" /> <form:errors
						path="address.state" cssClass="error"></form:errors></td>
				<th>ZipCode:</th>
				<td><form:input path="address.zipCode" /> <form:errors
						path="address.zipCode" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>