<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.iamsee.valuebean.postname" %>
<%@ page import="com.iamsee.toolbean.DBpostname" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList postnamelist = (ArrayList)session.getAttribute("postnamelist");
System.out.println(postnamelist.size());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'select.jsp' starting page</title>

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
	<form action="servlet/dopageservlet" method="get">
		姓名: <input type="text" style="height: 23px; " id="selectname" name="selectname">
		部门: <select id="condition" name="condition" style="width: 200px;">
			<%
						if (postnamelist == null || postnamelist.size() == 0) {
					%>
			<option value="">没有获取到postnamelist</option>
			<%
						} else {
							%>
			<option value="缺省">所有部门</option>
			<%
							
							for (int i = 0; i < postnamelist.size(); i++) {
								postname pn = (postname) postnamelist.get(i);
					%>

			<option value="<%=pn.getPostname()%>"><%=pn.getPostname()%>
			</option>
			<%
						}
						}
					%>

		</select><input type="submit" value="筛选" style="height: 25px; ">



	</form>


</body>
</html>
