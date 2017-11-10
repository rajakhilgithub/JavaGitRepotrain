<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product</title>
</head>

<body>
	<table align="center" id="seller">
		<tr>
			<td colspan="20"><button class="button buttonGrey">
					<a href="sellerHome">Home</a>
				</button></td>
			<td colspan="20" align="right">Hi ${sellerName}
				<button class="buttonMedium buttonRed">
					<a href="logout">Logout</a>
				</button>
			</td>
		</tr>
		<tr>
			<th colspan="18">ADD PRODUCT</th>
		</tr>
		<c:choose>
			<c:when test="${not empty successMessage }">
				<tr>
					<td colspan="18" align="center" class="error"><p>${successMessage }</p></td>
				</tr>
				
			</c:when>
			<c:otherwise>

				<form:form method="POST" action="addValidate"
					commandName="addProductForm">
					<form:hidden path="productIdentity" />
					<tr>
						<td colspan="6"><form:label path="productName">Product Name</form:label></td>
						<td colspan="12"><form:input path="productName"
								placeholder="Product Name" /> <form:errors path="productName"
								cssClass="error" /><p class="error">${productExistMessage }</p></td>
						
					</tr>
					<tr>
						<td colspan="6"><form:label path="productPrice">Product Price</form:label></td>
						<td colspan="12"><form:input path="productPrice"
								placeholder="Product Price" /> <form:errors path="productPrice"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td colspan="6"><form:label path="productDesc">Product Description</form:label></td>
						<td colspan="12"><form:textarea path="productDesc"
								placeholder="Product Description" /></td>
					</tr>
					<tr>
						<td colspan="18" align="center"><input type="submit" class="button buttonRed"></td>
					</tr>
				</form:form>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>