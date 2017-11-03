<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
          <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
.error{
color: red;
}
.success{
color:green;
}
.messagestyle{
font-style: italic;
color: red;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Now</title>
</head>
<body>
<div align="center">
<form:form method="POST" commandName="search" action="validateBooking">

<table>
<tr><th colspan="2">Book Now</th></tr>
<tr><td><form:select path="customerId">
<form:option value="0" label="----Select Customer----"/>
<c:forEach var="customer" items="${cutomerList}">
<form:option value="${customer.getCustomerID()}" label="${customer.getCustomerName()}"></form:option>
</c:forEach>
</form:select></td></tr>
<tr><td><p>Model:${model}</p></td></tr>
</table>
</form:form>
</div>
</body>
</html>