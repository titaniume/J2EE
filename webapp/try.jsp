<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="catch.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产生一个异常</title>
</head>
<body>
	<!-- 有异常就跳转到: errorPage="catch.jsp -->
	
	<%
		int [] a = new int [3];
	  	 a [4] = 20;
	%>
</body>
</html>