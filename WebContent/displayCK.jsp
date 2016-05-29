<%@page import="cc.erinyes.model.CKinfo"%>
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

<title>CK表</title>

<meta http-equiv="pragma" content="no-CKche">
<meta http-equiv="CKche-control" content="no-CKche">
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
		List CKL =(List) session.getAttribute("CKL");
		// out.print(stus.size());  
		Iterator iter = CKL.iterator();
	%>
	<table>
		<tr>
			<td>出库单代码</td>
			<td>编号</td>
			<td>库存名称</td>
			<td>数量</td>
			<td>备注</td>
			<td>操作人</td>
			<td>出库时间</td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				CKinfo CK = (CKinfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=CK.getid()%></td>
			<td><%=CK.getno()%></td>
			<td><%=CK.getname()%></td>
			<td><%=CK.getquantity() %></td>
			<td><%=CK.getcontent()%></td>
			<td><%=CK.getuser()%></td>
			<td><%=CK.getdate()%></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>
