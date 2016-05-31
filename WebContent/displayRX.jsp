<%@page import="cc.erinyes.model.RXinfo"%>
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

<title>RX表</title>

<meta http-equiv="pragma" content="no-RXche">
<meta http-equiv="RXche-control" content="no-RXche">
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
		List RXL =(List) session.getAttribute("RXL");
		// out.print(stus.size());  
		Iterator iter = RXL.iterator();
	%>
	<table>
	<a href = "inputRX.jsp" target = "main_right">添加</a>
		<tr>
			<td>员工编号</td>
			<td>姓名</td>
			<td>工作位置</td>
			<td>状态</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				RXinfo RX = (RXinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=RX.getid()%></td>
			<td><%=RX.getname()%></td>
			<td><%=RX.getlocation()%></td>
			<td><%=RX.getstatus()%></td>
			<td><a href="deleteInfoServlet?id=<%=RX.getid()%>&key=RX">删除</a></td>
			<td><a href="modifyInfoServlet?id=<%=RX.getid()%>&key=RX">修改</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
