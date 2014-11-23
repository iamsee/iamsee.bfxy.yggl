<%@page import="com.iamsee.valuebean.baseinfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
baseinfo bi = (baseinfo)session.getAttribute("bi");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updatebaseinfo.jsp' starting page</title>
    
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
  	<div>
  	title
  	</div>
    <div>
    	<form action="servlet/dobaseinfo" method="get">
    	<p>类型:<input  readonly="true" name="type" value="update""></p>
    	<p>id:<input type="text" name="baseinfoid" readonly="true" value="<%=bi.getId()%>"></p>
    	<p>姓名：	<input type="text" name="name" value="<%=bi.getName()%>"></p>
    	<p>简拼：	<input type="text" name="shortname" value="<%=bi.getShortname()%>"></p>
    	<p>性别：	<input type="text" name="sex" value="<%=bi.getSex()%>"></p>
    	<p>生日：	<input type="text" name="birth" value="<%=bi.getBirth()%>"></p>
    	<p>家乡：	<input type="text" name="hometowndes" value="<%=bi.getHometowndes()%>"></p>
    	<p>身份证：	<input type="text" name="idcard" value="<%=bi.getIdcard()%>"></p>
    	<p>工作时间：	<input type="text" name="worktime" value="<%=bi.getWorktime()%>"></p>
    	<p>所属部门：	<input type="text" name="postname" value="<%=bi.getPostname()%>"></p>
    	<p><input type="submit" value="更新信息"></p>
    	</form>
    </div>
    
  </body>
</html>