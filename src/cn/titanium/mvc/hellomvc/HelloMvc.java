package cn.titanium.mvc.hellomvc;

/**
 * mvc
 * 
 * @author Administrator
 *2017年10月27日下午3:52:44
 */
public class HelloMvc {
	
	
	// 1 : 仅仅使用Servlet的短处
	/*在Servlet的章节中，使用了编辑Hero的Servlet
	根据浏览器提交的id，通过HeroDAO找到对应的Hero,然后在Servlet中组织html显示出来。

	可以看到这个Servlet不仅要准备数据，还要准备html。 尤其是准备html，可读性非常差，维护起来也很麻烦
	package servlet;
  
import java.io.IOException;
  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
import bean.Hero;
import dao.HeroDAO;
  
public class HeroEditServlet extends HttpServlet {
  
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        int id = Integer.parseInt(request.getParameter("id"));
  
        Hero hero = new HeroDAO().get(id);
  
        StringBuffer format = new StringBuffer();
        response.setContentType("text/html; charset=UTF-8");
  
        format.append("<!DOCTYPE html>");
  
        format.append("<form action='updateHero' method='post'>");
        format.append("名字 ： <input type='text' name='name' value='%s' > <br>");
        format.append("血量 ： <input type='text' name='hp'  value='%f' > <br>");
        format.append("伤害： <input type='text' name='damage'  value='%d' > <br>");
        format.append("<input type='hidden' name='id' value='%d'>");
        format.append("<input type='submit' value='更新'>");
        format.append("</form>");
  
        String html = String.format(format.toString(), hero.getName(), hero.getHp(), hero.getDamage(), hero.getId());
  
        response.getWriter().write(html);
  
	    }
	}
	*/
	
	// 2 : 仅仅使用JSP的短处
	/*因为在Servlet中编写html有这样的短板，所以索性直接在JSP中开发编辑Hero这个功能
	这时会发现，虽然编写html方便了，但是写java代码不如在Servlet中那么方便
		<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,bean.*,java.sql.*"%>
 
	<%
	    int id = Integer.parseInt(request.getParameter("id"));
	    Hero hero = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	     
	        Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
	                "root", "admin");
	     
	        Statement s = c.createStatement();
	     
	        String sql = "select * from hero where id = " + id;
	     
	        ResultSet rs = s.executeQuery(sql);
	     
	        if (rs.next()) {
	            hero = new Hero();
	            String name = rs.getString(2);
	            float hp = rs.getFloat("hp");
	            int damage = rs.getInt(4);
	            hero.name = name;
	            hero.hp = hp;
	            hero.damage = damage;
	            hero.id = id;
	        }
	     
	        s.close();
	     
	        c.close();
	     
	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	     
	%>
	 
	<form action='updateHero' method='post'>
	    名字 ： <input type='text' name='name' value='<%=hero.getName()%>'> <br>
	    血量 ：<input type='text' name='hp' value='<%=hero.getHp()%>'> <br>
	    伤害： <input type='text' name='damage' value='<%=hero.getDamage()%>'> <br>
	    <input type='hidden' name='id' value='<%=hero.getId()%>'>
	    <input type='submit' value='更新'>
	</form>
	*/
	
	//3 : 结合Servlet和JSP
	/*既然Servlet和JSP都有各自的优势和短板，那么为什么不结合起来扬长避短呢？
	HeroEditServlet：只用来从数据库中查询Hero对象，然后跳转到JSP页面
	 
	request.setAttribute("hero", hero);
	 
	在request中设置hero
	 
	request.getRequestDispatcher("editHero.jsp").forward(request, response);
	 
	服务端跳转到editHero.jsp，因为是服务端跳转，都属于同一次请求，所以可以在editHero.jsp通过request取出来

	editHero.jsp: 不做查询数据库的事情，直接获取从HeroEditServlet传过来的Hero对象，通过EL表达式把request中的hero显示出来
	
	public class HeroEditServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Hero hero = new HeroDAO().get(id);
        request.setAttribute("hero", hero);
        request.getRequestDispatcher("editHero.jsp").forward(request, response);
    }
    
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,bean.*,java.sql.*"%>
 
	<form action='updateHero' method='post'>
	    名字 ： <input type='text' name='name' value='${hero.name}'> <br>
	    血量 ：<input type='text' name='hp' value='${hero.hp}'> <br>
	    伤害： <input type='text' name='damage' value='${hero.damage}'> <br>
	    <input type='hidden' name='id' value='${hero.id}'>
	    <input type='submit' value='更新'>
	</form>
}
	*/
	
	//4 : MVC设计模式
	/*上述例子中结合Serlvet和JSP进行数据的显示，就是一种MVC的思想。

	M 代表 模型（Model）
	V 代表 视图（View） 
	C 代表 控制器（controller) 

	模型是什么呢？ 模型就是数据，就是dao,bean

	视图是什么呢？ 就是网页, JSP，用来展示模型中的数据

	控制器是什么？ 控制器用来把不同的数据，显示在不同的视图上。 在这个例子的，Servlet就是充当控制器的角色，把Hero对象，显示在JSP上。

	控制器的作用就是把不同的数据(Model)，显示在不同的视图(View)上。*/
}
