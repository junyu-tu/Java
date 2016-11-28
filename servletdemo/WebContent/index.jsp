<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Servlet1</title>
</head>
<body>
	<h1>Servlet1</h1>
	<br/>
	<a href="servlet/Servlet1">通过doGet方法调用Servlet1</a>
	
	<form action="servlet/Servlet1" method="POST">
		<input   type="submit"   value="通过doPost方法调用Servlet1">
	</form>
	<hr/>
	<h1>Servlet2</h1>
	<br/>
	<a href="servlet/Servlet2">通过doGet方法调用Servlet2</a>
	
	<form action="servlet/Servlet2" method="POST">
		<input   type="submit"   value="通过doPost方法调用Servlet2">
	</form>

</body>
</html>