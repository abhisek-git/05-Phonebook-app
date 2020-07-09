<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="vendor/jquery/dist/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script src="js/form-validation.js"></script>
</head>
<body>
	<h2>Save Contact</h2>
	<p>
		<font color='green'>${succMsg}</font>
	</p>
	<p>
		<font color='red'>${errMsg}</font>
	</p>
	<form:form action="saveContact" modelAttribute="contact" method="post">
		<table>
			<tr>
			    <form:hidden path="contactId"/>
				<td>Contact Name:</td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td>Contact Number:</td>
				<td><form:input path="contactNumber" /></td>
			</tr>
			<tr>
				<td>Contact Email:</td>
				<td><form:input path="contactEmail" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>
	<a href="viewContacts">View All Contacts</a>
</body>
</html>