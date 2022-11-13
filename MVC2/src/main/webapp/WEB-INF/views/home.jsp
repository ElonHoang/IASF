<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h3>Hello Word</h3>
	<form:form action="submitForm" modelAttribute="author" method="POST">
		<label>Name :</label><form:input path="name" /><br>
		<form:errors path="name"/><br>
		<label>Email :</label><form:input path="email" /><br>
		<form:errors path="email"></form:errors><br>
		<label>Gender :</label><form:input path="gender" /><br>
		<form:errors path="gender"></form:errors><br>
		<form:button>Submit</form:button>
		<p>${message}</p>
	</form:form>
</body>
</html>