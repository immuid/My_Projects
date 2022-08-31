<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login home</title>
</head>
<body>
	<h1> Welcome to Login Page </h1>
	<form action="login.do" method="post">
	<input type="hidden" name="formid" value="login" >
	Username:<br>
	<input type="text" name="uname"><br>
	Password:<br>
	<input type="password" name="upass"><br><br>
	<input type="submit" value="Login" >
	</form>
	<br>
	
	<form action="register.do" method="post">
	<input type="hidden" name="formid" value="registerform" >
	
	 New User's Needs to Register...<br>
	<input type="submit" value="Register">
	
	</form>
</body>
</html>