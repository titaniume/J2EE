package cn.titanium.filter;

/**
 * 中文处理
 * @author Administrator
 *2017年10月27日下午11:37:56
 */
public class ChinaHandle {
	
	
	// 1 : 使用Servlet处理的局限性
	/*在通过Servlet获取中文参数 的章节中知道，可以通过
	 	request.setCharacterEncoding("UTF-8");
	 
	正确获取UTF-8编码的中文，但是如果有很多servlet都需要获取中文，那么就必须在每个Servlet中增加这段代码。

	有一个简便的办法，那就是通过Filter过滤器进行中文处理 ，那么所有的Servlet都不需要单独处理了。*/
	
	
	// 2 : 使用Filter处理
	/*创建一个 EncodingFilter ，设置如下代码 
	HttpServletRequest request = (HttpServletRequest) req;
	request.setCharacterEncoding("UTF-8");
	 
	doFilter方法的第一个参数req,是ServletRequest 类型的，不支持setCharacterEncoding，
	所以要先强制转换为HttpServletRequest*/
	
	//3 : 配置web.xml
	/*配置EncodingFilter	 
	<url-pattern></url-pattern>	
	表示为所有的访问都使用该Filter*/
	
	// 4 : 测试
	/*测试前，记得把HeroAddServlet中的 
	 
	request.setCharacterEncoding("UTF-8");
	 
	注释掉
	============这里不再测试
	  protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // request.setCharacterEncoding("UTF-8");
 
        Hero hero = new Hero();
        hero.setName(request.getParameter("name"));
        hero.setHp(Float.parseFloat(request.getParameter("hp")));
        hero.setDamage(Integer.parseInt(request.getParameter("damage")));
 
        new HeroDAO().add(hero);
 
        response.sendRedirect("/listHero");
 
    }
	
	*/
}
