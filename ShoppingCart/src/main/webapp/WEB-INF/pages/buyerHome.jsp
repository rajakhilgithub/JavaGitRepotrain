<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BuyerHome</title>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

</head>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
function appendId(productId){
	location.href="${context}/buyProduct?productId="+productId;
};
</script>
<body>
	<table align="center" id="buyer">
		<tr>
			<td colspan="20" align="left">
				<button class="button buttonBlue">
					<a href="buyerHome">Home</a>
				</button>
				<button class="button buttonGrey">
					<a href="orderList">Oders</a>
				</button>
			</td>
			<td colspan="20" align="right">Hi ${buyerName }
				<button class="buttonMedium buttonRed">
					<a href="logout">Logout</a>
				</button>
			</td>
		</tr>
		<tr>
			<th colspan="10"><p>Product Name</p></th>
			<th colspan="10"><p>Price</p></th>
			<th colspan="10"><p>Sold By</p></th>
		</tr>
		<c:choose>
			<c:when test="${not empty productList }">
				<c:forEach var="product" items="${productList }">
					<tr>
						<td colspan="10"><p>${product.getProductName() }</p></td>
						<td colspan="10"><p>${product.getProductPrice() }</p></td>
						<td colspan="10"><p>${product.getSellerName() }</p></td>
						<td colspan="10" align="center"><button
								class="buttonMedium buttonBlue"
								onclick="appendId(${product.getProductIdentity()});">
								<a>Buy Now</a>
							</button></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="40" class="error" align="center"><p>No Items
							Available</p></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>