<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp"%>
<%
String empId = (String) request.getAttribute("empId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<form action="./delete" method="post">
		<input type="text" value="<%=empId %>" name="empId"
			disabled="disabled"> <input
			type="submit" value="Delete">
	</form>
</body>
</html>