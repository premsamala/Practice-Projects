<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.studentportal.entity.Instructor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Instructor</title>
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
		<div class="offset-3 col-6">
			<div class="card shadow bg-white mx-auto">
				<h1 class="card-title text-center bg-info">Welcome to Student
					Portal</h1>
				<div class="card-body">
					<h2 class="text-center text-primary">Please enter Course
						Details:</h2>
					<form:form action="savecourse" method="POST"
						modelAttribute="course">
						<form:hidden path="courseId" />

						<table class="table mx-auto center-block table-hover">

							<tbody class="mx-auto center-block text-center">
								<tr>
									<th>Course Name:</th>
									<td><form:input path="courseName" /></td>
								</tr>
								<tr>
									<th>Course Credits:</th>
									<td><form:input path="credits" /></td>
								</tr>
								<tr>
									<th>Instructor:</th>
									<td><form:select path="instructorId">
											<c:forEach items="${instructors}" var="tempInstructor">
												<form:option value="${tempInstructor.instructorId}"> ${tempInstructor.instructorId}-${tempInstructor.instructorFirstName}, ${tempInstructor.instructorLastName} </form:option>
											</c:forEach>
										</form:select></td>

								</tr>


							</tbody>
						</table>
						<div class="text-center">
							<button class="btn btn-primary mx-auto center-block"
								type="submit">Submit</button>
						</div>
					</form:form>
					<a href="menu" class="btn btn-primary mx-auto center-block"
						role="button">Back to Home Page</a>
				</div>
			</div>
		</div>
		<div class="col-3"></div>
	</div>





</body>
</html>