<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Instructors</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
		<h2 class="text-center text-primary">List of instructors:</h2>
	</div>
	<div class="container mt-0 p-0">
		

		<table class="table table-hover">

			<thead class="bg-primary">

				<tr class="text-center">
					<th>Instructor ID</th>
					<th>Instructor Firstname</th>
					<th>Instructor LastName</th>
					<th>Instructor Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody class="mx-auto center-block text-center">
				<c:forEach var="tempInstructor" items="${instructors}">

					<c:url var="updateLink" value="updateInstructor">
						<c:param name="instructorId"
							value="${tempInstructor.instructorId}" />
					</c:url>
					<c:url var="deleteLink" value="deleteInstructor">
						<c:param name="instructorId"
							value="${tempInstructor.instructorId}" />
					</c:url>

					<tr>

						<td>${tempInstructor.instructorId}</td>
						<td>${tempInstructor.instructorFirstName}</td>
						<td>${tempInstructor.instructorLastName}</td>
						<td>${tempInstructor.instructorEmailId}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}">Delete</a></td>
					</tr>
					<br />
				</c:forEach>


			</tbody>
		</table>

		<a href="menu" class="btn btn-primary mx-auto center-block"
			role="button">Back to Home Page</a>
	</div>




</body>
</html>