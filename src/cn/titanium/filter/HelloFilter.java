package cn.titanium.filter;

/**
 * 拦截器步骤
 * @author Administrator
 *2017年10月27日下午11:15:06
 */
public class HelloFilter {
	
	//1 : Filter概念
	/*Filter就像一个一个哨卡，用户的请求需要经过Filter
	并且可以有多个过滤器*/
	
	// 2 : 编写 FirstFilter
	/*开发一个简单的FirstFilter，用来打印用户访问ip地址和访问的页面
	 
	HttpServletRequest request = (HttpServletRequest) req;
	 
	doFilter()方法中的req参数的类型是ServletRequest，需要转换为HttpServletRequest类型方便调用某些方法 (参考request常见方法)
	 
	String ip = request.getRemoteAddr();
	 
	获取来路用户的ip地址
	 
	String url = request.getRequestURL().toString();	 

	获取用户访问的页面地址
	 
	System.out.printf("%s %s 访问了 %s%n", date, ip, url);
	 
	在控制台打印出来
	 
	chain.doFilter(request, response);
	 
	过滤器放行，表示继续运行下一个过滤器，或者最终访问的某个serlvet,jsp,html等等*/
	
	// 3 : 配置web.xml
	/*在web.xml中进行filter的配置，和servlet的配置很类似	 
	<url-pattern></url-pattern>
	 
	表示所有的访问都会过滤

	如果配置成
	 
	<url-pattern>*.jsp</url-pattern>
	 
	就表示只过滤jsp
	代码比较 复制代码
	 */
	
	
	//4 : 访问页面
	//重启tomcat,所有用户的访问信息，都可以打印出来
	
	// 5 : init() 方法
	/*与Servlet需要配置自启动才会随着tomcat的启动而执行init()方法不一样。

	Filter一定会随着tomcat的启动自启动。*/
	
	// 6 : Filter启动失败
	/*Filter是web应用非常重要的一个环节，如果Filter启动失败，或者本身有编译错误，不仅这个Filter不能使用，整个web应用会启动失败，导致用户无法访问页面

	在启动tomcat过程中，也会看到这样的字样： 

	 
	严重: Context [] startup failed due to previous errors
	 

	这常常用于提示Filter启动失败了*/
	
}
