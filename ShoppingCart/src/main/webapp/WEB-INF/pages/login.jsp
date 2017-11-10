<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

</head>

<body>
	<form:form method="POST" action="loginValidate" commandName="loginForm">
		<table align="center" id="login">
			<tr>
				<td align="center" colspan="4" class="error"><p>${successMessage}</p></td>
			</tr>
			<tr>
				<th colspan="4" align="center">LOGIN</th>
			</tr>
			<tr>
				<td colspan="2"><form:radiobutton path="type" value="seller"
						label="Seller" /></td>
				<td colspan="2" align="right"><form:radiobutton path="type"
						value="buyer" label="Buyer" /></td>
				<td colspan="2" align="right"><form:errors path="type"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><form:label path="username">Email:</form:label>
				</td>
				<td colspan="2"><form:input path="username" /></td>
				<td colspan="2"><form:errors path="username" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2"><form:label path="passWord">Password:</form:label>
				</td>
				<td colspan="2"><form:password path="passWord" /></td>
				<td colspan="2" align="right"><form:errors path="passWord"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><p class="error">${errorMessage}</p></td>
			</tr>
			<tr>
				<td colspan="4" align="right"><a href="newRegistration">New
						User</a></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit"
					value="Login" class="button buttonRed"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>