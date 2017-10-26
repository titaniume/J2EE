	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取一个对象</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<input type="button" value="通过Ajax获取Hero对象" id="sender"/>
	<div id="message"></div>
	<script>
		$("#sender").click(function(){
			var url ="GetOneServlet";
			$.post(
				url,
				function(data){
					var json = JSON.parse(data);
					var name = json.hero.name;
					var hp = json.hero.hp;
					$("#message").html("英雄名称:"+name+"<br/>英雄血量:"+hp);
				}
				
			);
		});
	</script>
</body>
</html>