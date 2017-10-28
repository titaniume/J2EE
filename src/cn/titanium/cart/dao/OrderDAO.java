package cn.titanium.cart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.titanium.cart.bean.Order;

/**
 * 订单保存到数据库
 * @author Administrator
 *2017年10月28日下午10:16:56
 */
public class OrderDAO extends BaseDao {
	
	
	public void saveOrder(Order o){
		String sql ="insert into order_ values(null,?)";
		try(PreparedStatement ps=getConneciton(sql);){
			ps.setInt(1,o.getUser().getId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				int id = rs.getInt(1);
				o.setId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
