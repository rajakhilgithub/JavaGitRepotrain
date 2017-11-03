<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error{
color:red;
}
.messagestyle{
font-style: italic;
color: red;
}
.head1{
background-color: #110235;
font-style:bold;
color: white;
text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<form:form method="post" action="validatelogin" commandName="loginCommand">
<table align="center">
<tr><td colspan="2" class="head1">LOGIN</td></tr>
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
<tr><td colspan="2" ><input type="submit" value="login" style="align=right;"></td></tr>
</table>

</form:form>
 <table align="center" class="messagestyle">
                <tr>
                    <td >${message}</td>
                </tr>
            </table>
</body>
</html>