<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.AdvertForm"%>
<jsp:useBean id="dao" scope="page" class="com.dao.AdvertDao"/>
<%AdvertForm form=dao.selectOneAdvert(Integer.valueOf(request.getParameter("id")));%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="css/css1.css">
<title></title>
</head>

<body >
<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
 
       <tr>
			<td height="150"><div align="center"><font size="7" color="red" face="隶书"><%=form.getName()%></font></div></td>
		</tr>
		
		
<tr><td width="100%" height="100%" background="../image/guanggao.jpg">
<table width="68%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="82%" height="70%" align="center"><font size="6" color="#FF7F00"><%=form.getContent()%></font> </td>
  </tr>

 

<tr><td width="82%" height="15%" align="center" class="linkLeixing">
     <a href="#" onClick="window.open('<%=form.getAdvertAddress()%>','');"><font color="blue" size="3">传送门：<%=form.getAdvertAddress()%></font></a>
</td></tr>


 <tr>
 <td width="82%" height="10%" align="center">活动开启时间:<%=form.getCreaTime()%></td>
 </tr>

<tr><td height="10%" align="center">
<input type="button" name="wclose" value="关闭" onClick="window.close()">
</td>
</tr>
</table>

</td></tr></table>

</body>
</html>
