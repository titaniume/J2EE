package cn.titanium.cart.bean;

/**
 * 订单项
 * @author Administrator
 *2017年10月28日下午6:06:08
 */
public class OrderItem {
 
    private int id;
    private Product product;
    private int num;
    private Order order;
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
    
}