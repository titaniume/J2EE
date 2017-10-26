package cn.titanium.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.titanium.crud.bean.Hero;
import cn.titanium.crud.dao.HeroDAO;

/**
 * Servlet implementation class UpdateHeroServlet
 */
@WebServlet("/UpdateHeroServlet")
public class UpdateHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  
	        Hero hero = new Hero();
	        hero.setId(Integer.parseInt(request.getParameter("id")));
	        hero.setName(request.getParameter("name"));
	        hero.setHp(Float.parseFloat(request.getParameter("hp")));
	        hero.setDamage(Integer.parseInt(request.getParameter("damage")));
	      
	        new HeroDAO().update(hero);
	       
	        response.sendRedirect("HeroListServlet");
	}

}
