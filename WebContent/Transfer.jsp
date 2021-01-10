<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/banking/Transfer">
<h3>Select AccountNumber and Enter The Amount</h3>
<table>
<tr><td>AccountNumber</td><td><input type="text" name="TACCNO"/></td></tr>
<tr><td>Amount</td><td><input type="text" name="TAMT"/></td></tr>
<tr><td><input type="submit" value="Transfer"/></td></tr>
 </table>
</form>
</body>
</html>