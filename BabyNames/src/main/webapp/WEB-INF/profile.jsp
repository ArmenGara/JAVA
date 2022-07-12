<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
<a href="/babys">Home Page</a>
	<h1>Created By  :<c:out value="${watermelon.userName }" /></h1>
	<h1>Baby Name  :<c:out value="${babyObj.name }" /></h1>
	<h1>Baby Gender  :<c:out value="${babyObj.gender }" /></h1>
	<h1>Baby Origin  :<c:out value="${babyObj.orgin }" /></h1>
	<h1>Baby Meaning  :<c:out value="${babyObj.meaning }" /></h1>
	
	<a href="/babys/${babyObj.id}/edit">Edit</a>
	
	<a href="/babys">Cancel</a>
</html>