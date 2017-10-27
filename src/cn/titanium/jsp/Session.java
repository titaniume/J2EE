package cn.titanium.jsp;

/**
 * Session
 * @author Administrator
 *2017年10月27日上午8:12:35
 */
public class Session {
	
	//1 : 健身房的储物柜
	/*考虑这个场景：
	李四到健身房去练胸肌，首先领了钥匙，然后进了更衣间，把衣服，裤子，手机，钱包都放在盒子里面。

	张三也到健身房，去练翘臀。首先领了钥匙，然后 进了更衣间，把衣服，裤子，手机，《Java 21天从入门到精通》也放在了一个盒子里，但是这个盒子是和李四的是不同的。

	健身房，就相当于服务器，盒子，就是会话Session。

	切换到我们常见的购物网站的场景
	李四登陆天猫之后，在购物车里看到的物品是蜡烛和皮鞭
	张三登陆天猫之后，在购物车里看到的物品是手铐和《Java 21天从入门到精通》*/
	
	//2:什么是Session
	/*Session对应的中文翻译是会话。 
	会话指的是从用户打开浏览器访问一个网站开始，无论在这个网站中访问了多少页面，点击了多少链接，都属于同一个会话。 直到该用户关闭浏览器为止，都属于同一个会话。*/

	//3 : setSession.jspsession.setAttribute("name", "teemo");
	/*session对象保存数据的方式，有点像Map的键值对(key-value)
	"name"是键，"teemo" 是值*/
	
	// 4 : getSession.jsp
	/*session.getAttribute("name");
	通过session,根据"name" 取出对应的名称*/
	
	//5 : Session和Cookie的关系
	/*回到健身房的储物柜这一段：

	张三和李四都有自己的盒子，那么他们怎么知道哪个盒子是自己的呢？ 
	通过钥匙就能找到自己的盒子了。

	盒子对应服务器上的Session。
	钥匙对应浏览器上的Cookie。*/
	
	//7 : 如果没有cookie，session如何工作
	/*如果浏览器把cookie功能关闭，那么服务端就无法获取jsessionid,每一次访问，都会生成一个新的session对象。

	为了解决这个问题，可以使用
	 
	response.encodeURL("getSession.jsp"))
	 	
	response.encodeURL方法会把getSession.jsp这个url转换为
	 
	getSession.jsp;jsessionid=22424AEA86ADBE89F335EEB649D997A8
	 
	通过这个方式，提交jsessionid到服务器。 服务器根据这个jsessionid匹配到对应的session. 与session相关的功能，就可以正常工作了。*/
	
	//8 : session的有效期
	/*比如登录一个网站，登录后，在短时间内，依然可以继续访问而不用重新登录。

	但是较长时间不登录，依然会要求重新登录，这是因为服务端的session在一段时间不使用后，就失效了。

	这个时间，在Tomcat默认配置下，是30分钟。

	可以通过 d:/tomcat/conf/web.xml 中的session-config 配置进行调整
	
	 <session-config>
        <session-timeout>30</session-timeout>
    </session-config>
	*/
}
 	 