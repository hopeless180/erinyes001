<%@page import="cc.erinyes.model.PGinfo"%>
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
		PGinfo PG =(PGinfo) session.getAttribute("PG");
	%>
		<form action="modifyPG" method="post">
			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=green colspan=2><font color=white>派工单录入</font></td>
				</tr>
				<tr>
					<td>施工单位：</td>
					<td><input type = "text" size = 20 name = "company" value = "<%=PG.getcompany()%>"></td>
				</tr>
				<tr>
					<td>施工开始时间：</td>
					<td><input type = "text" size = 20 name = "begin" value = "<%=PG.getbegin()%>"></td>
				</tr>
				<tr>
					<td>结束时间：</td>
					<td><input type = "text" size = 20 name = "end" value = "<%=PG.getend()%>"></td>
				</tr>
				<tr>
					<td>责任人：</td>
					<td><input type = "text" size = 20 name = "name"  value = "<%=PG.getname()%>"></td>
				</tr>
				<tr>
					<td>内容：</td>
					<td><input type = "text" size = 20 name = "neirong"  value = "<%=PG.getneirong()%>"></td>
				</tr>
				<tr >
					<td align="center" colspan="2">
					<input type="hidden" name="id" value="<%=PG.getid()%>" />
					<input type="submit"  value="提交">&nbsp;&nbsp;<input type="reset"  value="重置">
					</td>
				</tr>				
			</table>
			
		</form>
	</center>
</body>
</html>
