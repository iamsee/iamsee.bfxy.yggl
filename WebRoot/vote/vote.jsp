<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.iamsee.valuebean.VoteSingle" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList votelist = (ArrayList)session.getAttribute("votelist");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vote.jsp' starting page</title>
    
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
  <center>
	<form style="height: 90px; " action=servlet/dovoteservlet method="post">
		<center>投票选择如下:</center>
		<table>
		<tr>
		<td style="width: 136px; height: 12px">选择项:</td>
		<td align="right" style="width: 119px; ">  </td>
		</tr>
		<% if(votelist == null || votelist.size()==0) {
		%>
		<tr>
		<td>没有可选投票项</td>
		</tr>
		<%	}
		else{
			for(int i =0;i<votelist.size();i++)
			{
				VoteSingle votesingle  = (VoteSingle) votelist.get(i);
	
	
		%>
		<tr>
		<td><%=votesingle.getBeselected().toString() %></td>
		<td align="right"><input type="radio" name="radioid" value="<%=votesingle.getId() %>" ></td>
		</tr>
		<%
				}
		}
		 %>
		<tr>
		<td>
		<input type="submit" value="提交投票">
				</td>
				<td>
				<a href="servlet/showvoteservlet">查看结果</a>
				</td>
				
				
		</tr>
		
		
		</table>
	</form>
	<br>
	</center>
  </body>
</html>
