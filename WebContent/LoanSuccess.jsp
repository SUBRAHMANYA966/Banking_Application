<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:pink">
<h3>
<%
session=request.getSession();
out.println("Dear,"+" "+session.getAttribute("name")+" " + "YOUR LOAN APPLICATION UNDER PROCESS  information sent to :"+"  "+session.getAttribute("email"));

%>
</h3>
</body>
</html>