<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SpringMVC</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<h1>欢迎来到SpringMVC的世界！</h1>
 		${requestScope.a} <br/>
		${sessionScope.a} <br/>
		${sessionScope.c} <br/>
		${requestScope.user.userName} <br/>
		${requestScope._user.userName} <br/>
		
		<a href="register.jsp">注册样式一</a>
		<a href="register_2.jsp">注册样式二</a>
		<a href="register_3.jsp">注册样式三</a>
		<a href="register_4.jsp">注册样式四</a>
		<a href="register_5.jsp">注册样式五</a>
		
  </body>
</html>
