<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
<form:form method="post" action="validate" commandName="command">
<table>
<tr>
<th>Username:</th>
<td><form:input path="username"/>
<form:errors path="username" cssClass="error"></form:errors>
</td>
</tr>
<tr>
<th>Password:</th>
<td><form:password path="pwd"/>
<form:errors path="pwd" cssClass="error"></form:errors>
</td>
</tr>
</table>
<input type="submit" value="login">
</form:form>
 <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
</body>
</html>