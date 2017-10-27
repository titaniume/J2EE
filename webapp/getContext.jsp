<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取 pageContext</title>
</head>
<body>
	获取pageContext的 值:<%=pageContext.getAttribute("name") %><br/>
	获取requestContext的值:<%=request.getAttribute("age") %><br/>
	客户端跳转获取到的值是：<%=request.getAttribute("address")%>
	获取session的值:<%=session.getAttribute("session") %>
</body>
</html>