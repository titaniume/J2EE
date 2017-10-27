package cn.titanium.jsp;

/**
 * 包含
 * @author Administrator
 *2017年10月26日下午11:34:57
 */
public class Include {
	
	/*每个网页的最下方都有 版权声明等信息。 如果不使用包含，那么每个网页都需要单独写，如果版权声明要修改，则需要很大的工作量。 

	使用include的办法，只需要准备一个footer.jsp，然后在其他页面包含footer.jsp即可。 

	修改的时候，只需要修改footer.jsp所有的页面就都修改了，维护成本降低了很多。 

	include有两种方式指令include和动作include*/
	
	//1 : 首先准备一个footer.jsp
	//2 : 指令include
	/*通过指令
	 
	<%@include file="footer.jsp" %> 在hello.jsp中包含该页面*/
	
	//3 : 动作include
	/*通过动作 
	<jsp:include page="footer.jsp" />
	在hello.jsp中包含该页面*/
	
	//4 : 指令include和动作include的区别
	/*通过之前的学习知道，JSP最后会被转译成Servlet
	如果是指令include 	 
	<%@include file="footer.jsp" %>	 
	footer.jsp的内容会被插入到 hello.jsp 转译 成的hello_jsp.java中，最后只会生成一个hello_jsp.java文件
	如果是动作include 	 
	<jsp:include page="footer.jsp" />	 
	footer.jsp的内容不会被插入到 hello.jsp 转译 成的hello_jsp.java中，还会有一个footer_jsp.java独立存在。
	hello_jsp.java 会在服务端访问footer_.jsp.java,然后把返回的结果，嵌入到响应中。*/
	
	//5 : 传参
	/*因为指令<%@include 会导致两个jsp合并成为同一个java文件，所以就不存在传参的问题，在发出hello.jsp 里定义的变量，直接可以在footer.jsp中访问。

	而动作<jsp:include />其实是对footer.jsp进行了一次独立的访问，那么就有传参的需要。

	如本例：
	1. 在hello.jsp中使用动作<jsp:include，并通过<jsp:param 带上参数
	 
	<jsp:include page="footer.jsp">
		<jsp:param  name="year" value="2017" />
	</jsp:include>
	 
	2. 在footer.jsp中，使用request.getParameter("year")取出year*/
}
