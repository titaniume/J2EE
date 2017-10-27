package cn.titanium.jsp;

/**
 * EL表达式
 * @author Administrator
 *2017年10月27日下午2:49:00
 */
public class ElExpress {
	
	// 1 : 取值
	/*不同版本的tomcat是否默认开启对EL表达式的支持，是不一定的。

	所以为了保证EL表达式能够正常使用，需要在<%@page 标签里加上isELIgnored="false"

	使用EL表达式，非常简单

	比如使用JSTL输出要写成
	 
	<c:out value="${name}" /> 
	 
	但是用EL只需要
	 
	${name}*/
	
	// 2 : 作用域优先级
	/*EL表达式可以从pageContext,request,session,application四个作用域中取到值，如果4个作用域都有name属性怎么办？ 

	EL会按照从小到大的优先级顺序获取 
	pageContext>request>session>application*/
	
	
	// 3 : JavaBean概念
	/*L可以很方便的访问JavaBean的属性，那么JavaBean是什么呢？ 

	JavaBean的标准
	1. 提供无参public的构造方法(默认提供)
	2. 每个属性，都有public的getter和setter

	比如示例代码中的Hero类，默认提供了一个无参的public的构造方法。 同时每个属性都有getter和setter*/
	
	//4 : 获取JavaBean的属性
	/*获取JavaBean的属性，只需要通过.符号操作就可以了。

	像这样 ${hero.name}*/
	
	//5 : 结合JSTL的<c:forEach
	/*EL还可以结合 JSTL的<c:forEach 使用，进一步简化代码

	原代码中的 
	 
	<c:out value="${hero}" /> 
	 
	可以简写为
	 
	${hero}*/
	
	//6 : 取参
	/*EL表达式还可以做到request.getParameter("name") 这样的形式获取浏览器传递过来的参数
	先把jstl.jsp代码改为如例所示，然后访问如下地址
	 
	http://127.0.0.1/jstl.jsp?name=abc
	
	可以观察到获取了参数 name*/
	
	//7 : eq
	/*进行条件判断，大大简化了 JSTL的 c:if 和 c:choose 代码

	如例，一行代码就能其他其他好几行代码的效果
	 
	${killNumber ge 10? "超神":"还没超神" }
	 


	例子中讲的是大于等于，除此之外的其他用法如下：
	eq相等 ne、neq不相等，
	gt大于， lt小于
	gt大于， lt小于
	gte、ge大于等于 
	lte、le 小于等于 
	not非 mod求模 
	is [not] div by是否能被某数整除 
	is [not] even是否为偶数 
	is [not] odd是否为奇*/
	
	
}	
