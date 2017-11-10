<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form:form method="POST" action="loginValidate" commandName="loginForm">
<table align="center">
<tr>
<th colspan="4">Login</th>
</tr>
<tr>
<td colspan="2">
<form:radiobutton path="type" value="seller" label="Seller"/>
</td>
<td colspan="2">
<form:radiobutton path="type" value="buyer" label="Buyer"/>
</td>
</tr>
<tr>
<td colspan="1">
<form:label path="username"></form:label>
</td>
<td colspan="3">
<form:input path="username"/>
</td>
</tr>
<tr>
<td colspan="1">
<form:label path="passWord"></form:label>
</td>
<td colspan="3">
<form:password path="passWord"/>
</td>
</tr>
<tr><td colspan="4" align="right"><a>New User</a></td></tr>
<tr><td colspan="4" align="center"><input type="submit" value="Login"></td></tr>
</table>
</form:form>
</body>
</html>