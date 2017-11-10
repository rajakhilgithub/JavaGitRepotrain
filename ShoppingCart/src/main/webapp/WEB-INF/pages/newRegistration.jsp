<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New Registration</title>

</head>
<body>

	<form:form method="POST" commandName="registration"
		action="validateRegistration">
		<table align="center" id="buyer">
			<tr>
				<th colspan="40">REGISTER</th>
			</tr>
			<tr>
				<td colspan="20"><form:radiobutton path="type" value="seller"
						label="Seller" /></td>
				<td colspan="20" align="right"><form:radiobutton path="type"
						value="buyer" label="Buyer" /></td>
				<td colspan="20"><form:errors path="type" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="20"><form:label path="firstName">FirstName</form:label></td>
				<td colspan="20"><form:input path="firstName" /></td>
				<td colspan="20"><form:errors path="firstName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="20"><form:label path="lastName">LastName</form:label></td>
				<td colspan="20"><form:input path="lastName" /></td>
				<td colspan="20"><form:errors path="lastName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="20"><form:label path="emailId">Email</form:label></td>
				<td colspan="20"><form:input path="emailId" /></td>
				<td colspan="20"><form:errors path="emailId" cssClass="error"></form:errors>
					<p class="error">${errorMessage}</p></td>
			</tr>
			<tr>
				<td colspan="20"><form:label path="passWord">Password</form:label></td>
				<td colspan="20"><form:password path="passWord" /></td>
				<td colspan="20"><form:errors path="passWord" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td colspan="40" align="center"><input type="submit"
					value="Register" class="button buttonBlue" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>