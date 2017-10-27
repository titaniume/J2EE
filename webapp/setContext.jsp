<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>设置pageContext 当前作用域</title>
</head>
<body>	
	<a href="getContext.jsp">试图跳转到其他页面获取</a><br/>
	<%
		pageContext.setAttribute("name", "亚瑟");
	%>
	<br/>
	当前页面PageContext作用域内容:<%=pageContext.getAttribute("name") %>
	<hr/>
	<%
		request.setAttribute("age", "12");
	%>
	request在本页获取的年龄是：<%=request.getAttribute("age") %>
	
	<!-- 做服务端跳转还是在一次会话，所以在getContext.jsp可以获取到值 -->
	<jsp:forward page="getContext.jsp"/>
	
	
	<!--客户端跳转，浏览器会发送新的一次访问。产生一个新的request所以getContext.jsp 是获取不到内容的  -->
	<%
		request.setAttribute("address", "上海");
		response.sendRedirect("getContext.jsp");
	%>
	

</body>
</html>