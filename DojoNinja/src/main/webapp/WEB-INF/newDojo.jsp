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
<title>NEW DOJO</title>
</head>
<body>
	
	<div class="container">
		<h1>Create A Dojo:</h1>
		<form:form action="/dojos/new" method="post" modelAttribute="dojoObj">
		    <h3>
		        <form:label path="name">Dojo Location:</form:label>
		        <form:input path="name"/>
		    </h3>
		    <h3><form:errors path="name"/></h3>
		    <button>Create</button>
		</form:form>    
		<a href="/ninjas/new" style="font-weight:bold;">CREATE A NINJA</a>
		<h1>Dojo Locations</h1>
		<c:forEach var="dojo" items="${dojos}">
		<div>
			<a href="/dojo/${dojo.id}"><c:out value="${dojo.name}"/></a>
		</div>
		</c:forEach>
	</div>

</body>
</html>
