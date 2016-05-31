<%@page import="cc.erinyes.model.MSinfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>MS表</title>

<meta http-equiv="pragma" content="no-MSche">
<meta http-equiv="MSche-control" content="no-MSche">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<jsp:include page="isLogin.jsp"></jsp:include>
<body>
	<%
		List MSL =(List) session.getAttribute("MSL");
		// out.print(stus.size());  
		Iterator iter = MSL.iterator();
	%>
	<table>
	<a href = "inputMS.jsp" target = "main_right">添加</a>
		<tr>
			<td>领料单代码</td>
			<td>仓库</td>
			<td>原料编号</td>
			<td>数量</td>
			<td>领取日期</td>
			<td>操作人</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				MSinfo MS = (MSinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=MS.getid()%></td>
			<td><%=MS.getrepository()%></td>
			<td><%=MS.getmid()%></td>
			<td><%=MS.getquantity()%></td>
			<td><%=MS.getdate()%></td>
			<td><%=MS.getname() %></td>
			<td><a href="deleteInfoServlet?id=<%=MS.getid()%>&key=MS">删除</a></td>
			<td><a href="modifyInfoServlet?id=<%=MS.getid()%>&key=MS">修改</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
