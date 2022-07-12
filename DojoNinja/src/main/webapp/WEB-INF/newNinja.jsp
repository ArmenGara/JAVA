<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New NINJA</title>
</head>
<body>
	<div >
		<h1>New NINJA</h1>
		<form:form action="/ninja/new" method="post" modelAttribute="ninjaObj">
			<p>
				<form:errors path="dojo"/>
			</p>
			<p>
				<form:select path="dojo">
					<c:forEach items="${dojos}" var="d">
						<option value="${d.getId() }">${d.getName()}</option>
					</c:forEach>
				</form:select>
			</p>
			
			<p>
				<form:errors path="firstName" />
			</p>
			<p>
				<form:label path="firstName">First Name:</form:label>
				<form:input path="firstName" />
			</p>

			<p>
				<form:errors path="lastName"/>
			</p>
			<p>
				<form:label path="lastName">Last Name:</form:label>
				<form:input path="lastName" />
			</p>

			<p>
				<form:errors path="age" />
			</p>
			<p>
				<form:label path="age">Age:</form:label>
				<form:input path="age" />
			</p>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>