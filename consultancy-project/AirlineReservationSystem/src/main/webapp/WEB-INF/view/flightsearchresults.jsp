<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
	<p>Below are the flights available:</p>
		<table>

			<thead>
				<tr>
					<th>Departure Date</th>
					<th>Departure Time</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Seats Available</th>
					<th>Fare</th>
					<th>Number of Seats</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="var" items="${flightSearchResults}">

					<tr>
						<td>${var.flightDetails.flightId}</td>
						<td>${var.departureDate}</td>
						<td>${var.departureTime}</td>
						<td>${var.source}</td>
						<td>${var.destination}</td>
						<td>${var.availableSeats}</td>
						<td>${var.flightDetails.fare}</td>
						<c:url var="bookflight" value="bookflight">
							<c:param name="flightId" value="${var.flightDetails.flightId}"/>
						</c:url>
						<td><a href="${bookflight}"><button>Book</button></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	<a href="javascript:history.back()">Go Back</a>
</body>
</html>