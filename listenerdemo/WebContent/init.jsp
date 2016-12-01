<%@page import="com.sun.xml.internal.stream.Entity"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%

//request.getAttribute("");和request.getParameter("");
//两者的区别：getAttribute的值是放在域对象request里面的一个属性
//         getParameter是request请求的一个参数，可以获取通过http://www.imooc.com/username=zhangsan 请求的参数
request.setAttribute("requestName", "requestValue");
request.getSession().setAttribute("sessionName", "sessionValue");
request.getSession().getServletContext().setAttribute("contextName", "contextValue");

request.getSession().setAttribute("currentUser", new entity.User());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是初始化的界面</h1>
	<br/>
	<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">Init</button>
	<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">Destory</button>
</body>
</html>