<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main_left.jsp' starting page</title>
    
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
  <ul>
  	生产管理模块
  	<li><a href = "user/queryDD" target = "main_right">生产订单</a></li>
  	<li><a href = "user/queryPG" target = "main_right">派工单</a></li>
  	<li><a href = "user/queryMS" target = "main_right">领料单</a></li>
  	<li><a href = "user/queryCA" target = "main_right">质检单</a></li>
  	<li><a href = "user/queryRK" target = "main_right">入库单</a></li>
  	<li><a href = "user/queryCK" target = "main_right">出库单</a></li>
  </ul>
  <ul>
  	调度模块
  	<li><a href = "user/queryRX" target = "main_right">员工信息表</a></li>
  	<li><a href = "user/queryGX" target = "main_right">生产工序</a></li>
  	<li><a href = "user/queryRD" target = "main_right">人员调度表</a></li>
  </ul>
  <ul>
  	防错模块
  	<li><a href = "user/queryERR" target = "main_right">出错申报表</a></li>
  	<li><a href = "user/queryEH" target = "main_right">错误处理单</a></li>
  </ul>
  <a href="user/exitServlet" target="_top">退出</a><br>
  </body>
</html>
