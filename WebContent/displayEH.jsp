<%@page import="cc.erinyes.model.EHinfo"%>
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

<title>EH表</title>

<meta http-equiv="pragma" content="no-EHche">
<meta http-equiv="EHche-control" content="no-EHche">
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
		List EHL =(List) session.getAttribute("EHL");
		// out.print(stus.size());  
		Iterator iter = EHL.iterator();
	%>
	<table>
	<a href = "inputEH.jsp" target = "main_right">添加</a>
		<tr>
			<td>出错处理单代码</td>
			<td>错误处理人</td>
			<td>对应报错单代码</td>
			<td>处理完成时间</td>
			<td>处理过程</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				EHinfo EH = (EHinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=EH.getid()%></td>
			<td><%=EH.gethandler()%></td>
			<td><%=EH.geterrid()%></td>
			<td><%=EH.getdate() %></td>
			<td><%=EH.getinfo()%></td>
			<td><a href="deleteInfoServlet?id=<%=EH.getid()%>&key=EH">删除</a></td>
			<td><a href="modifyInfoServlet?id=<%=EH.getid()%>&key=EH">修改</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
