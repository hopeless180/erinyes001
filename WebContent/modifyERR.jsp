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
	<%
		ERRinfo ERR =(ERRinfo) session.getAttribute("ERR");
	%>
		<form action="modifyERR" method="post">
			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=green colspan=2><font color=white>报错单修改</font></td>
				</tr>
				<tr>
					<td>错误发现人：</td>
					<td><input type = "text" size = 20 name = "finder" value = "<%=ERR.getfinder()%>"></td>
				</tr>
				<tr>
					<td>错误产品及规格：</td>
					<td><input type = "text" size = 20 name = "name" value = "<%=ERR.getname()%>"></td>
				</tr>
				<tr>
					<td>发生错误时间：</td>
					<td><input type = "text" size = 20 name = "date" value = "<%=ERR.getdate()%>"></td>
				</tr>
				<tr>
					<td>错误描述：</td>
					<td><input type = "text" size = 200 name = "info" value = "<%=ERR.getinfo()%>"></td>
				</tr>
				<tr>
					<td>错误状态：</td>
					<td><input type = "text" size = 20 name = "status" value = "<%=ERR.getstatus()%>"></td>
				</tr>
				<tr >
					<td align="center" colspan="2">
					<input type="hidden" name="id" value="<%=ERR.getid()%>" />
					<input type="submit"  value="提交">&nbsp;&nbsp;<input type="reset"  value="重置">
					</td>
				</tr>	
			</table>
			
		</form>
	</center>
</body>
</html>
