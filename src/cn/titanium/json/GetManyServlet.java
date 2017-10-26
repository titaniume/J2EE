package cn.titanium.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;
/**
 * 获取多个对象
 * @author Administrator
 *2017年10月26日下午4:30:59
 */
@WebServlet("/GetManyServlet")
public class GetManyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetManyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Hero> heros = new ArrayList<Hero>();
		for(int i =0;i< 10;i++){
			Hero hero = new Hero("德玛西亚"+i, 1000+i);
			heros.add(hero);
		}
		
		String result = JSONSerializer.toJSON(heros).toString();
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
		
	}
	
}
