<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Success</title>
</head>
<body>
	<table>
		<tr>
			<th>PNR:</th>
			<td> ${ticketdetails.pnr} </td>
		</tr>
		<tr>
		
			<th>Flight Number</th>
			<td> ${reservationdetails.flightDetails.flightId} </td>
		
		</tr>
		<tr>
		
			<th>Departure Date</th>
			<td> ${reservationdetails.departureDate} </td>
		
		</tr>
		<tr>
		
			<th>Departure time</th>
			<td> ${reservationdetails.departureTime} </td>
		
		</tr>
		
		<tr>
		<c:forEach var="temp" items="${passengerdetails }">
			<th>Number of Passengers:</th>
			<td> ${temp.name} </td>
		</c:forEach>
		</tr>
		<tr>
		
			<th>Total Fare:</th>
			<td> ${totalFare} </td>
		
		</tr>
	
	</table>
</body>
</html>