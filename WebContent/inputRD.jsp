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
		<form action="inputRD" method="post">
			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=green colspan=2><font color=white>人员调度表录入</font></td>
				</tr>
				<tr>
					<td>员工姓名：</td>
					<td><input type = "text" size = 20 name = "ygname"></td>
				</tr>
				<tr>
					<td>生产产品名称及规格：</td>
					<td><input type = "text" size = 20 name = "item"></td>
				</tr>
				<tr>
					<td>工作位置：</td>
					<td><input type = "text" size = 20 name = "location"></td>
				</tr>
				<tr>
					<td>开始时间：</td>
					<td><input type = "text" size = 20 name = "begin"></td>
				</tr>
				<tr>
					<td>预计结束时间：</td>
					<td><input type = "text" size = 20 name = "end"></td>
				</tr>
				<tr>
					<td>调度表生成时间</td>
					<td><input type = "text" size = 20 name = "date"></td>
				</tr>
				<tr ><td align="center" colspan="2" ><input type="submit"  value="提交">&nbsp;&nbsp; <input
				type="reset"  value="重置"></td></tr>				
			</table>
			
		</form>
	</center>
</body>
</html>
