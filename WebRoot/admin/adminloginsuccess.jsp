<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String infopage = "showinfo.jsp";
	session.removeAttribute("infopage");
	session.setAttribute("infopage", infopage);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminloginsuccess2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body{ background: url("admin/images/left-bg.gif"); font:bold; color: blue;}
</style>
  </head>
  
  <body>
<center>
<p>管理员登录成功</p>
<br/>
<br/>
<center>
	<a href="servlet/dopageservlet" target="right">查看员工信息</a>
	            
</center>


</body>
</html>
