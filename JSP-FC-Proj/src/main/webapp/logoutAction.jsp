<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="WEB-INF/resetFlag.tld" prefix="id" %>
<%@ include file="welcome.jsp" %>
    
<id:resetFlag 
uname="<%=request.getParameter(\"uname\")%>"
upass="<%=request.getParameter(\"upass\")%>"
/>