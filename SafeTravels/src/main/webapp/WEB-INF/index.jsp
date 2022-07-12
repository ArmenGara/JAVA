<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Safe Travels</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>Expense</td>
				<td>Vendor</td>
				<td>Amount</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${expenses}" var="e">
					<tr>
						<td><a href="/expenses/${e.getId() }">${e.getName() }</a></td>
						<td>${e.getVendor() }</td>
						<td>$${e.getAmount() }</td>
						<td>
						<a href="/expenses/${e.getId() }/edit">Edit</a>
							<form action="/expenses/${e.getId() }" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Delete">
							</form>
						</td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
		<div>
			<form:form action="/" method="post" modelAttribute="expenses">
				<p>
					<form:errors path="name" />
				</p>
				<p>
					<form:label path="name">Expense Name:</form:label>
					<form:input path="name"/>
				</p>

				<p>
					<form:errors path="vendor"/>
				</p>
				<p>
					<form:label path="vendor">Vendor:</form:label>
					<form:textarea path="vendor"/>
				</p>

				<p>
					<form:errors path="amount"/>
				</p>
				<p>
					<form:label path="amount">Amount:</form:label>
					<form:input path="amount"/>
				</p>

				<p>
					<form:errors path="description" />
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:textarea path="description"/>
				</p>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
</body>
</html>