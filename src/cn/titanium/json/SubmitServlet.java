package cn.titanium.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 提交数据
 * @author Administrator
 *2017年10月26日下午3:50:42
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data =request.getParameter("data");
        
       System.out.println("服务端接收到的数据是：" +data);
 
       JSONObject json=JSONObject.fromObject(data);  
         
       System.out.println("转换为JSON对象之后是："+ json);
          
       Hero hero = (Hero)JSONObject.toBean(json,Hero.class);  
       System.out.println("转换为Hero对象之后是："+hero);
	}

}
