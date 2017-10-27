<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分页查询hero</title>
<script type="text/javascript"src="jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>hp</td>
			<td>damage</td>
			<td>修改</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${heros}" var="hero" varStatus="st">
			<tr>
				<td>${hero.id}</td>
				<td>${hero.name}</td>
				<td>${hero.hp}</td>
				<td>${hero.damage}</td>
				<td><a href="editHero?id=${hero.id}">edit</a></td>
           		 <td><a href="deleteHero?id=${hero.id}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<nav>
          <ul class="pager">
 
            <li><a href="?start=0">首  页</a></li>
            <li><a href="?start=${pre}">上一页</a></li>
            <li><a href="?start=${next}">下一页</a></li>
            <li><a href="?start=${last}">末  页</a></li>
          </ul>            
        </nav>
</body>
</html>