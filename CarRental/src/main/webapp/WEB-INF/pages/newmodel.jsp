
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
       <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.error{
color: red;
}
.messagestyle{
font-style: italic;
color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add New Vehicle</title>
</head>
<body>
<div align="center"><jsp:include page="home.jsp"></jsp:include></div>
<br><br>
<div align="center">
<form:form method="POST" commandName="modelnew" action="validatevehicle.htm">
<table>
<div>
<tr><th colspan="2" align="center">Add New Vehicle</th></tr>
<tr><td colspan="2">
</div>
<c:choose>
	<c:when test="${not empty successmessage }">
		
            <tr>
                <td class="messagestyle">${successmessage}</td>
            </tr>
        
	</c:when>
		<c:otherwise>
<div>
<form:select path="brandName">
<form:option value="" label="---Select Brand Name---"></form:option>
<c:forEach var="brand" items="${namelist}">
<form:option value="${brand.getName()}" label="${brand.getName()}"/>
</c:forEach>
</form:select>
<form:errors path="brandName" cssClass="error"></form:errors>
</td></tr>
<tr><td colspan="2"><form:input path="modelName" placeholder="Model Name"/>
<form:errors path="modelName" cssClass="error"></form:errors></td></tr>
<tr><td colspan="2"><form:label path="stock">Stock</form:label>
<tr><td colspan="2"><form:input path="stock" placeholder="Stock"/>
<form:errors path="stock" cssClass="error"></form:errors></td></tr>
<tr><td colspan="2"><form:label path="dailyRent">Daily Rent</form:label>
<tr><td colspan="2"><form:input path="dailyRent" placeholder="Daily Rent"/>
<form:errors path="dailyRent" cssClass="error"></form:errors></td></tr>
</div>
<div>
<tr><td colspan="2" align="right"><input type="submit" value="Add">
</td></tr>
</div>
</table>
</c:otherwise>
</c:choose>
</form:form>

</div>

</body>
</html>