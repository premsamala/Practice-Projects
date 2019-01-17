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

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script type="text/javascript">
		var rowcount;
		
		$(document).ready(function() {
			var rowCount = 2;
			$("#passengerscount").val(rowCount-1); 
							$("#add").click(function() {
												 
												 
												if (rowCount < 4) {
													
													$("#" + rowCount).show();
													$("#temp" + rowCount).attr("required", "true");
													rowCount++;
													var val = $("#passengerscount").get(0).value;
													$("#passengerscount").val(rowCount-1); 
													/* 
													var newRow = $("#passenger     tr:last").clone(true).find(':input').val('').end();

													  $("#passenger").append(newRow); */
													return false;
												} else {
													$('#passengerserror')
															.html(
																	'Reservation can be made only upto 3 persons');
												}
											});
						});
	</script>
	<%-- <%! int count; %> --%>

	<!-- <input type="hidden" name="tempvar" value="0"> -->
	<form:form action="passengerdetails" method="post"
		modelAttribute="passengerInformation">
		<table id="passenger">
			<%-- <% count=0; %> --%>
			<c:set var="count" scope="session" value="1"></c:set>
			<tbody>
				<tr>
					<td>Name:<form:input name="name"
							path="passengerInformationList[${count}].name" required="true" />
					</td>
					<td>Age:<form:input name="age"
							path="passengerInformationList[${count}].age" required="true" />
					</td>

					<td>Gender:<form:radiobutton
							path="passengerInformationList[${count}].gender" value="M" required="true"/>Male
						<form:radiobutton path="passengerInformationList[${count}].gender"
							value="F" />Female
					</td>
				</tr>
				<c:forEach var="temp" begin="2" end="3">

					<tr id="${temp}" hidden="true">
						<td>Name:<form:input name="name" id="temp${temp}"
								path="passengerInformationList[${temp}].name"  />
						</td>
						<td>Age:<form:input name="age" id="temp${temp}"
								path="passengerInformationList[${temp}].age"  />
						</td>

						<td>Gender:<form:radiobutton id="temp${temp}"
								path="passengerInformationList[${temp}].gender" value="M" />Male
							<form:radiobutton path="passengerInformationList[${temp}].gender"
								value="F" />Female
						</td>


					</tr>

				</c:forEach>
				<tr>
					<td><button id="add" value="addbuttonconfirm" name="addbutton"
							type="button">Add new passenger:</button></td>
					<td><input type="hidden" id="passengerscount"
						name="passengerscount" value="1" /></td>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>

			</tbody>
		</table>





	</form:form>
	<p id="passengerserror"></p>
	<a href="javascript:history.back()">Go Back</a>



</body>
</html>