<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
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

		<div class="row">

			<div class="card shadow-lg bg-white mx-auto mt-4">

				<h3 class="card-title bg-primary mx-auto text-center">Hello!
					Welcome to Student Portal</h3>

				<div class="card-body mx-auto center-block">

					<form action="initiallogin" method="POST">

						<table class="table mx-auto center-block table-hover">

							<tr>
								<th>Please enter your student ID:</th>
								<td><input type="text" name="studentId" /></td>
						</table>

						<div class="text-center">
							<button class="btn btn-primary mx-auto center-block"
								type="submit">Submit</button>
						</div>

					</form>
					<p class="text-danger text-center">${errormessage}</p>
				</div>
				<a href="backtowelcome" class="btn btn-primary mx-auto center-block"
					role="button">Back to Home Page</a>
			</div>



		</div>

	</div>



</body>
</html>