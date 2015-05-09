<%@ page language="java" import="java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menu.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <table>
   <tr><td><a href="index.jsp" target="center">会员设置</a></td></tr>
   <tr><td><a href="add.jsp" target="center">公告信息设置</a></td></tr>
   
   </table>
   <table>
   <tr>
   <td>
   <marquee width="200" direction="up" style="text-align:right;" onmouseout="this.start()" onmousemove="this.stop()">
   123<br>
   456<br>
   </marquee>
   </td>
   </tr>
   </table>
  </body>
</html>
