package cn.titanium.cart.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.titanium.cart.bean.Order;
import cn.titanium.cart.bean.OrderItem;
import cn.titanium.cart.bean.User;
import cn.titanium.cart.dao.OrderDAO;
import cn.titanium.cart.dao.OrderItemDAO;

/**
 * 创建订单
 * @author Administrator
 *2017年10月28日下午10:35:39
 */
@WebServlet("/OrderCreateServlet")
public class OrderCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//判断是否登陆
		User u=(User)request.getSession().getAttribute("user");
		if(null==u){
			response.sendRedirect("login.jsp");
			return;
		}
		
		Order o = new Order();
		o.setUser(u);
		
		//保存订单
		new OrderDAO().saveOrder(o);
		
		List<OrderItem> ois=(List<OrderItem>)request.getSession().getAttribute("ois");
		for (OrderItem orderItem : ois) {
			orderItem.setOrder(o);
			new OrderItemDAO().saveOrderItem(orderItem);
		}
		ois.clear();
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("订单创建成功!");
	}

}
