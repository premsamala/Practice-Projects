<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Details</title>
</head>
<body>
	<p>Please enter the card details:</p>
	<form:form action="processpayment" method="post"
		modelAttribute="creditcarddetails">
		<table>
			<tbody>

				<tr>
					<th>Card Number:</th>
					<td><form:input path="cardNumber" /></td>
				</tr>
				
				<tr>
					<th>Card Holder Name:</th>
					<td><form:input path="cardholderName" /></td>
				</tr>
				
				<tr>
					<th>CVV:</th>
					<td><form:input path="cvv" /></td>
				</tr>
				
				<tr>
					<th>Expiry Month:</th>
					<td><form:input path="expiryMonth" /></td>
				
					<th>Expiry Year:</th>
					<td><form:input path="expiryYear" /></td>
				</tr>
				
				<tr>
					<th>Total Bill:</th>
					<td> ${totalFare} </td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>

			</tbody>

		</table>
	</form:form>
	<p> ${paymenterror} </p>
	<a href="javascript:history.back()">Go Back</a>
</body>
</html>