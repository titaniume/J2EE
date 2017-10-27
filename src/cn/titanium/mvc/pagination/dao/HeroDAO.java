package cn.titanium.mvc.pagination.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.titanium.mvc.pagination.bean.Hero;

public class HeroDAO {
	
	/**
	 * 加载驱动
	 */
	public HeroDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public Connection getConneciton() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEnconding=UTF-8","root","root");
	}
 
	
	public List<Hero> list(){
		return list(0,Short.MAX_VALUE);
		
	}
	
	/**
	 * 分页查询
	 * @param start:表示开始的个数
	 * @param count:count表示取多少条
	 * @return
	 */
	public List<Hero> list(int start, int count) {
		List<Hero> heros = new ArrayList<Hero>();
		String sql ="select * from hero order by id desc limit ?,?";
		try(Connection c = getConneciton(); PreparedStatement st = c.prepareStatement(sql)){
			st.setInt(1, start);
			st.setInt(2, count);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Hero h = new Hero();
				h.setId(rs.getInt(1));
				h.setName(rs.getString(2));
				h.setHp(rs.getFloat(3));
				h.setDamage(rs.getInt(4));
				heros.add(h);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}

	public int getTotal() {
		 int total = 0;
		 try(Connection c = getConneciton(); Statement s=c.createStatement();){
	 
	            String sql = "select count(*) from hero";
	 
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                total = rs.getInt(1);
	            }
	
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return total;
	}
 
 
}
