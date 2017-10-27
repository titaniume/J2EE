
package cn.titanium.filter;

/**
 * 登陆验证
 * @author Administrator
 *2017年10月28日上午12:02:45
 */
public class LoginCheck {
	
	//1 : 在Servlet中进行登陆验证的局限性
	/*在用户是否登陆的验证中，我们可以通过在HeroListServlet中增加对session的判断代码来做到登陆验证。
	但是按照这样的做法，所有的Servlet都要加上一样的代码，就会显得比较累赘。
	与通过Filter处理中文问题一样，也可以通过Filter一次性解决所有的登陆验证问题*/
	
	// 2 : 使用Filter处理
	/*创建一个AuthFilter 类
	 
	String uri = request.getRequestURI();
	if (uri.endsWith("login.html") || uri.endsWith("login")) {
		chain.doFilter(request, response);
		return;
	}
	 
	首先判断是否是访问的login.html和loginHero，因为这两个页面就是在还没有登陆之前就需要访问的

	 
	String userName = (String) request.getSession().getAttribute("userName");
	if (null == userName) {
	        response.sendRedirect("login.html");
		return;
	}
	从Session中获取userName，如果没有，就表示不曾登陆过，跳转到登陆页面。*/
	
	//3 : 配置web.xml
	
}
