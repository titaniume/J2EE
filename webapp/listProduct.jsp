<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示商品</title>
</head>
<body>

	<c:if test="${!empty user }">
		<div align="center"> 当前用户:${user.name}</div>
	</c:if>

	<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>价格</td>
        <td>购买</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>            
            <form action="OrderItemAddServlet" method="post">            
       			数量<input type="text" value="1" name="num">
            <input type="hidden" name="pid" value="${product.id}">
            <input type="submit" value="购买">
            </form>              
        </tr>
    </c:forEach>
</table>
</body>
</html>