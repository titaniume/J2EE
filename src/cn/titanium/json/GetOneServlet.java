package cn.titanium.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * 获取一个对象
 * @author Administrator
 *2017年10月26日下午4:21:47
 */
@WebServlet("/GetOneServlet")
public class GetOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 把Hero对象转换为JSONObject 对象，并放在上一个JSONObject对象上，key是"hero"
		Hero hero = new Hero();
		hero.setName("德玛西亚");
		hero.setHp(1000);
		
		JSONObject json = new JSONObject();
		json.put("hero", JSONObject.fromObject(hero));
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(json);
	}

}
