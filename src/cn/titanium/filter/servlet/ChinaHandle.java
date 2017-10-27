package cn.titanium.filter.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChinaHandle
 */
@WebServlet("/ChinaHandle")
public class ChinaHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChinaHandle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.setCharacterEncoding("UTF-8");
		String name =request.getParameter("name");
		String password = request.getParameter("password");
		
		request.setAttribute("name", name);
		request.setAttribute("password",password);
		/*response.sendRedirect("chinahandle.jsp");*/
		request.getRequestDispatcher("chinahandle.jsp").forward(request, response);
	}

}
