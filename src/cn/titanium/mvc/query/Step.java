package cn.titanium.mvc.query;

/**
 * 做一个查询的步骤
 * @author Administrator
 *2017年10月27日下午4:19:58
 */
public class Step {
	
	//1 : 实体类Hero
	//2 : HeroDAO
	//3 : HeroListServlet
	//-->作为控制器的HeroListServlet，其作用就是通过dao获取所有的heros对象，然后放在request中，跳转到listHero.jsp
	//web.xml 配置servlet 这里用的是注解
	// 5 : listHero.jsp
}
