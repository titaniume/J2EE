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
 * Servlet implementation class EditHeroServlet
 */
@WebServlet("/EditHeroServlet")
public class EditHeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    Hero hero = new HeroDAO().getHero(id);
	  
	    StringBuffer format = new StringBuffer();
        response.setContentType("text/html; charset=UTF-8");
 
        format.append("<!DOCTYPE html>");
 
        format.append("<form action='UpdateHeroServlet' method='post'>");
        format.append("名字 ： <input type='text' name='name' value='%s' > <br>");
        format.append("血量 ： <input type='text' name='hp'  value='%f' > <br>");
        format.append("伤害： <input type='text' name='damage'  value='%d' > <br>");
        format.append("<input type='text' name='id' value='%d'>");
        format.append("<input type='submit' value='更新'>");
        format.append("</form>");
 
        String html = String.format(format.toString(), hero.getName(), hero.getHp(), hero.getDamage(), hero.getId());
 
        response.getWriter().write(html);
	}

}
