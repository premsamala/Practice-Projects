<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
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
		<div class="row mt-5">
			<div class="offset-3 col-6">
				<div class="card shadow bg-white mx-auto">
					<h1 class="card-title text-center bg-info">Welcome to Student
						Portal</h1>
					<div class="card-body">
						<h3 class="text-center">Please select from below:</h3>
						<div class="text-center">
							<a href="enroll" class="btn btn-primary mx-auto center-block"
								role="button">Enroll Courses</a> <a href="displaycourses"
								class="btn btn-primary mx-auto " role="button">Display Courses</a>
								<a href="updatecourses" class="btn btn-primary mx-auto " role="button">Update
								Courses</a>
						</div>
						<br>
						<div class="text-center">
							 <a href="welcome" class="btn btn-primary mx-auto "
								role="button">Back to welcome page</a>
							<a href="logout" class="btn btn-primary mx-auto " role="button">Logout</a>
						</div>
					</div>
				</div>

			</div>
			<div class="col-3"></div>
		</div>
	</div>
	
	
	
</body>
</html>