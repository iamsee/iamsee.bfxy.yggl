<%@page import="com.iamsee.valuebean.baseinfo"%>
<%@page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@page  contentType="text/html;  charset=utf-8"  %>  
<%@ page import="org.jfree.data.general.DefaultPieDataset,org.jfree.chart.ChartFactory
,org.jfree.chart.JFreeChart,org.jfree.chart.servlet.*" %>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String webkeyword = (String)session.getAttribute("webkeyword");
int allnum = Integer.parseInt(session.getAttribute("allnum").toString());
int keywordnum = Integer.parseInt(session.getAttribute("keywordnum").toString());

ArrayList nowlist = (ArrayList)session.getAttribute("nowlist");
System.out.println(nowlist.size());
String infopage = (String)session.getAttribute("infopage");
System.out.println(infopage);

ArrayList downlist = (ArrayList)session.getAttribute("totallist");
	System.out.println(downlist.size());
	session.setAttribute("downlist", downlist);
	session.setAttribute("basePath", basePath);
	session.setAttribute("path", path);
	System.out.println(basePath);
	System.out.println(path);

String insertmsg = (String)session.getAttribute("insertmsg");
System.out.println(insertmsg);
String updatemsg = (String)session.getAttribute("updatemsg");
System.out.println(updatemsg);
String delmsg = (String)session.getAttribute("delmsg");
System.out.println(delmsg);
String downstate = (String)session.getAttribute("downstate");
System.out.println(downstate);
if(downstate.equals("ok"))
{
downstate = "false";
session.setAttribute("downstate", downstate);


%>
<script type="text/javascript">
window.onload = function(){
var x = "<%=basePath%>"+"downfile/ygjldown.xls";

window.location.href=x;

}
</script>
</script>
<%
} 
if((!insertmsg.equals("没有插入返回信息")) && (insertmsg != null) && (!insertmsg.equals("")))
{

%>
<script type="text/javascript"> alert("<%=insertmsg%>"); </script>
<%
insertmsg = "";
session.setAttribute("insertmsg", insertmsg);
} 
if((!updatemsg.equals("没有更新返回信息")) && (updatemsg != null) && (!updatemsg.equals("")))
{

%>

	<script type="text/javascript"> alert("<%=updatemsg%>"); </script>

<%
updatemsg = "";
session.setAttribute("updatemsg", updatemsg);
}
if((!delmsg.equals("没有删除返回信息")) && (delmsg != null) && (!delmsg.equals("")))
{

 %>
 
 <script type="text/javascript"> alert("<%=delmsg%>"); </script>
 <%
 delmsg = "";
session.setAttribute("delmsg", delmsg);
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

<style type="text/css">
	body{ background: url("admin/images/bg.gif"); font:bold; color: blue;}
	tr{border: 5px;}
    td{width:auto; text-align:center;font-size:18px;font-family:"微软雅黑";color:black}

</style>
</head>

<body>
<div style="display: block; float:left; width:800px; height:auto;  margin-right:10px;">
<jsp:include page="select.jsp"></jsp:include>


<TABLE style="BORDER-COLLAPSE: collapse" borderColor=#000000  cellPadding=1  padding-left=10px; align=left border=1>
	<tr>
		<td style="color: #FF0000">姓名</td>
		<td style="color: #FF0000">简拼</td>
		<td style="color: #FF0000">生日</td>
		<td style="color: #FF0000">家乡</td>
		<td style="color: #FF0000">身份证</td>
		<td style="color: #FF0000">工作时间</td>
		<td style="color: #FF0000">所属机构</td>
		<td style="color: #FF0000">操作</td>


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
	 
	 <tr>
	 	<td><a href="servlet/dobaseinfo?type=toinsert"  >新增员工</a></td>
	 	<td><a href="servlet/todownservlet?type=down">下载到表格</a></span></td>
	 </tr>
	 <tr>
	 <td colspan="7">
	 <jsp:include page="pagefoot.jsp"></jsp:include>
	 </td>
	 </tr>
	 </table>

	
</div>
<div style="display:block; margin-top:100px; float:left; width:300px; height:300px; ">
筛查条目数:<%=keywordnum %>
总条目数:<%=allnum %>
占比:<%=(100*keywordnum/allnum) %>%
<%

    DefaultPieDataset dpd = new DefaultPieDataset();
    
    dpd.setValue(webkeyword, 100*keywordnum/allnum);
    dpd.setValue("其它所有", 100-(100*keywordnum/allnum));
    
    
    JFreeChart chart = ChartFactory.createPieChart("筛查比例",dpd, true, false, false);
    
    String fileName = ServletUtilities.saveChartAsPNG(chart,300,300,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
    
    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
    System.out.println(url);

%>

<img src="<%= url %>" width="300" height="300">
</div>
</body>
</html>
