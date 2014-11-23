<%@page import="com.iamsee.valuebean.baseinfo"%>
<%@page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList nowlist = (ArrayList)session.getAttribute("nowlist");
System.out.println(nowlist.size());

String insertmsg = (String)session.getAttribute("insertmsg");
System.out.println(insertmsg);
String updatemsg = (String)session.getAttribute("updatemsg");
System.out.println(updatemsg);
String delmsg = (String)session.getAttribute("delmsg");
System.out.println(delmsg);
if((!insertmsg.equals("没有插入返回信息")) && (insertmsg != null) && (!insertmsg.equals("")))
{
%>
<script type="text/javascript"> alert("<%=insertmsg%>"); </script>
<%
} 
if((!updatemsg.equals("没有更新返回信息")) && (updatemsg != null) && (!updatemsg.equals("")))
{
%>

	<script type="text/javascript"> alert("<%=updatemsg%>"); </script>

<%
}
if((!delmsg.equals("没有删除返回信息")) && (delmsg != null) && (!delmsg.equals("")))
{
 %>
 
 <script type="text/javascript"> alert("<%=delmsg%>"); </script>
 <%
}
%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showinfo.jsp' starting page</title>

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

<jsp:include page="select.jsp"></jsp:include>
bbbb
<table>
	<tr>
		<td>姓名</td>
		<td>简拼</td>
		<td>生日</td>
		<td>家乡</td>
		<td>身份证</td>
		<td>工作时间</td>
		<td>所属机构</td>
		<td>操作</td>


	</tr>

	<%if (nowlist == null || nowlist.equals("")) {%>
	<tr>
		<td>没有nowlist任何信息</td>
	</tr>
	<%}	else{
	 for(int i = 0;i<nowlist.size();i++){
	 	baseinfo bi = (baseinfo)nowlist.get(i);
	 
	 %>
	 <tr>
	 	<td><%=bi.getName() %></td>
	 	<td><%=bi.getShortname() %></td>
	 	<td><%=bi.getSex()%></td>
	 	<td><%=bi.getHometowndes() %></td>
	 	<td><%=bi.getIdcard() %></td>
	 	<td><%=bi.getWorktime() %></td>
	 	<td><%=bi.getPostname() %></td>
	 	<td>
	 		<a href="servlet/dobaseinfo?type=toupdate&baseinfoid=<%=bi.getId()%>">修改</a>
	 		<a href="servlet/dobaseinfo?type=del&baseinfoid=<%=bi.getId()%>">删除</a>
	 	</td>
	 </tr>
	 <%}
	 } %>
	 </table>
	
		 <div>
		 	<a href="servlet/dobaseinfo?type=toinsert">新增员工</a>
		 </div>
	aaaaaaaaaaaaa
	<jsp:include page="pagefoot.jsp"></jsp:include>
	
</body>
</html>
