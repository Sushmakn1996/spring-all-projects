<%@page import="com.te.empmanagementsystem.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<Employee> employees = (List<Employee>) request.getAttribute("allrecords");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>

		<h1>All Employee Details</h1>
		<br>

		<tr>
			<th>Employee Id:</th>
			<th>Employee Name:</th>
			<th>Employee Email Address:</th>
		</tr>

		<%
		for (Employee emp : employees) {
		%>
		<tr>
			<td><%=emp.getEmpId()%></td>
			<td><%=emp.getEmpName()%></td>
			<td><%=emp.getEmailId()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>