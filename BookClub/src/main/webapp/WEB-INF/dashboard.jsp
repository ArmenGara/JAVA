<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard Page</title>
</head>
<body>
	<div class="container">
    <h1>Welcome, <c:out value="${user.userName}" /></h1>
    <a href="/books/new">Ask a Book</a>
    <table class="table">
        <thead>
            <tr>
                <th>Book</th>
                <th>Creator</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${allBooks}">
                <tr>
                    <td><c:out value="${book.text}" /></td>
                    <td><c:out value="${book.creator.userName}" /></td>
                    <td>
                        <c:if test="${user_id == book.creator.id }">
                            <a href="/books/${book.id}/edit">Edit</a>
                            <form action="/books/${book.id}" method="POST">
                                <input type="hidden" name="_method" value="DELETE" />
                                <button>Delete</button>
                            </form>
                        </c:if>
                        <a href="/profile">Show</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>