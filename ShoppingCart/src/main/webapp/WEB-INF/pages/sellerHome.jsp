<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seller Home</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
function appendId(productId){
	location.href="${context}/editProduct?productId="+productId;
};
function appendForDelete(productId){
	if(confirm("Do you want to Delete this product"))
	{
		location.href="${context}/deleteProduct?productId="+productId;

	}
};
</script>

</head>
<body>

	<table align="center" id="seller">
		<tr>
			<td colspan="20"><button class="button buttonBlue">
					<a href="sellerHome">Home</a>
				</button></td>
			<td colspan="20" align="right">Hi ${sellerName}
				<button class="buttonMedium buttonRed">
					<a href="logout">Logout</a>
				</button>
			</td>
		</tr>
		<tr>
			<th colspan="20" align="left">Product List</th>
			<td colspan="20" align="right">
				<button class="buttonMedium buttonViolet">
					<a href="addProduct">Add Product</a>
				</button>
			</td>
		</tr>
		<tr>
			<th colspan="10">Product Name</th>
			<th colspan="10">Product List</th>
		</tr>
		<c:choose>
			<c:when test="${not empty productList }">
				<c:forEach var="product" items="${productList }">
					<tr>
						<td colspan="10"><p>${product.getProductName() }</p></td>
						<td colspan="10"><p>${product.getProductPrice() }</p></td>
						<td colspan="10" align="center"><button
								onclick="appendId(${product.getProductIdentity()});" class="buttonMedium buttonBlue">
								<a>Edit</a>
							</button></td>
						<td colspan="10" align="center"><button
								onclick="appendForDelete(${product.getProductIdentity()});" class="buttonMedium buttonRed">
								<a>Delete</a>
							</button></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="40" class="error" align="center">${deleteMessage}</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="40" class="error" align="center"><p>No Items
							for this seller</p></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>