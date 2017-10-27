package cn.titanium.mvc.pagination;

/**
 * 分页步骤
 * @author Administrator
 *2017年10月27日下午7:14:09
 */
public class Step {
	
	/*随着数据中记录的增多，网页上显示的数据会越来越多。 

	当多到一定程度的时候，就会影响用户的体验。 

	解决办法是通过分页技术，一次只显示数据库中的部分数据，如果要看其他数据，可以通过"下一页" "最后一页" 等翻页操作实现*/
	
	//1 : 首先准备 DAO
	/*在DAO中提供方法 
	 
	public List<Hero> list(int start, int count) 
	 

	start表示开始的个数，count表示取多少条
	比如 list(0, 5) ， 即表示第一页，每页有5条数据
	比如 list(5, 5) ， 即表示第二页，每页有5条数据*/
	
	//2 : 只显示5条数据
	/*修改HeroListServlet	 
	int start = 0;
	int count = 5;
	List<Hero> heros = new HeroDAO().list(start, count);*/
	
	//3 : 下一页
	/*PageHeroServlet : 
		通过参数获取start，如果浏览器没有传递参数，就设置为0。 
		根据start，计算next. next的值就是start+count.
		然后把next传递给pagehero.jsp
		pagehero.jsp
		在最后面增加一个超链
		<a href="?start=${next}">[下一页]</a>	
		start=${next} 从服务器传递过来的next值
		*/
	
	//4 : 上一页
	/*PageHeroServlet:
		根据start，计算pre. pre的值就是start-count.
		然后把pre传递给pagehero.jsp

		pagehero.jsp
		在下一页前增加一个超链
		 
		<a href="?start=${pre}">[上一页]</a>
		start=${pre} 从服务器传递过来的pre值
*/
	
	//5 : 第一页  提问
	/*只需要修改pagehero.jsp即可
	增加 	 
	<a href="?start=0">[首  页]</a> 
	因为首页的start永远都是0*/
	
	// 6 : 最后一页
	/*PageHeroServlet:
		在PageHeroServlet中计算last
		last需要根据总数total和每页有多少条数据count来计算得出。

		同时，还要看total是否能够整除count
		假设总数是50，是能够被5整除的，那么最后一页的开始就是45
		 
		if (0 == total % count)
		  last = total - count;		 

		假设总数是51，不能够被5整除的，那么最后一页的开始就是50
		 
		last = total - total % count;
		 
		listHero.jsp
		在下一页后增加一个超链
		 
		<a href="?start=${last}">[末 页]</a>
		 
		start=${last} 从服务器传递过来的last值*/
	
	// 7 : 边界处理上一页，下一页有一个问题，
	/*如果在第一页点击上一页，就会看不到数据了，因为在第一页的时候，pre=-5,也就导致传递到serlvet的start=-5;
	同样的在最后一页的时候，点击下一页，也有类似的问题。

	解决办法是进行边界处理：
	 
	pre = pre < 0 ? 0 : pre;
	 

	如果pre是负数了，就使用0 
	 
	next = next > last ? last : next;
	 

	如果next大于last，就使用last*/
	
	//假设bootstarap
}
