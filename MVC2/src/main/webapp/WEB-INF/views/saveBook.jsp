<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
		<h4><a href="/MVC2/book/list">Back List</a></h4>

	<form:form action="submitForm" modelAttribute="book" method="POST">
		<c:if test="${book.getId() > 0}">
			<form:hidden path="id" />
		</c:if>
		<label>Name</label>
		<br>
		<form:input path="name" />
		<br>
		<form:errors path="name" />
		<br>

		<label>Price</label>
		<br>
		<form:input path="price" />
		<br>
		<form:errors path="price" />
		<br>

		<label>Quantity</label>
		<br>
		<form:input path="quantity" />
		<br>
		<form:errors path="quantity" />
		<br>

		<label>Author</label>
		<br>
		<form:select path="author.id">
			<c:forEach var="item" items="${authors}">
				<form:option value="${item.getId()}">${item.getName()}</form:option>
			</c:forEach>
		</form:select>

		<form:button>Save</form:button>
		<h3>${message }</h3>
	</form:form>
</body>
</html>