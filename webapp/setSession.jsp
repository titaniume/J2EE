<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设置session</title>
</head>
<body>
	<%
		session.setAttribute("name", "我是session！");
	%>
	
	<a href="<%=response.encodeUrl("getSession.jsp") %>">跳转到获取session的页面</a>
</body>
</html>