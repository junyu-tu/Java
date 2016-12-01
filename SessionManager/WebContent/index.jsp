<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
当前在线用户人数：${userNumber}
<br/>
 <% 
   ArrayList<com.imooc.entity.User> userList =  (ArrayList<com.imooc.entity.User>)request.getServletContext().getAttribute("userList"); 
   if(userList!=null){
       for(int i = 0 ; i < userList.size() ; i++){
    	   com.imooc.entity.User user = userList.get(i);
   %>
    IP:<%=user.getIpString() %>,FirstTime:<%=user.getFirstTimeString() %>,SessionId:<%=user.getSessionIdString() %> <br/>
    <%}} %>
</body>
</html>