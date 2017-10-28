package cn.titanium.cart.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.titanium.cart.bean.Product;

public class ProductDAO extends BaseDao {
	
	/**
	 * 显示商品
	 * @return
	 */
	public List<Product> listProduct() {

		List<Product> products = new ArrayList<Product>();
		String sql = "select * from product order by id desc";
		try (PreparedStatement ps = getConneciton(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2),rs.getFloat(3));			
				products.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return products;

	}
	
	/**
	 * 根据Id获取一条少商品
	 * @param id
	 * @return
	 */
	public Product getProduct(int id){
		Product product = null;
		
		String sql ="select * from product where id = ?";
		
		try(PreparedStatement ps = getConneciton(sql);){
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				product = new Product(rs.getInt(1), rs.getString(2), rs.getFloat(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
	
	
}
