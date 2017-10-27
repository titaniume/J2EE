<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cn.titanium.jsp.Hero"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL</title>
</head>
<body>
	<c:set var="name" value="${'gareen'}" scope="request" />
  
	通过标签获取name: <c:out value="${name}" /> <br>
	 
	通过 EL 获取name: ${name}
	<br/>
	<c:set var="name" value="${'gareen-pageContext'}" scope="page" />
	<c:set var="name" value="${'gareen-request'}" scope="request" />
	<c:set var="name" value="${'gareen-session'}" scope="session" />
	<c:set var="name" value="${'gareen-application'}" scope="application" />
	  
	4个作用域都有name,优先获取出来的是 ： ${name}
	
	<hr/>
	<%
		Hero hero = new Hero();
		hero.setName("共宫本武藏");
		hero.setHp(213);
		request.setAttribute("hero", hero);
	%>
	英雄名字:${hero.name}<br/>
	英雄血量:${hero.hp}
	
	  
<%
    List<String> heros = new ArrayList<String>();
    heros.add("塔姆");
    heros.add("艾克");
    heros.add("巴德");
    heros.add("雷克赛");
    heros.add("卡莉丝塔");
    request.setAttribute("heros",heros);
%>

<table width="200px" align="center" border="1" cellspacing="0">
	<tr>
		<td>编号</td>
		<td>英雄</td>
	</tr>
	<c:forEach items="${heros}" var="hero" varStatus="st">
		<tr>
			<td>${st.count}</td>
			<td>${hero}</td>
		</tr>
	</c:forEach>
</table>	
	<h1>${param.testname}</h1>
	
	<hr/>
	<%
		request.setAttribute("killNumber", "10");
	%>
	c:if 的用法，运行结果：
	<c:if test="${killNumber>=10}">
		超神
	</c:if>
	<c:if test="${killNumber<10}">
		还未超神
	</c:if>
	<br>
	c:choose 的用法，运行结果：
	<c:choose>
		<c:when test="${killNumber>=10 }">
			超神
		</c:when>
		<c:otherwise>
			还未超神啊
		</c:otherwise>
	</c:choose>
	<br/>
	EL表达式eq的用法，运行结果：
	${killNumber ge 10?"超神":"还没超神"}
</table>
</body>
</html>
