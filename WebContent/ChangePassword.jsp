<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:orange"><form action="/banking/ChangePassword">
<h3>Enter new password</h3>
<table>
<tr><td>NewPassword</td><td><input type="password" name="NPASS"/></td></tr>
<tr><td>ConfirmNewPassword</td><td><input type="password" name="CNPASS"/></td></tr>
<tr><td><input type="submit" value="Change"/></td></tr>
</table>
</form>
</body>
</html>