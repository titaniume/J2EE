package cn.titanium.jsp;

/**
 * JSTL
 * @author Administrator
 *2017年10月27日上午10:19:47
 */
public class Jstl {
	
	/*JSTL JSP Standard Tag Library 标准标签库 

	JSTL允许开人员可以像使用HTML标签 那样在JSP中开发Java功能。 

	JSTL库有core, i18n, fmt, sql 等等。 

	i18n和sql用的很少，core和fmt在工作中会用到，本章节主要讲解core和fmt*/
	
	// 1 : 导入jar包 --->jstl.jar standard.jar
	
	// 2 : set out remove
	/*在页面中使用JSTL需要在jsp中 通过指令进行设置
	 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	 
	prefix="c" 表示后续的标签使用都会以<c: 开头
	 
	<c:set var="name" value="${'gareen'}" scope="request" />
	 
	在作用域request中设置name,相当于
	<%request.setAttribute("name","gareen")%>
	 
	<c:out value="${name}" />
	 
	相当于 <%=request.getAttribute("name")%>
	 
	<c:remove var="name" scope="request" />
	 
	在作用域request中删掉name,相当于
	<%request.removeAttribute("name")%>

	作用域可以是pageContext, request, session, application, 参考 作用域*/
	
	//3 : if else
	/*JSTL通过<c:if test=""> 进行条件判断

	但是JSTP没有<c:else，所以常用的办法是在<c:if的条件里取反

	配合if使用的还有通过empty进行为空判断
	empty可以判断对象是否为null,字符串长度是否为0，集合长度是否为0*/
	
	
	// 4 : choose
	//虽然JSTL没有提供else标签，但是提供了一个else功能的标签
	
	//5 : forEach
	/*可以在JSP中使用for循环，但是其可读性很差。 借助JSTL的c:forEach标签，可以改善可读性

	在本例中，分别使用for循环和<c:forEach标签来演示遍历一个List的区别
	 
	<c:forEach items="${heros}" var="hero" varStatus="st"  >
	 
	items="${heros}" 表示遍历的集合
	var="hero" 表示把每一个集合中的元素放在hero上
	varStatus="st" 表示遍历的状态*/
	
	
	//6 : forTokens
	//<c:forTokens专门用于字符串拆分，并且可以指定多个分隔符
	
	// 7 : fmt:formatNumber 格式化数字
	/*fmt 标签常用来进行格式化，其中fmt:formatNumber用于格式化数字
	使用之前要加上
	 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  
	 	 
	<fmt:formatNumber type="number" value="${money}" minFractionDigits="2"/>
	 
	<fmt:formatNumber 表示格式化数字
	minFractionDigits 小数点至少要有的位数
	maxFractionDigits 小数点最多能有的位数*/
	
	
	// 8 : fmt:formatDate 格式化日期
	/*fmt 标签常用来进行格式化，其中fmt:formatDate 用于格式化日期
	和fmt:formatNumber 格式化数字一样，使用之前要加上
	 
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix='fmt' %>  
	 

	 
	<fmt:formatDate value="${now}" pattern="G yyyy年MM月dd日 E"/>
	<fmt:formatDate value="${now}" pattern="a HH:mm:ss.S z"/>
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
	 

	<fmt:formatDate 表示格式化日期
	yyyy 表示年份
	MM 表示月份
	dd 表示日期
	E 表示星期几

	a 表示是上午还是下午
	HH 表示小时
	mm 表示分钟
	ss 表示秒
	S 表示毫秒
	z 表示时区*/
	
	
	// 9 : fn:
	/*fn标签提供各种实用功能，首先使用之前使用加入如下指令
	 
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
	 

	用法举例：
	 
	 ${fn:substring(name, 0, 5)}
	 

	获取name的前5位*/
}
