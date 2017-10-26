package cn.titanium.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.titanium.crud.bean.Hero;





public class HeroDAO {
	
	/**
	 * 初始化驱动
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
	public Connection getConnection() throws SQLException{
		
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root","root");
	}
	
	/**
	 * 获取总数
	 * @return
	 */
	public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from hero";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
  
            System.out.println("total:" + total);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
	
	/**
	 * 添加
	 * @param hero
	 */
	public void addHero(Hero hero){
		String sql ="insert into hero values(null,?,?,?);";
		try(Connection c = getConnection();PreparedStatement ps = c.prepareStatement(sql);){
			ps.setString(1, hero.getName());
			ps.setFloat(2, hero.getHp());
			ps.setInt(3,hero.getDamage());
			ps.execute();	
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()){
				int id =rs.getInt(1);
				hero.id =id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改
	 * @param hero
	 */
	 public void update(Hero hero) {
		  
	        String sql = "update hero set name= ?, hp = ? , damage = ? where id = ?";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setString(1, hero.name);
	            ps.setFloat(2, hero.hp);
	            ps.setInt(3, hero.damage);
	            ps.setInt(4, hero.id);	  
	            ps.execute();
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	  
	    }
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(int id){
		
		try(Connection c = getConnection();Statement st=c.createStatement();){
			String sql ="delete from hero where id ="+id;
			st.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取一条
	 * @param id
	 * @return
	 */
	public Hero getHero(int id){
		Hero hero = null;
		try(Connection c = getConnection();Statement st=c.createStatement();){
			String sql ="select *  from hero where id ="+id;
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				hero = new Hero();
				hero.setName(rs.getString("name"));
				hero.setHp(rs.getFloat(3));
				hero.setDamage(rs.getInt(4));
				hero.setId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hero;
		
	}
		
	 /**
	  * 分页查询
	  * @return
	  */
	  public List<Hero> list() {
	        return list(0, Short.MAX_VALUE);
	   }

	public List<Hero> list(int start, int count) {
		 List<Hero> heros = new ArrayList<Hero>();
		 String sql ="select * from hero order by id desc limit ?,?";
		 try(Connection c =getConnection();PreparedStatement ps = c.prepareStatement(sql);){
			 ps.setInt(1, start);
			 ps.setInt(2, count);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){
				 Hero hero = new Hero();
				 hero.setId(rs.getInt(1));
				 hero.setName(rs.getString(2));
				 hero.setHp(rs.getFloat("hp"));
				 hero.setDamage(rs.getInt(4));
				 heros.add(hero);
			 }
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heros;
	}
  	
}
