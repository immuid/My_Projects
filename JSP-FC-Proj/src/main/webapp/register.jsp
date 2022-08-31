<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1>Register your Account</h1>
		<form action="register.do" method="post">
		<input type="hidden" name="formid" value="register">
		 Uid:<br><input type="text" name="uid"><br><br>
		 User Name:<br><input type="text" name="uname"><br><br>
		 Password:<br><input type="password" name="upass"><br><br>		
		<input type="submit" value="Register"><br>
		</form>
		
		<form action="login.do" method="post">
		<input type="hidden" name="formid" value="loginform">
	    <h5>Already have an account? <input type="submit" value="Login"></h5>		
		</form>		
		
</body>
</html>