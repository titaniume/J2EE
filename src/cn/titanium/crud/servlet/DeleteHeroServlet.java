package cn.titanium.crud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.titanium.crud.dao.HeroDAO;

/**
 * Servlet implementation class DeleteHeroServlet
 */
@WebServlet("/DeleteHeroServlet")
public class DeleteHeroServlet extends HttpServlet {

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id =Integer.parseInt(request.getParameter("id"));
		new HeroDAO().delete(id);
		
		response.sendRedirect("HeroListServlet");
	}

}

