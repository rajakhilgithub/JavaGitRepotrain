<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Form</title>
</head>
<body>
<form:form method="post" action="save">
<table>
<tr>
<td>Employee no</td>
<td><form:input path="empno"/>
</tr>
<tr>
<td>Employee name</td>
<td><form:input path="name"/>
</tr>
<tr>
<td>Designation</td>
<td><form:input path="desig"/>
</tr>
<tr>
<td>Salary</td>
<td><form:input path="salary"/>
</tr>
<tr><td></td><td><input type="submit" value="save"></td></tr>
</table>
</form:form>
</body>
</html>