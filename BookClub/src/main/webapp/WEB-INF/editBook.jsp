<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>
<body>
<div class="container">
    <h1>Edit</h1>
    <form:form method="POST" action="/books/${bookObj.id }/edit" modelAttribute="bookObj">
        <input type="hidden" value="PUT" name="_method" />
        <form:input type="hidden" path="creator" value="${user_id}"/>
        
        <form:input path="text" />
        <form:errors path="text" />
        <button>Update</button>
    </form:form>
</div>
</body>
</html>