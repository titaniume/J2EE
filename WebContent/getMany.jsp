<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取多个对象</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<!-- 1. 通过ajax访问getManyServlet
	2. 把返回的数据，通过 $.parseJSON 转换为json数组
	3. 遍历数组，显示在div中 -->
	<input type="button" value="通过AJAX获取多个Hero对象" id="sender">   
	<div id="message"></div>
	<script>
		$("#sender").click(function(){
			var url ="GetManyServlet";
			$.post(
				url,
				function(data){
					var heros = $.parseJSON(data);	
					
					 for(i in heros){
                         var old = $("#message").html();
                         var hero = heros[i];
                         $("#message").html(old + "<br>"+hero.name+"   -----   "+hero.hp);  
                     }
				}
			);
		});
	</script>
</body>
</html>