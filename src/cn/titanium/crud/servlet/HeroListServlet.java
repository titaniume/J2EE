package cn.titanium.crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.titanium.crud.bean.Hero;
import cn.titanium.crud.dao.HeroDAO;

/**
 * Servlet implementation class HeroListServlet
 */
@WebServlet("/HeroListServlet")
public class HeroListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		List<Hero> heros = new HeroDAO().list();
	
		StringBuffer sb = new StringBuffer();
		sb.append("<table align='center' borde r ='1' cellspacing='0'>");
		sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>edit</td><td>delete</td></tr>");
		String trFormat ="<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='EditHeroServlet?id=%d'>edit</a></td><td><a href='DeleteHeroServlet?id=%d'>delete</a></td></tr>";
		
		for (Hero hero : heros) {
			String tr = String.format(trFormat, hero.getId(),hero.getName(),hero.getHp(),hero.getDamage(),hero.getId(),hero.getId());
			sb.append(tr);
		}
		sb.append("</table>");
		PrintWriter pw = response.getWriter();
		pw.write(sb.toString());
	}

}
