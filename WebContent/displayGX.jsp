<%@page import="cc.erinyes.model.GXinfo"%>
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

<title>GX表</title>

<meta http-equiv="pragma" content="no-GXche">
<meta http-equiv="GXche-control" content="no-GXche">
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
		List GXL =(List) session.getAttribute("GXL");
		// out.print(stus.size());  
		Iterator iter = GXL.iterator();
	%>
	<table>
		<tr>
			<td>生产工序代码</td>
			<td>产品</td>
			<td>详细内容</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				GXinfo GX = (GXinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=GX.getid()%></td>
			<td><%=GX.getname()%></td>
			<td><%=GX.getinfo()%></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
