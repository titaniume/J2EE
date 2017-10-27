package cn.titanium.mvc.pagination.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.titanium.mvc.pagination.bean.Hero;
import cn.titanium.mvc.pagination.dao.HeroDAO;

/**
 * Servlet implementation class PageHeroServlet
 */
@WebServlet("/PageHeroServlet")
public class PageHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageHeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String userName = (String)request.getSession().getAttribute("userName");
		if(null == userName){
			response.sendRedirect("login.jsp");
			return;
		}
		
		int start = 0;
		int count = 5;
		
		try {
			start =Integer.parseInt(request.getParameter("start"));
		} catch (NumberFormatException e) {
			// 当浏览器没有传参数start时
		}
		int next = start + count;
		int pre = start - count;
		
		 int total = new HeroDAO().getTotal();
		 int last;
		 //假设总数是50 是能够被5整除的 ，那么最后一页的开始值就是45
		 if(0== total%count)
			 	last =total - count;
		 
		 // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
		 else
			last =total -total % count;	 
		 
		   pre = pre < 0 ? 0 : pre;
	       next = next > last ? last : next;
		
		List<Hero> heros = new HeroDAO().list(start,count);
	
		request.setAttribute("heros", heros);
		request.setAttribute("next", next);
		 request.setAttribute("last", last);
		 
		request.getRequestDispatcher("pagehero.jsp").forward(request, response);
	}

}
