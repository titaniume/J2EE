package cn.titanium.mvc.query.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.titanium.mvc.query.bean.Hero;
import cn.titanium.mvc.query.dao.HeroDAO;

/**
 * Servlet implementation class HeroListServlet
 */
@WebServlet("/HeroListServlet")
public class HeroListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeroListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Hero> heros =new HeroDAO().list();
		request.setAttribute("heros", heros);
		request.getRequestDispatcher("listHero.jsp").forward(request, response);
		
		
	}

}
