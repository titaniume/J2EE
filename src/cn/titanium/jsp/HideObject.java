package cn.titanium.jsp;

/**
 * 隐藏对象
 * @author Administrator
 *2017年10月27日上午10:00:35
 */
public class HideObject {
	
	//JSP的隐式对象指的是不需要显示定义，直接就可以使用的对象，比如request,response 

	/*JSP一共有9个隐式对象，分别是 
	request,response,out
	pageContext,session,application
	page,config,exception*/
	
	
	// 1 : request,response,out
	/*request 代表请求 请参考 request常见方法
	response 代表响应 请参考 response 用法
	out 代表 输出*/
	
	//2 : pageContext, session,application
	/*pageContext 代表当前页面作用域

	session 代表当会话作用域

	application 代表当全局作用域*/
	
	
	// 3 : page
	/*page 对象即表示当前对象
	JSP 会被编译为一个Servlet类 ，运行的时候是一个Servlet实例。 page即代表this*/
	
	// 4 : config
/*	config可以获取一些在web.xml中初始化的参数。
	在JSP中使用config比较复杂，需要如下几个步骤
	1. 在web.xml中进行配置
	2. 创建一个testconfig.jsp
	通过config.getInitParameter("database-ip") 获取参数
	3. 访问路径，获取web.xml中配置的参数
	 
	http://127.0.0.1/testconfig 
	 

	注1: 不能通过 http://127.0.0.1/testconfig.jsp 获取参数，只能通过/testconfig路径

	注2：这种用法不常见，不推荐使用*/
	
	// 5 : exception
	/*exception 对象只有当前页面的<%@page 指令设置为isErrorPage="true"的时候才可以使用。

	同时，在其他页面也需要设置 <%@page 指令 errorPage="" 来指定一个专门处理异常的页面。

	1. 准备一个try.jsp
	设置errorPage="catch.jsp"，表示有异常产生的话，就交给catch.jsp处理
	故意在里面造成数组越界异常

	2. 准备一个catch.jsp
	设置 isErrorPage="true"，表示当前页面可以使用exception对象*/

}
