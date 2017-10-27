package cn.titanium.jsp;

/**
 * Cookie
 * @author Administrator
 *2017年10月26日下午11:54:30
 */
public class Cookie {
	
	//1 : cookie 在平时生活中的运用
	/*有的网站，登陆的时候，会出现一个选项，问你是否要一周内或者一个月内保持登陆状态。
	如果你选了，那么一周之内，都不需要再输入账号密码。
	这个功能，就是靠cookie来实现的*/
	
	//2 : 什么是cookie
	/*Cookie是一种浏览器和服务器交互数据的方式。

	Cookie是由服务器端创建，但是不会保存在服务器。

	创建好之后，发送给浏览器。浏览器保存在用户本地。

	下一次访问网站的时候，就会把该Cookie发送给服务器。*/
	
	//3 : setCookie.jsp	
	/*在webapp目录下创建一个文件 setCookie.jsp
	 
	Cookie c = new Cookie("name", "Gareen");	 
	创建了一个cookie,名字是"name" 值是"Gareen"
	
	c.setMaxAge(24 * 60 * 60);
	表示这个cookie可以保留一天，如果是0，表示浏览器一关闭就销毁
	
	c.setPath("127.0.0.1");
	Path表示服务器的主机名，只有浏览器通过这个主机名访问服务器的时候，才会提交这个cookie到服务端
	
	response.addCookie(c);
	通过response把这个cookie保存在浏览器端*/
	
	//4 : getCookie.jsp
	/*在webapp目录下创建文件getCookie.jsp
	然后访问网页:
	 
	http://127.0.0.1/getCookie.jsp
	 
	Cookie[] cookies  = request.getCookies();
	 
	表示获取所有浏览器传递过来的cookie
	 
	if (null != cookies )
	 

	如果浏览器端没有任何cookie，得到的Cookie数组是null
	 
	for (int d = 0; d <= cookies.length - 1; d++) {
	   out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
	}
	 
	遍历所有的cookie

	可以看到name:Gareen，这个在setCookie.jsp中设置的cookie

	注； JSESSIONID 这个不是我们自己设置的cookie，这是tomcat设置的cookie，会在下一章session的学习中用到
	通过HTTP调试工具也可以看到浏览器在请求信息里提交了这个Cookie。*/
}
