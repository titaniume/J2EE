<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax提交</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
	<form action="" method="post">
		名字:<input type="text" id="name"><br/>
		血量:<input type="text" id="hp"><br/>
		<input type="button" id="sender" value="提交">
	</form>
	<div id="message"></div>
	<script>
		$('#sender').click(function(){
			var name =document.getElementById('name').value;
			var hp =document.getElementById('hp').value;
			var hero = {"name":name,"hp":hp};
			alert(''+name+''+hp);
			var url="SubmitServlet";
			$.post(
	                url, 
	                {"data":JSON.stringify(hero)},
	                function(data) {  
	                     alert("提交成功，请在Tomcat控制台查看服务端接收到的数据");
	         });   
		});
	</script>
</body>
</html>