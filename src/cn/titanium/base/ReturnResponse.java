package cn.titanium.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 根据浏览器提交的账号密码返回登录成功或者失败 
     这一步本来应该通过访问数据库来实现，这里简化一下，直接在内存中进行校验 
      如果账号是 admin,密码是123, 就返回登录成功，否则返回登录失败
 */
@WebServlet("/ReturnResponse")
public class ReturnResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//浏览器请求过来的数据中文乱码
		//request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		//request常见方法
		/*request.getRequestURL(): 浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有)" + 
		request.getRequestURI(): 浏览器发出请求的资源名部分，去掉了协议和主机名" + 
		request.getQueryString(): 请求行中的参数部分，只能显示以get方式发出的参数，post方式的看不到
		request.getRemoteAddr(): 浏览器所处于的客户机的IP地址
		request.getRemoteHost(): 浏览器所处于的客户机的主机名
		request.getRemotePort(): 浏览器所处于的客户机使用的网络端口
		request.getLocalAddr(): 服务器的IP地址
		request.getLocalName(): 服务器的主机名
		request.getMethod(): 得到客户机请求方式一般是GET或者POST*/
	
		System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
        System.out.println("请求行中的参数部分: " + request.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
        System.out.println("服务器的IP地址: " + request.getLocalAddr());
        System.out.println("服务器的主机名: " + request.getLocalName());
        System.out.println("得到客户机请求方式: " + request.getMethod());
        
        
        //request 获取参数
       /* request.getParameter(): 是常见的方法，用于获取单值的参数
        request.getParameterValues(): 用于获取具有多值得参数，比如注册的时候提交的爱好，可以使多选的。
        request.getParameterMap(): 用于遍历所有的参数，并返回Map类型。*/
	 
		
		 String html = null;
		/*if("admin".equals(name)){
			html = "<div style ='color:green'>登录成功</div>";
		}else{
			html = "<div style ='color:red'>登录失败</div>";
		}*/
		
		 
			
		 
		if("admin".equals(name)){
			//成功
			request.getRequestDispatcher("success.html").forward(request, response);
		}else{
			response.sendRedirect("fili.html");
		}
		
		//响应到浏览器乱码
		response.setContentType("text/html;charset=UTF-8");
		//PrintWriter pw = response.getWriter();
		//pw.write(html);
	}

}
