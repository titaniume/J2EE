package cn.titanium.jsp;

/**
 * 作用域
 * @author Administrator
 *2017年10月27日上午9:22:22
 */
public class Scope {
	/*JSP的四个作用域，分别是：
		pageContext:当前页面
		requestContext:一次会话
		sessionContext:当前会话
		applicationContext:全局，所有用户共享*/
	
	
	//1 : pageContext
	/*准备setContext.jsp和getContext.jsp，分别表示向作用域设置数据，和从作用域获取数据。

	pageContext表示当前页面作用域

	通过pageContext.setAttribute(key,value)的数据，只能在当前页面访问，在其他页面就不能访问了。*/
	
	//2 : requestContext
	/*requestContext 表示一次请求。随着本次请求结束，其中的数据也就被回收。

	常用写法是
	 
	request.setAttribute("name","gareen"); 
	request.getAttribute("name")
	
	但是也可以用pageContext来做，写成
	 
	pageContext.setAttribute("name","gareen",pageContext.REQUEST_SCOPE);
	pageContext.getAttribute("name",pageContext.REQUEST_SCOPE)
	
	不过不常用*/
	
	
	// 3 : requestContext与服务端跳转
	/*requestContext指的是一次请求
	如果发生了服务端跳转，从setContext.jsp跳转到getContext.jsp，这其实，还是一次请求。 所以在getContext.jsp中，可以取到在requestContext中设置的值

	这也是一种页面间传递数据的方式*/
	
	//requestContext与客户端跳转
	/*客户端跳转，浏览器会发生一次新的访问，新的访问会产生一个新的request对象。

	所以页面间客户端跳转的情况下，是无法通过request传递数据的。*/
	
	//5 : sessionContext
	/*sessionContext 指的是会话，从一个用户打开网站的那一刻起，无论访问了多少网页，链接都属于同一个会话，直到浏览器关闭。 

	所以页面间传递数据，也是可以通过session传递的。

	但是，不同用户对应的session是不一样的，所以session无法在不同的用户之间共享数据。

	与requestContext类似的，也可以用如下方式来做
	pageContext.setAttribute("name","gareen",pageContext.SESSION_SCOPE);
	pageContext.getAttribute("name",pageContext.SESSION_SCOPE)*/
	
	
	// 6 : applicationContext
	/*applicationContext 指的是全局，所有用户共享同一个数据

	在JSP中使用application对象， application对象是ServletContext接口的实例
	也可以通过 request.getServletContext()来获取。
	所以 application == request.getServletContext() 会返回true
	application映射的就是web应用本身。

	与requestContext类似的，也可以用如下方式来做
	 
	pageContext.setAttribute("name","gareen",pageContext.APPLICATION_SCOPE);
	pageContext.getAttribute("name",pageContext.APPLICATION_SCOPE)*/
}	
