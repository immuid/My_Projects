<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="WEB-INF/registerUser.tld" prefix="id" %>

<%@ include file="register.jsp" %>

<style>
	h3{color: red;}
</style>

<h3>
<id:registerUser 
uid="<%=request.getParameter(\"uid\")%>" 
uname="<%=request.getParameter(\"uname\")%>"
upass="<%=request.getParameter(\"upass\")%>"
/>
</h3>    