package cn.titanium.cart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.titanium.cart.bean.User;

public class UserDAO extends BaseDao {
	
	public User getUser(String name,String password){
		User user = null;
		 String sql = "select * from user where name = ? and password = ?";
		 
		try(PreparedStatement ps =getConneciton(sql);){
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	
}
