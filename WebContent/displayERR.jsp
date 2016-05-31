<%@page import="cc.erinyes.model.ERRinfo"%>
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

<title>ERR表</title>

<meta http-equiv="pragma" content="no-ERRche">
<meta http-equiv="ERRche-control" content="no-ERRche">
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
		List ERRL =(List) session.getAttribute("ERRL");
		// out.print(stus.size());  
		Iterator iter = ERRL.iterator();
	%>
	<table>
	<a href = "inputERR.jsp" target = "main_right">添加</a>
		<tr>
			<td>报错单代码</td>
			<td>错误发现人</td>
			<td>错误产品及规格</td>
			<td>产生错误时间</td>
			<td>错误描述</td>
			<td>状态</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				ERRinfo ERR = (ERRinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=ERR.getid()%></td>
			<td><%=ERR.getfinder()%></td>
			<td><%=ERR.getname()%></td>
			<td><%=ERR.getdate() %></td>
			<td><%=ERR.getinfo()%></td>
			<td><%=ERR.getstatus()%></td>
			<td><a href="deleteInfoServlet?id=<%=ERR.getid()%>&key=ERR">删除</a></td>
			<td><a href="modifyInfoServlet?id=<%=ERR.getid()%>&key=ERR">修改</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
