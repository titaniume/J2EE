package cn.titanium.cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {
	
	public BaseDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  PreparedStatement getConneciton(String sql) throws SQLException{
		
		Connection c =	DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/shopcart?characterEncoding=UTF-8",
				"root", "root");
		PreparedStatement prepareStatement = c.prepareStatement(sql);
		return   prepareStatement;
	}
}
