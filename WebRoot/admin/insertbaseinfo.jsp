<%@page import="com.iamsee.valuebean.baseinfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@page contentType="text/html;  charset=utf-8"%>
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
<style type="text/css">
body {
	background: url("admin/images/bg.gif");
	font: bold;
	color: blue;
}

tr {
	border: 5px;
}

td {
	width: auto;
	text-align: center;
	font-size: 18px;
	font-family: "微软雅黑";
	color: black
}
</style>
</head>

<body>
	<div>信息提交</div>
	<div>
		<form action="servlet/dobaseinfo" method="get">
			<table>
				<tr>
					<td>类型:</td>
					<td><input readonly="true" name="type" value="insert"></td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="name" value=""></td>
				</tr>
				<tr>
					<td>简拼：</td>
					<td><input type="text" name="shortname" value=""></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><input type="text" name="sex" value=""></td>
				</tr>
				<tr>
					<td>生日：</td>
					<td><input type="text" name="birth" value=""></td>
				</tr>
				<tr>

					<td>家乡：</td>
					<td><input type="text" name="hometowndes" value=""></td>
				</tr>
				<tr>
					<td>身份证：</td>
					<td><input type="text" name="idcard" value=""></td>
				</tr>
				<tr>
					<td>工作时间：</td>
					<td><input type="text" name="worktime" value=""></td>
				</tr>
				<tr>
					<td>所属部门：</td>
					<td><input type="text" name="postname" value=""></td>
				</tr>
				<tr>

					<td><input type="submit" value="提交信息"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>