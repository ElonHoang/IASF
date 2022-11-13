<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h3>Books</h3>
	<c:if test="${book == null || book.size() == 0}">
		<h4>No Books !</h4>
	</c:if>
		<h4><a href="./addBook"/>Add</a></h4>
	<c:if test="${book != null }">
		<table>
			<thead>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Author Name</th>
			</thead>
			<tbody>
				<c:forEach var="item" items="${book}">
					<tr>
						<td>${item.getId()}</td>
						<td>${item.getName()}</td>
						<td>${item.getPrice()}</td>
						<td>${item.getQuantity()}</td>
						<td>${item.getAuthor().getName()}</td>
						<td><a href="updateBook/${item.getId()}">Edit</a></td>
						<td><a href="deleteBook/${item.getId()}">Delete</a></td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>