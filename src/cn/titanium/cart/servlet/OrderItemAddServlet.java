package cn.titanium.cart.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.titanium.cart.bean.OrderItem;
import cn.titanium.cart.bean.Product;
import cn.titanium.cart.dao.ProductDAO;

/**
 * 点击购买，添加商品到订单项
 * @author Administrator
 *2017年10月28日下午6:29:21
 */
@WebServlet("/OrderItemAddServlet")
public class OrderItemAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderItemAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));
		//商品id
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product product = new ProductDAO().getProduct(pid);
		
		OrderItem oi = new OrderItem();
		oi.setNum(num);
		oi.setProduct(product);
		
		List<OrderItem> ois =(List<OrderItem>)request.getSession().getAttribute("ois");
		if(null==ois){
			//把订单保存到会话
			ois = new ArrayList<OrderItem>();
			request.getSession().setAttribute("ois", ois);
		}
		
		boolean found = false;
        for (OrderItem orderItem : ois) {
            if (orderItem.getProduct().getId() == oi.getProduct().getId()) {
                orderItem.setNum(orderItem.getNum() + oi.getNum());
                found = true;
                break;
            }
        }
 
        if (!found)
            ois.add(oi);
 
        response.sendRedirect("OrderItemListServlet");
	}

}
