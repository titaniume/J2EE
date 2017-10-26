package cn.titanium.base;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 需要提供对应的doGet() 与 doPost()方法
 * @author Administrator
 *2017年10月25日下午9:19:18
 */
public class Service extends HttpServlet {
	
	//1：doGet() get方式
		/*	--from的默认提交方式
			--通过一个超链接访问地址
			--地址栏输入某个地址
			--ajax指定为get方式
		*/
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	  }
	 
	 
	 //2：doPost() post方式
	 	/*--在from显示设置method="post" 
	    --ajax 指定post方式*/
	 

		 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }
    
    
    //3:service()
    /*LoginServlet继承了HttpServlet,同时也继承了一个方法 
    
     service(HttpServletRequest , HttpServletResponse )
    
	    实际上，在执行doGet()或者doPost()之前，都会先执行service()
	
	    由service()方法进行判断，到底该调用doGet()还是doPost()
	
	    可以发现，service(), doGet(), doPost() 三种方式的参数列表都是一样的。
	
	    所以，有时候也会直接重写service()方法，在其中提供相应的服务，就不用区分到底是get还是post了。
	
	    比如把前面的登录的LoginServlet，改为提供service方法，也可以达到相同的效果*/
}	
