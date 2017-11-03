<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<title>Insert New Brand</title>
</head>
<body>
<div align="center">
<table>
<tr><th colspan="2" align="center">Add New Brand</th></tr>
<form:form action="validatebrand.htm" method="POST" commandName="brandnew">
<tr><td colspan="2"><form:input path="name" placeholder="Brand Name"/>
<form:errors cssClass="error" path="name"></form:errors>
</td></tr>
<tr><td colspan="2"><form:input path="countryOrigin" placeholder="Country of Origin"/>
<form:errors cssClass="error" path="countryOrigin"></form:errors>
</td></tr>
<tr><td colspan="2" align="right"><input type="submit" value="Add"></td></tr>
</form:form>
</table>
</div>
 <table align="center" class="messagestyle">
                <tr>
                    <td >${successmessage}</td>
                </tr>
            </table>
</body>
</html>