<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<c:set var="context" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	function loadLogin() {
		location.href = "${context}/login";
	}
</script>
</head>
<body onload="loadLogin();">
</body>
</html>