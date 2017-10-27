<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转</title>
</head>
<body>
	<!-- 客户端跳转  -->
	<%-- 
		<%
			response.sendRedirect("hello.jsp");
		%> 
	--%>
	
	<!-- 服务端跳转  -->
	<%-- 
		<jsp:forward page="hello.jsp"></jsp:forward> 
	--%>
	<%
		request.getRequestDispatcher("hello.jsp").forward(request, response);
	%>
</body>
</html>