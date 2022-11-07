<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="navbar.jsp"%>
<%
String empId = (String) request.getAttribute("empId");
String empName = (String) request.getAttribute("empName");
String emailId = (String) request.getAttribute("emailId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./mydetails">
		<table>
			<tr>
				<td><label>Employee Id:</label></td>
				<td><input type="text" value="<%=empId%>" name="empId"></td>
			</tr>
			<tr>
				<td><label>Employee name:</label></td>
				<td><input type="text" value="<%=empName%>" name="empName"></td>
			</tr>
			<tr>
				<td><label>Employee email address:</label></td>
				<td><input type="email" value="<%=emailId%>" name="emailId"></td>
			</tr>
		</table>
	</form>
</body>
</html>