<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<div>
	<h1> Welcome <c:out value="${user.userName}"/> Here are some name Suggestions</h1>
	<a href="/">Log Out</a>
	<table style="width:100%">
		<thead>
		  <tr>
		    <th>Names</th>
		    <th>Gender</th>
		    <th>Origin</th>
		  </tr>
		 </thead>
		 <tbody>
		 	<c:forEach var="baby" items="${allBabys}">
			<tr>
			 <td><a href="/profile/${baby.id}"><c:out value="${baby.name}" /></a></td>
			 <td><c:out value="${baby.gender}" /></td>
			 <td><c:out value="${baby.orgin}" /></td>
			</c:forEach>
		</tbody>
		
	</table>
	<a href="/babys/new">New Name</a>
	</div>
</body>
</html>