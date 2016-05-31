<%@page import="cc.erinyes.model.PGinfo"%>
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

<title>PG表</title>

<meta http-equiv="pragma" content="no-PGche">
<meta http-equiv="PGche-control" content="no-PGche">
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
		List PGL =(List) session.getAttribute("PGL");
		// out.print(stus.size());  
		Iterator iter = PGL.iterator();
	%>
	<table>
	<a href = "inputPG.jsp" target = "main_right">添加</a>
		<tr>
			<td>派工单代码</td>
			<td>施工单位</td>
			<td>详细内容</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>责任人</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				PGinfo PG = (PGinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=PG.getid()%></td>
			<td><%=PG.getcompany()%></td>
			<td><%=PG.getneirong()%></td>
			<td><%=PG.getbegin() %></td>
			<td><%=PG.getend()%></td>
			<td><%=PG.getname()%></td>
			<td><a href="deleteInfoServlet?id=<%=PG.getid()%>&key=PG">删除</a></td>
			<td><a href="modifyInfoServlet?id=<%=PG.getid()%>&key=PG">修改</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
