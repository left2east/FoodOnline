<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.ManagerForm"%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}

if(document.form.name.value.length >20){
window.alert("输入的标题太长！");
return false;
}

if(document.form.content.value.length >200){
window.alert("公告内容太长！");
return false;
}
}
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>网上订餐系统后台</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<table width="1000" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr valign="bottom">
    <td colspan="2" height="112"  background="image/banner1.jpg">       <div align="center">
   <jsp:include page="../upTwo.jsp"/>
      </div></td>
  </tr>
  
 <tr><td width="24%" height="40"><jsp:include page="../../leftManager.jsp"/>  </td></tr> 
  
  <tr>
    
    <td width="76%" height="40" bgcolor="#FFFFFF">
    <div align="center">	
	
	<table width="99%" height="30"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="#E6E6E6"><div align="center"><font size="4" color="#990000"><b>添加公告信息</b></font></div></td>
      </tr>
    </table>
<br><br>

	  <form name="form" method="post" action="afficheAction.do?action=2" onSubmit="return checkEmpty(form)">
        <table width="90%" height="243"  border="1" cellpadding="0" cellspacing="0">
          <tr>
            <td width="23%" height="30"><div align="center"><font size="4"><b>公告标题<br>(20字以内)</b></font></div></td>
            <td width="77%">&nbsp;&nbsp;&nbsp;<input name="name" type="text" size="118"></td>
          </tr>
          <tr>
            <td height="208"><div align="center"><font size="4"><b>公告内容<br>(不超过200字)</b></font></div>              </td>
            <td>&nbsp;&nbsp;
              <textarea name="content" cols="100" rows="16"></textarea></td>
          </tr>
        </table>
        <p>
          <input type="submit" name="Submit2" value="添加">&nbsp;
          <input type="reset" name="reset" value="清除">&nbsp;
          <input type="button" name="back" value="返回" onClick="javasrcipt:history.go(-1)">
        </p>
	  </form>
	  </div></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="60" colspan="2"><p align="center"><jsp:include page="../downNews.jsp"/>

</p>    </td>
  </tr>
</table>
</body>
</html>
