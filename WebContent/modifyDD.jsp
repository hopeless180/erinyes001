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

<title>My JSP 'inputstuinfo.jsp' starting page</title>

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
		DDinfo DD =(DDinfo) session.getAttribute("DD");
	%>
	<center>
		<form action="modifyDD" method="post">
			<table bgColor="#c0c0c0">
				<tr>
					<td align="center" bgcolor=green colspan=2><font color=white>生产订单录入</font></td>
				</tr>
				<tr>
					<td>订购物品：</td>
					<td><input type = "text" size = 20 name = "name" value = "<%=DD.getname()%>"></td>
				</tr>
				<tr>
					<td>创建人：</td>
					<td><input type = "text" size = 20 name = "creator" value = "<%=DD.getcreator()%>"></td>
				</tr>
				<tr>
					<td>数量：</td>
					<td><input type = "text" size = 20 name = "quantity" value = "<%=DD.getquantity() %>"></td>
				</tr>
				<tr>
					<td>单位成本：</td>
					<td><input type = "text" size = 20 name = "cost" value = "<%=DD.getcost()%>"></td>
				</tr>
				<tr>
					<td>订单状态：</td>
					<td><select name="status" size=2 multiple="multiple">
							<option>已完成</option>
							<option>未完成</option>
							<option>在未来很长时间内无法完成</option>
					</select></td>
				</tr>
				<tr valign="top">
					<td>备注：</td>
					<td><textarea rows=3 cols=20 name="content" value = "<%=DD.getcontent()%>"></textarea></td>
				</tr>
				<tr >
					<td align="center" colspan="2">
					<input type="hidden" name="id" value="<%=DD.getid()%>" />
					<input type="submit"  value="提交">&nbsp;&nbsp;<input type="reset"  value="重置">
					</td>
				</tr>			
			</table>
			
		</form>
	</center>
</body>
</html>
