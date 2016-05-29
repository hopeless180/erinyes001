<%@page import="cc.erinyes.model.CAinfo"%>
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

<title>CA表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
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
		List CAL =(List) session.getAttribute("CAL");
		// out.print(stus.size());  
		Iterator iter = CAL.iterator();
	%>
	<table>
		<tr>
			<td>质检单代码</td>
			<td>质检项目</td>
			<td>质检库存名称</td>
			<td>质检员</td>
			<td>质检日期</td>
			<td>质检结论</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				CAinfo CA = (CAinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=CA.getid()%></td>
			<td><%=CA.getitem()%></td>
			<td><%=CA.getname()%></td>
			<td><%=CA.getanalyst() %></td>
			<td><%=CA.getdate()%></td>
			<td><%=CA.getconclusion()%></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
