<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<p>Hi there!</p>
	<p>Please enter your authorization code:</p>
	<form action="initiallogin" method="POST">
		<input type="text" name="authCode" /> 
		<input type="submit" value="Submit" />
	</form>
	
</body>
</html>