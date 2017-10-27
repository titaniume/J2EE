package cn.titanium.jsp;

/**
 * 执行过程
 * @author Administrator
 *2017年10月26日下午11:18:47
 */
public class ExecutionProcess {
	
	//1 : 执行过程
	/*1. 把 hello.jsp转译为hello_jsp.java
	2. hello_jsp.java 位于
	d:\tomcat\work\Catalina\localhost\_\org\apache\jsp
	3. hello_jsp.java是一个servlet
	4. 把hello_jsp.java 编译为hello_jsp.class
	5. 执行hello_jsp，生成html
	6. 通过http协议把html 响应返回给浏览器*/
	
	// 2 : hello_jsp.java 为什么是Servlet
	/*在Servle章节中，我们说HelloServlet是一个Servlet，不是因为它的类名里有一个"Servlet"，而是因为它继承了 HttpServlet

	打开转译hello.jsp 后得到的hello_jsp.java，可以发现它继承了类
	(D:\tomcat\work\Catalina\localhost\_\org\apache\jsp\hello_jsp.java)
	 
	org.apache.jasper.runtime.HttpJspBase
	 

	而HttpJspBase 继承了HttpServlet

	所以我们说hello_.jsp.java 是一个Servlet*/
	
	//3 : for循环
	//结合for循环在jsp里输出html是常见的做法。 只是第一次这么写会稍显别扭


}	
