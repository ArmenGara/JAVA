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
<title>View DOJO</title>
</head>
<body>
<div>
		<h1>${ dojo.getName() } Location Ninjas</h1>
		<table>
			<thead>
				<tr>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Age</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${dojo.ninjas }" var="n">
					<tr>
						<td>${n.getFirstName() }</td>
						<td>${n.getLastName() }</td>
						<td>${n.getAge() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>