<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
a {
	width: 400px;
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	text-decoration: none;
	padding: 10px;
	border-radius: 10px;
	background-color: #4d78bf;
	color: whitesmoke;
	margin-left: 460px;
}

a:hover {
	background-color: #5dbea3;
	color: black;
	box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24), 0 17px 50px 0
		rgba(0, 0, 0, 0.19);
}

legend {
	border: 1px solid black;
	padding: 10px;
	border-radius: 0px 20px 0px 20px;
	background-color: #e0ed80;
	color: #2a2b20;
	margin: auto;
}

fieldset {
	margin: auto;
	width: 400px;
}
</style>
</head>
<body>

	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: green"><%=msg%></h1>
	<%
	}
	%>

	<%
	if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red"><%=errMsg%></h1>
	<%
	}
	%>
	<fieldset>
		<legend>Employee Registration Form</legend>
		<form action="./register" method="post">
			<table>
				<tr>
					<td><label>Enter Employee ID:</label></td>
					<td><input type="text" name="empId"></td>
				</tr>
				<tr>
					<td><label>Enter Employee Name:</label></td>
					<td><input type="text" name="empName"></td>
				</tr>
				<tr>
					<td><label>Enter email address :</label></td>
					<td><input type="email" name="emailId"></td>
				</tr>
				<tr>
					<td><label>Enter your password:</label></td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="Register"> 
			<input type="reset"  value="Reset">
		</form>
	</fieldset>
	<br>
	<a href="./login">Already have an account? Login In!</a>

</body>
</html>