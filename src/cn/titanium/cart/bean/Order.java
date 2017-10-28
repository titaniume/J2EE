package cn.titanium.cart.bean;

/**
 * 订单
 * @author Administrator
 *2017年10月28日下午10:14:18
 */
public class Order {
	
	int id;
	User user;   //对应的用户
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
