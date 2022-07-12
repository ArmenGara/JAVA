<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<h1>Dashbaord Page</h1>
	<h1><c:out value="${city}"/></h1>
	<h1><c:out value="${person}"/></h1>
	<h1><c:out value="${animal}"/></h1>
	<h1><c:out value="${description}"/></h1>
</body>
</html>