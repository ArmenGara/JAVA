<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Fruit Store</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
		</tr>
		
		<c:forEach items="${fruitsArray}" var="item">   
			<tr>
	          <td>${item.getName() } }</td>
	          <td>${item.getPrice() } }</td>
	        </tr>
		</c:forEach>
		
	</table>
</body>
</html>