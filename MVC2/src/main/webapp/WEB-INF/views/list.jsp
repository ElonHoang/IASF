<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authors</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h2>Author List</h2>
	<c:if test="${authors == null || authors.size() == 0}">
		<h4>No Authors !</h4>
	</c:if>
	<c:if test="${authors != null}">
	<table>
		<thead>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Gender</th>
		</thead>
		<tbody>
			<c:forEach var="item" items="${authors}">
				<tr>
					<td>${item.getId()}</td>
					<td>${item.getName()}</td>
					<td>${item.getEmail()}</<td>
					<td>${item.getGender()}</td>
				</tr>
		</c:forEach>
		</tbody>
		</table>
	</c:if>
</body>
</html>