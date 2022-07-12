<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Baby</title>
</head>
<body>
	<h1>New Baby Name</h1>
	 <form:form method="POST" action="/babys/new" modelAttribute="babyObj">
	 	<form:input type="hidden" path="creator" value="${user_id}"/>
	 	 <p>Name</p>
		 <form:input path="name" />
	     <form:errors path="name" />
	     <p>Gender</p>
	     <form:select path="gender">
	     	<form:option value="male" label="male"/>
	     	<form:option value="female" label="female"/>
		 </form:select>
		 <form:errors path="gender" />
	     <p>Origin</p>
	     <form:input path="orgin" />
		 <p>Meaning</p>
		 <form:input path="meaning" />
	     <form:errors path="meaning" />
		 <button>Create Name</button>
	</form:form>
	<a href="/babys">Cancel</a>
</body>
</html>