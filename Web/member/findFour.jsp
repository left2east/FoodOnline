<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.domain.MemberForm"%>
<%@page import="com.tool.Chinese"%>
<jsp:useBean id="dao" scope="page" class="com.dao.MemberDao"/>
<%
String password=Chinese.chinese(request.getParameter("password").trim());
Integer id=Integer.valueOf(request.getParameter("id"));
boolean change=dao.updatePassword(password,id);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�һ����벽����</title>
</head>
 <link href="../css/css1.css" rel="stylesheet" type="text/css">

<body>


<br>
<table width="452" height="358"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="../image/land3.jpg">


<p>&nbsp;</p>
<div align="center"><font color="red">
  <p><strong>
    <%if(change){%>
    �����޸ĳɹ���
  <%}else{%>
  �����޸�ʧ�ܣ�
  <%}%>
  </strong></p>
<meta http-equiv="refresh" content="3;URL=../index.jsp">
</font></div>


<p>&nbsp;</p>
	<p>&nbsp;</p></td>
  </tr>
</table>
<p>&nbsp;</p>


</body>
</html>
