<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%=request.getSession().getAttribute("currentUser") %>
	<h1>This is a JSP Page</h1>
	<br/>
	<button onclick="location.href='<%=request.getContextPath()%>/init.jsp';">Init</button>
	<button onclick="location.href='<%=request.getContextPath()%>/destory.jsp';">Destory</button>
</body>
</html>