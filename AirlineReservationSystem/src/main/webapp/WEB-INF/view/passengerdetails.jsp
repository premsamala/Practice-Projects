<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
</head>
<body>
	<p>The flight details you've selected are:</p>
	<table>

		<thead>
			<tr>
				<th>Flight ID</th>
				<th>Departure Date</th>
				<th>Departure Time</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Seats Available</th>
				<th>Fare</th>
				<th>Number of Seats Selected</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${flightDetails.flightDetails.flightId}</td>
				<td>${flightDetails.departureDate}</td>
				<td>${flightDetails.departureTime}</td>
				<td>${flightDetails.source}</td>
				<td>${flightDetails.destination}</td>
				<td>${flightDetails.availableSeats}</td>
				<td>${flightDetails.flightDetails.fare}</td>
				<td><a href="javascript:history.back()">Modify Reservation</a></td>
			</tr>
		</tbody>
	</table>

	<p>Please enter passenger details below:</p>
	<%-- <form:form action="passengerdetails" method="post"
		modelAttribute="passengerInformation">
		<c:forEach begin="0" end="${bookingSeats}" varStatus="loop">
			<form:input type="text"
				path="${passengerInformation[loop.index].name}" />
			<br>
			<form:input path="${passengerInformation[loop.index].age}" />
			<br>
			<form:radiobutton path="${passengerInformation[loop.index].gender}"
				value="M" />Male
			<form:radiobutton path="${passengerInformation[loop.index].gender}"
				value="F" />Female
			<br>
		</c:forEach>
		<br>
		<input type="submit" value="Submit" />
	</form:form> --%>

<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
	<script type="text/javascript">
	var count=0;
		$(document).ready(function() {
					$("#add").click(function() {
								count++;
								if(count<3){
								$('#passenger tbody>tr:last').clone(true)
										.insertAfter('#passenger tbody>tr:last');
								return false;
								}
							});
							});
				
	</script>
	<form:form action="passengerdetails" method="post"
		modelAttribute="passengerInformation">
		<table id="passenger">
			<tbody>
				<tr>
					<th>Name:</th>
					<td>Name:<form:input type="text"
							path="${passengerInformation[count].name}" />
					</td>
					<td>Age:<form:input
							path="${passengerInformation[count].age}" />
					</td>

					<td>Gender:<form:radiobutton
							path="${passengerInformation[count].gender}" value="M" />Male
						<form:radiobutton
							path="${passengerInformation[count].gender}" value="F" />Female
					</td>
					<td><button id="add">Add new
								passenger:</button></td>



				</tr>
			</tbody>
		</table>
	</form:form>
	<input type="submit" value="Submit" />



</body>
</html>