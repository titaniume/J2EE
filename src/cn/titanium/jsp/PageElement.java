package cn.titanium.jsp;

/**
 * 页面元素
 * @author Administrator
 *2017年10月26日下午11:21:14
 */
public class PageElement {
	
	// 1 : 页面元素
	/*jsp由这些页面元素组成：
	1. 静态内容
	就是html,css,javascript等内容
	2. 指令
	以<%@开始 %> 结尾，比如<%@page import="java.util.*"%>
	3. 表达式 <%=%>
	用于输出一段html
	4. Scriptlet
	在<%%> 之间，可以写任何java 代码
	5. 声明
	在<%!%> 之间可以声明字段或者方法。但是不建议这么做。
	6. 动作
	<jsp:include page="Filename" > 在jsp页面中包含另一个页面。在包含的章节有详细的讲解
	7. 注释 <%-- -- %>
	不同于 html的注释 <!-- --> 通过jsp的注释，浏览器也看不到相应的代码，相当于在servlet中注释掉了*/
	
	//<%=%>和 <%out.println()%>
	/*<%="hello jsp"%> 
	 
	就相当于
	 
	<%out.println("hello jsp");%>
	out是jsp的隐式对象   <%=%> 不需要分号结尾，<%%> 需要以分号结尾，和java代码一样*/
	
}
