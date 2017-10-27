<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello Jsp</title>
</head>
<body>
	<h4> 你好  jsp！</h4>
	<br/>
	<%=new Date().toLocaleString() %>
	
	<!-- 
		    尖括号@page 是指令
		contentType="text/html; charset=UTF-8"  相当于response.setContentType("text/html;charset=UTF-8") 通知浏览器以UTF-8进行中文解码
		 pageEncoding="UTF-8 如果jsp文件中出现了中文，这些中文使用UTF-8进行编码
		 import="java.util.* 
		  导入其他类，如果导入多个类，彼此用,逗号隔开，像这样 import="java.util.*,java.sql.*"
		
		
	 -->
	 
	 <%="hello Jsp" %>
	 <%out.println("hello Jsp"); %>
	 
	 <%
	 	List<String> list = new ArrayList<String>();
	 	list.add("today");
	 	list.add("google");
	 	list.add("youtube");
	 	list.add("facebook");
	 	list.add("message");
	 %>
	 <table width="200px" align="center" border="1" cellspacing="0">
	 	<%for(String s :list){%>
	 		<tr>
	 			<td><%=s%></td>
	 		</tr>
	 	<% }%>
	 		
	 
	 </table>
	 
	 <!-- 指令include -->
	<%@include file="footer.jsp" %>
	<!--动作include  -->
	<jsp:include page="footer.jsp">
		<jsp:param value="2017" name="year"/>
	</jsp:include>
</body>
</html>