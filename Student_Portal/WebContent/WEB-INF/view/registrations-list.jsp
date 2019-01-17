<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrations List</title>

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
		<h2 class="text-center text-primary">List of Registrations:</h2>
	</div>
	<div class="container mt-0 p-0">
		<form:form action="deleteregistration" modelAttribute="student">
			<table class="table table-hover">
				<thead class="bg-primary">
					<tr class="text-center">
						<th>Student ID</th>
						<th>Student Name</th>
						<th>Enrolled Courses</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody class="mx-auto center-block text-center">
					<c:forEach var="tempStudent" items="${students}">
						<tr>
							<c:if test="${tempStudent.getCourses().size() >0}">

								<td><form:radiobutton path="id"
										value="${tempStudent.studentId}" />${tempStudent.studentId}</td>
								<c:url var="delete" value="deleteregistration">
									<c:param name="studentId" value="${tempStudent.studentId}" />
								</c:url>
								<td>${tempStudent.studentFirstName},
									${tempStudent.studentLastName}</td>
								<td><form:select path="courseSelection">

										<c:forEach var="tempCourse"
											items="${tempStudent.getCourses()}">
											<form:option value="${tempCourse.courseId}">${tempCourse.courseId}-${tempCourse.courseName}</form:option>
										</c:forEach>
									</form:select></td>
								<td><button class="btn btn-primary mx-auto center-block"
										type="submit">Delete</button></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</form:form>
		<a href="menu"
			class="btn btn-primary mx-auto center-block" role="button">Back
			to Home Page</a>
	</div>
</body>
</html>