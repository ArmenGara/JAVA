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
	<h1>Send an Omikuji!</h1>
<form method="POST" action="/finished">
  <label for="fname">Enter the name of any city:</label><br>
  <input type="text" name="city"><br>
  <label for="lname">Enter the name of any real person:</label><br>
  <input type="text" name="person">
  <label for="lname">Enter any type of living thing:</label><br>
  <input type="text" name="animal">
  <label for="lname">Say something nice to someone:</label><br>
  <textarea rows = "5" cols = "50" name = "description"></textarea>
  <button>Login</button> 
</form>

</body>
</html>