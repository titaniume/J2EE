<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加英雄</title>
</head>
<body>	
	<form action="AddHeroServlet" method="post">
	     名字 ： <input type="text" name="name"> <br>
	  血量 ： <input type="text" name="hp"> <br>
	 伤害： <input type="text" name="damage"> <br>
	    <input type="submit" value="增加 ">
</form>
</body>
</html>