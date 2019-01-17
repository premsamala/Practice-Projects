<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>

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
					<h2 class="text-center text-primary">Please enter your login
						credentials:</h2>
					<form action="loginAuthenticate" method="post">


						<table class="table mx-auto center-block table-hover">

							<tbody class="mx-auto center-block text-center">
								<tr>
									<th>username:</th>
									<td><input type="text" name="userName" /></td>
								</tr>
								<tr>

									<th>password:</th>
									<td><input type="password" name="password" /></td>
								</tr>


							</tbody>
						</table>
						<div class="text-center">
							<button class="btn btn-primary mx-auto center-block"
								type="submit">Submit</button>
						</div>
					</form>
					<a href="backtowelcome" class="btn btn-primary mx-auto center-block"
						role="button">Back to Welcome Page</a>
				</div>
			</div>
			<p style="color: red">${errormessage}</p>
		</div>
		<div class="col-3"></div>
	</div>

</body>
</html>