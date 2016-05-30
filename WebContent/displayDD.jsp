<%@page import="cc.erinyes.model.DDinfo"%>
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

<title>显示订单表</title>

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
		List DDL =(List) session.getAttribute("DDL");
		// out.print(stus.size());  
		Iterator iter = DDL.iterator();
	%>
	<table>
		<a href = "inputDD.jsp" target = "main_right">添加</a>
		<tr>
			<td>订单代码</td>
			<td>订购物品</td>
			<td>订单创建人</td>
			<td>订购数量</td>
			<td>单位成本（元）</td>
			<td>总价</td>
			<td>订单状态</td>
			<td>备注</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				DDinfo DD = (DDinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=DD.getid()%></td>
			<td><%=DD.getname()%></td>
			<td><%=DD.getcreator()%></td>
			<td><%=DD.getquantity() %></td>
			<td><%=DD.getcost()%></td>
			<td><%=DD.gettotal()%></td>
			<td><%=DD.getstatus()%></td>
			<td><%=DD.getcontent()%></td>
			<td><a href="deleteInfoServlet?id=<%=DD.getid()%>&key=DD">删除</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
