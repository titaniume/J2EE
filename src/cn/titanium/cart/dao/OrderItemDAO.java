package cn.titanium.cart.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.titanium.cart.bean.OrderItem;

/**
 * 订单项保存到数据库
 * @author Administrator
 *2017年10月28日下午10:27:35
 */
public class OrderItemDAO extends BaseDao {
	
	public void saveOrderItem(OrderItem oi){
		String sql ="insert into orderitem values(null,?,?,?)";
		try(PreparedStatement ps = getConneciton(sql);){
			ps.setInt(1, oi.getProduct().getId());
			ps.setInt(2, oi.getNum());
			ps.setInt(3, oi.getOrder().getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
