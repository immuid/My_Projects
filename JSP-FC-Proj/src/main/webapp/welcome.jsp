<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hr>
		<form action="logout.do" method="post">
		<input type="hidden" name="formid" value="logout">
		<input type="hidden" name="uname" value="<%=request.getAttribute("Auname") %>">
		<input type="hidden" name="upass" value="<%=request.getAttribute("Aupass") %>">	
		<input style="margin-right:1150px" type="submit" value="Logout">
		</form>
<hr>		
		<br><br><br> <h1>Welcome to the  User page</h1>
		
		
</body>
</html>