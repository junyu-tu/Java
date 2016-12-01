<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%

request.removeAttribute("requestName");
request.getSession().removeAttribute("sessionName");
request.getSession().getServletContext().removeAttribute("contextName");

request.getSession().removeAttribute("currentUser");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是销毁的界面</h1>
	<br/>
	<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">Init</button>
	<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">Destory</button>
</body>
</html>