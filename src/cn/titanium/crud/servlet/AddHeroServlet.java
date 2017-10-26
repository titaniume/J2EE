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
 * Servlet implementation class AddHeroServlet
 */
@WebServlet("/AddHeroServlet")
public class AddHeroServlet extends HttpServlet {
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Hero hero = new Hero();
		request.setCharacterEncoding("UTF-8");
		hero.setName(request.getParameter("name"));
		hero.setHp(Float.parseFloat(request.getParameter("hp")));
		hero.setDamage(Integer.parseInt(request.getParameter("damage")));
		new HeroDAO().addHero(hero);
		response.sendRedirect("HeroListServlet");
	}
       
	

}
