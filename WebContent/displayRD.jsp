<%@page import="cc.erinyes.model.RDinfo"%>
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

<title>RD表</title>

<meta http-equiv="pragma" content="no-RDche">
<meta http-equiv="RDche-control" content="no-RDche">
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
		List RDL =(List) session.getAttribute("RDL");
		// out.print(stus.size());  
		Iterator iter = RDL.iterator();
	%>
	<table>
	<a href = "inputRD.jsp" target = "main_right">添加</a>
		<tr>
			<td>调度表代码</td>
			<td>员工姓名</td>
			<td>工作位置</td>
			<td>生产产品的名称和规格</td>
			<td>开始时间</td>
			<td>预计结束时间</td>
			<td>调度表生成时间</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				RDinfo RD = (RDinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=RD.getid()%></td>
			<td><%=RD.getygname()%></td>
			<td><%=RD.getlocation()%></td>
			<td><%=RD.getitem() %></td>
			<td><%=RD.getbegin()%></td>
			<td><%=RD.getend()%></td>
			<td><%=RD.getdate()%></td>
			<td><a href="deleteInfoServlet?id=<%=RD.getid()%>&key=RD">删除</a></td>
			<td><a href="modifyInfoServlet?id=<%=RD.getid()%>&key=RD">修改</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
