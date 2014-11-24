<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	int pageNumber = (int) session.getAttribute("pageNumber");
	int totalPages = (int) session.getAttribute("totalPages");
	int pageSize = (int) session.getAttribute("pageSize");
	int totalPosts = (int) session.getAttribute("totalPosts");

	System.out.println(pageNumber);
	System.out.println(totalPages);
	System.out.println(pageSize);
	System.out.println(totalPosts);
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'pagefoot.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function gotoSelectedPage()
{
	var x = document.getElementById("navigatorForm");
	//alert("Original action: " + x.action)
	
	x.submit();
}
</script>
</head>

<body>
	<form action="servlet/dopageservlet" method="get" id="navigatorForm">

		<a href="servlet/dopageservlet?pageNumber=1">首页</a>

		<%
						if (pageNumber > 1) {
					%>
		<a href="servlet/dopageservlet?pageNumber=${pageNumber-1}">上一页</a>
		<%
						}
					%>
		跳转到第 <select name="pageNumber" onchange="gotoSelectedPage();">

			<%
							for (int i = 1; i <= totalPages; i++) {
						%>

			<%
							if (i == pageNumber) {
						%>
			<option value="<%=i%>" selected="selected"><%=i%></option>
			<%
							} else {
						%>

			<option value="<%=i%>"><%=i%></option>


			<%
							}
							}
						%>
		</select>页

		<%
						if (pageNumber < totalPages) {
					%>
		<a href="servlet/dopageservlet?pageNumber=${pageNumber+1}">下一页</a>
		<%
						} else {
					%>
		<a href="servlet/dopageservlet?pageNumber=${totalPages}">末页</a>
		<%
						}
					%>
	</form>
</body>
</html>
