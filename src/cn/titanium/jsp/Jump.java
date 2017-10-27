package cn.titanium.jsp;

/**
 * 跳转
 * @author Administrator
 *2017年10月26日下午11:46:51
 */
public class Jump {
	
	//和Servlet的跳转一样，JSP的跳转也分服务端跳转和客户端跳转
	//1 : 首先准备 jump.jsp
	
	//2 : 客户端跳转
	/*jsp的客户端跳转和Servlet中是一样的。	 
	response.sendRedirect("hello.jsp");*/
	
	// 3 : 服务端跳转
	/*与Servlet的服务端跳转一样，也可以使用
	request.getRequestDispatcher("hello.jsp").forward(request, response);
	或者使用动作，简化代码	 
	<jsp:forward page="hello.jsp"/>*/
}
