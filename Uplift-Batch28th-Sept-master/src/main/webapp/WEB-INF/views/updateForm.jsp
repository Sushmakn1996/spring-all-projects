<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp"%>
<%
String empId = (String) request.getAttribute("empId");
String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=errMsg%></h1>
	<%
	}
	%>
<body>
	<br>
	<br>
	<form action="./update" method="post">
	<table>
	<tr>
		<td><label>Employee Id:</label></td>
		<td><input type="text" value="<%=empId%>" name="empId" disabled="disabled"></td>
	</tr>
	<tr>
		<td><label>Enter the employee name:</label> </td>
		<td><input type="text" name="empName"></td>
	</tr>
	<tr>
		<td><label>Enter the email address:</label></td>
		<td><input type="email" name="emailId"></td>
	</tr>
	<tr>
		<td><label>Enter the password:</label></td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td><input type="submit" value="Update"></td>
	</tr>
		</table>
	</form>
</body>
</html>