<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Search</title>
</head>
<body>
	Hi there! Please enter your travel details:
	<table>
		<form:form action="flightsearch" method="get" modelAttribute="flightSearch">
			<tr>
				<th>Source:</th>
				<td><form:select path="source">
						<form:options items="${flightPlaces}" />
					</form:select></td>
			</tr>
			<tr>
				<th>Destination:</th>
				<td><form:select path="destination">
						<form:options items="${flightPlaces}" />
					</form:select></td>
			</tr>
			<tr>
				<th>Date of journey:</th>
				<td><form:input type="date" path="date" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset"></td>
			</tr>
		</form:form>
	</table>
	<p>${flightSearchError}</p>
</body>
</html>