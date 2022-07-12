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
<div class="container">
    <h1><c:out value="${watermelon.userName }" /></h1>
    <table class="table">
        <thead>
            <tr>
                <th>Book</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${watermelon.books}">
                <tr>
                    <td><c:out value="${book.text}" /></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>