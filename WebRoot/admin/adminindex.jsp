<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String infopage = (String)session.getAttribute("infopage");
System.out.println(infopage);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminindex.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
    <frameset  rows="10%,*" border="5" >
    <frame src="admin/top.jsp" name="top" scrolling="auto" noresize="noresize">
   <frameset cols="15%,*" border="5" >
    <frame src="admin/adminloginsuccess.jsp" name="left" scrolling="auto" noresize="noresize">
    <frame src="admin/<%=infopage %>" name="right" scrolling="auto" noresize="noresize">
   </frameset>
   </frameset>
</html>
