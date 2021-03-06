<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>ExpenseTracker</h1>

	<a href="${contextRoot}/expense">Add Expense</a>

	<c:forEach var="expense" items="${expenses}">

		<div>
			<h3>${expense.expenseName}</h3>
			<p>$${expense.amount}</p>
			<a href="${contextRoot}/expense/${expense.id}">Edit</a> <a
				href="${contextRoot}/expense/delete/${expense.id}">Delete</a>
		</div>

	</c:forEach>

</body>
</html>