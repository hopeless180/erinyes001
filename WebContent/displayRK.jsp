<%@page import="cc.erinyes.model.RKinfo"%>
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

<title>RK表</title>

<meta http-equiv="pragma" content="no-RKche">
<meta http-equiv="RKche-control" content="no-RKche">
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
		List RKL =(List) session.getAttribute("RKL");
		// out.print(stus.size());  
		Iterator iter = RKL.iterator();
	%>
	<table>
	<a href = "inputRK.jsp" target = "main_right">添加</a>
		<tr>
			<td>入库单代码</td>
			<td>编号</td>
			<td>库存名称</td>
			<td>数量</td>
			<td>备注</td>
			<td>操作人</td>
			<td>入库时间</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				RKinfo RK = (RKinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=RK.getid()%></td>
			<td><%=RK.getno()%></td>
			<td><%=RK.getname()%></td>
			<td><%=RK.getquantity() %></td>
			<td><%=RK.getcontent()%></td>
			<td><%=RK.getuser()%></td>
			<td><%=RK.getdate()%></td>
			<td><a href="deleteInfoServlet?id=<%=RK.getid()%>&key=RK">删除</a></td>
			<td><a href="modifyInfoServlet?id=<%=RK.getid()%>&key=RK">修改</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
