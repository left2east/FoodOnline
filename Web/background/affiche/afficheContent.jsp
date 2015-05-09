<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.AfficheForm"%>
<%AfficheForm affiche=(AfficheForm)request.getAttribute("affiche");%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
}
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>加湿器网购系统后台</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<table width="1000" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
 
  <tr valign="bottom">
    <td height="112" colspan="2"  background="image/banner1.jpg"><div align="center">
 <jsp:include page="../upTwo.jsp"/>
    </div></td>
  </tr>
  <tr> <td width="24%" height="40"><jsp:include page="../../leftManager.jsp"/>  </td></tr>
  
  <tr>
   
    <td width="76%" height="36" bgcolor="#FFFFFF" class="linkBlack">
    <div align="center">	
	<table width="99%" height="30"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="#E6E6E6"><div align="center"><font size="4" color="#990000"><b>查看公告信息</b></font></div></td>
      </tr>
    </table>
<br><br>
	
	

	 
        <table width="90%" height="243"  border="1" cellpadding="0" cellspacing="0">
          <tr>
            <td width="23%" height="30"><div align="center"><font size="4"><b>公告标题</b></font></div></td>
            <td width="77%">&nbsp;<%=affiche.getName()%></td>
          </tr>
            <tr>
            <td width="23%" height="208"><div align="center"><font size="4"><b>公告内容</b></font></div></td>
            <td width="77%">&nbsp;<%=affiche.getContent()%></td>
          </tr>
        </table>
    
	    <table width="82%" height="30"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td>&nbsp;</td>
            <td class="linkRed"><div align="right"><a href="javascript:history.go(-1)">返回</a></div></td>
          </tr>
        </table><br><br>
    </div></td>
    
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="60" colspan="2"><p align="center"><jsp:include page="../downNews.jsp"/>

</p>    </td>
  </tr>
</table>
</body>
</html>
