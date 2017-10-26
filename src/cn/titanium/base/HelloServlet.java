package cn.titanium.base;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
        System.out.println(".....init HelloServlet.....");
    }	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取头信息
		/*host: 主机地址
		user-agent: 浏览器基本资料
		accept: 表示浏览器接受的数据类型
		accept-language: 表示浏览器接受的语言
		accept-encoding: 表示浏览器接受的压缩方式，是压缩方式，并非编码
		connection: 是否保持连接
		cache-control: 缓存时限*/
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			 String header = headerNames.nextElement();
	         String value = request.getHeader(header);
	         System.out.printf("%s\t%s%n",header,value);
		}
		
		try {
			response.getWriter().println("<h1>Hello Servlet!</h1>");
			response.getWriter().println(new Date().toLocaleString());
			//"text/html" 是存在的，表示浏览器可以识别这种格式，如果换一个其他的格式， 比如 "text/lol" ，
			//浏览器不能识别，那么打开此servlet就会弹出一个下载的对话框。
			//response.setContentType("txt/h");
			
			//不仅发送到浏览器的内容会使用UTF-8编码，而且还通知浏览器使用UTF-8编码方式进行显示。所以总能正常显示中文
			response.setContentType("text/html,charset=UTF-8");
			/*仅仅是发送的浏览器的内容是UTF-8编码的，置于浏览器是用哪种编码方式显示不管。 
			所以当浏览器的显示编码方式不是UTF-8的时候，就会看到乱码，需要手动再进行一次设置。
			response.setCharacterEncoding("UTF-8");*/
			
			//301 302 客户端跳转
			//response.sendRedirect("fail.html"); ----> 302
			
			//301
			/*response.setStatus(301);
			response.setHeader("Location", "fail.html");*/
			
			//缓存可以加快页面加载降低服务端的负担，但是也可能看到过时的信息，可以通过如下手段通知浏览器不要使用缓存
			 response.setDateHeader("Expires", 0);
             response.setHeader("Cache-Controll", "no-cache");
             response.setHeader("pragma", "no-cache");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

}
