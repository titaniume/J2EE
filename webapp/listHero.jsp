<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示</title>
</head>
<body>
	<table align="center" border="1" cellspacing="0">
		<tr>
			<td>Id</td>
			<td>name</td>
			<td>hp</td>
			<td>damage</td>
			<td>delete</td>
		</tr>
		<c:forEach items="${heros}" var="hero" varStatus="st">
			<tr>
				<td>${hero.id}</td>
				<td>${hero.name}</td>
				<td>${hero.hp}</td>
				<td>${hero.damage}</td>
				<td><a href="#">修改</a></a></td>
				<td><a href="#">删除</a></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>