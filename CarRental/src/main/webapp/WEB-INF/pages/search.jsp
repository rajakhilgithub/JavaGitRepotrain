<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
          <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/jquery-3.2.1.min.js"></script>
<title>Search</title>

<script>

function getModel(){
    var brandName=document.getElementById("brandName").value;
    if(brandName!=0){
    var model_options="";
    $.ajax({url: "getModelById?brandId="+brandName, success: function(result){
    	//model_options=model_options+"<option value=''>"+"----Select Model----"+"</option>";
    	for (i = 0; i < result.length; i++) { 
    		model_options=model_options+"<option value='"+ result[i].modelID +"'>"+ result[i].modelNo +"</option>";
		}  	  
    	console.log(model_options);
    	$("#model").html(model_options);
       }
    });
    }
    
}

</script>
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
div.hidden{
display: none;
}
div.view{

display: block;
}
</style>
</head>
<body onload="getModel()">
<div align="center">
<form:form method="POST" commandName="search" action="validateSearch.htm">
<table>
<tr><th colspan="2">Search Availablity</th></tr>
<tr><td colspan="2"><form:select path="brandId" name="brandName" id="brandName" onchange="getModel();">
<form:option value="0" label="...Select Brand..."/>
<c:forEach var="brand" items="${namelist}">
<form:option value="${brand.getBrandID()}" label="${brand.getName() }"/>
</c:forEach>
</form:select>
<form:errors path="brandId" cssClass="error"/>
</td></tr>
<tr><td colspan="2"><form:select id="model" path="modelId" >
<option value="0" label="...Select Model..."/>
</form:select>
<form:errors path="modelId" cssClass="error"/>
</td></tr>
<tr><td colspan="2"><form:label path="fDate">From</form:label></td></tr>
<tr><td colspan="2"><form:input type="date" path="fDate"  />
<form:errors path="fDate" cssClass="error"/>
</td></tr>
<tr><td colspan="2"><form:label path="tDate">To</form:label></td></tr>
<tr><td colspan="2"><form:input type="date" path="tDate" />
<form:errors path="tDate" cssClass="error"/>
</td></tr>
<tr><td colspan="2"><input type="submit" value="Search"/></td></tr>
<tr><td colspan="2"><div align="center">${availablityMessage }</div></td></tr>
</table>
</form:form>
</div>
<c:if test="${not empty checkMessage}">
<div  align="center">

<form:form  method="POST" action="validateBooking" commandName="bookingDto">
<table>
<tr><td><form:select path="customerId">
<form:option value="0" label="----Select Customer----"/>
<c:forEach var="customer" items="${cutomerList}">
<form:option value="${customer.getCustomerID()}" label="${customer.getCustomerName()}"></form:option>
</c:forEach>
</form:select>
<form:errors path="customerId" cssClass="error"/>
</td></tr>
<tr>
<td><form:hidden path="brandId" value="${bookingDto.getBrandId()}"/></td>
<td><form:hidden path="modelId" value="${bookingDto.getModelId()}"/></td>
<td><form:hidden path="tDate" value="${bookingDto.gettDate()}"/></td>
<td><form:hidden path="fDate" value="${bookingDto.getfDate()}"/></td>

</tr>
<tr><td>
<input type="submit" value="book">
</td></tr><tr><td colspan="2"></td></tr>
</table>
</form:form>
</div>
</c:if>
<table align="center" class="messagestyle">
                <tr>
                    <td >${successmessage}</td>
                </tr>
            </table>


</body>
</html>