<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order List</title>
</head>
<body>

	<table align="center" id="buyer">
		<tr>
			<td colspan="20" align="left">
				<button class="button buttonGrey">
					<a href="buyerHome">Home</a>
				</button>
				<button class="button buttonBlue">
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
			<th colspan="40" align="left">Order List</th>
		</tr>
		<tr>
			<th colspan="8">Order No</th>
			<th colspan="8">Product Name</th>
			<th colspan="8">Price</th>
			<th colspan="8">Sold By</th>
			<th colspan="8">Order Date</th>
		</tr>
		<tr>
			<c:forEach var="order" items="${orderList }">
				<td colspan="8"><p>${order.getOrderNumber() }</p></td>
				<td colspan="8"><p>${order.getProductName() }</p></td>
				<td colspan="8"><p>${order.getProductPrice() }</p></td>
				<td colspan="8"><p>${order.getSellerName() }</p></td>
				<td colspan="8"><p>${order.getOrderDate() }</p></td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>