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

<title></title>

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
	<center>
		<form action="inputRK" method="post">
			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=green colspan=2><font color=white>入库信息表录入</font></td>
				</tr>
				<tr>
					<td>库存名称：</td>
					<td><input type = "text" size = 20 name = "name"></td>
				</tr>
				<tr>
					<td>库存编号：</td>
					<td><input type = "text" size = 20 name = "no"></td>
				</tr>
				<tr>
					<td>数量：</td>
					<td><input type = "text" size = 20 name = "quantity"></td>
				</tr>
				<tr>
					<td>操作人：</td>
					<td><input type = "text" size = 20 name = "user"></td>
				</tr>
				<tr>
					<td>入库时间：</td>
					<td><input type = "text" size = 20 name = "date"></td>
				</tr>
				<tr valign="top">
					<td>备注：</td>
					<td><textarea rows=3 cols=20 name="content"></textarea></td>
				</tr>
				<tr ><td align="center" colspan="2" ><input type="submit"  value="提交">&nbsp;&nbsp; <input
				type="reset"  value="重置"></td></tr>				
			</table>
			
		</form>
	</center>
</body>
</html>
