<%@page import="java.lang.reflect.Parameter"%>
<%@page import="com.iamsee.toolbean.MyTools"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.iamsee.valuebean.VoteSingle"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList votelist = (ArrayList)session.getAttribute("votelist");

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showvote.jsp' starting page</title>

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

<form action="servlet/addvoteservlet"method="post">

<div align="center">

	<table>
		<tr>
			<td>投票结果如下：</td>
		</tr>
		<tr>
			<td>对象名称：</td>
			<td>对应票数：</td>
			<td style="width: 160px; ">图形显示：</td>
			<td>所占比例：</td>
		</tr>
		<% if(votelist ==null || votelist.size()==0)
		{
		%>
		<tr>
			<td>没有数据源显示</td>
		</tr>
		<%
		}
		else
		{
			VoteSingle votesingle = new VoteSingle();
			float numAll = 0;
			System.out.println(votelist.size());
		for(int i=0;i<votelist.size();i++)
		{
			votesingle = (VoteSingle)votelist.get(i);
			numAll += Integer.parseInt(votesingle.getVotenum());
			System.out.println(numAll);
		}
		for(int i =0;i<votelist.size();i++)
		{
			 votesingle = (VoteSingle)votelist.get(i);
			 float numOne=Integer.parseInt(votesingle.getVotenum());
			 System.out.println(numOne);
                    		   float picLen=numOne*145/numAll;						//计算图片长度
                    		   System.out.println(picLen);
                    		   float per=numOne*100/numAll;							//计算票数所占的百分比
                    		   
                    		   float doPer=((int)((per+0.05f)*10))/10f;				//保留百分比后的一位小数，并进行四舍五入
		%>
		<tr height="25">
			<td><%=votesingle.getBeselected() %></td>
			<td><%=votesingle.getVotenum()%></td>
			 <td><img src="images/count.jpg" width="<%=picLen%>" height="20" alt="影片：<%=votesingle.getBeselected()%>"></td>
			<td width="15%" align="right"><%=doPer%>%</td>
		</tr>
		
	
		<%
		}
		}
		 %>
		
		 
		<tr>

		</tr>
	</table>

		新增投票项目	<input type="text" name="addvotevalue">
		
		<input type="submit" value="增加">
		</div>
</form>
</body>
</html>
