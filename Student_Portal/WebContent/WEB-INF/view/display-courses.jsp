<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses Enrolled</title>
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
		<h2 class="text-center text-primary">List of Courses:</h2>

		<table class="table mt-0 center-block table-hover">

			<thead class="bg-primary">

				<tr class="mx-auto center-block text-center">
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Course Credits</th>
					<th>Instructor</th>
				</tr>
			</thead>
			<tbody class="mx-auto center-block text-center">

				<c:forEach var="temp" items="${courses}">
					<tr>
						<td>${temp.courseId}</td>
						<td>${temp.courseName}</td>
						<td>${temp.credits}</td>
						<td>${temp.getInstructor().instructorFirstName}
							${temp.getInstructor().instructorLastName}</td>

					</tr>

				</c:forEach>

			</tbody>
		</table>

		<a href="menu" class="btn btn-primary mx-auto center-block"
			role="button">Back to Home Page</a>
	</div>



</body>
</html>