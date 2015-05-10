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
if(document.form.account.value.length < 5 || document.form.account.value.length > 12){
window.alert("请输入5到12位管理员账号！");
return false;
}
if(document.form.password.value.length < 3 || document.form.password.value.length > 9){
window.alert("请输入3到9位密码！");
return false;
}
if(document.form.password.value!=document.form.passwordOne.value){
window.alert("您两次输入的密码不一致，请重新输入");
return false;
}
if(document.form.name.value.length >10){
window.alert("输入的姓名过长！");
return false;
}
}
</script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>餐品网上系统后台</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<table width="1000" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
 
  <tr valign="bottom">
    <td height="108" colspan="2" background="image/banner1.jpg"><div align="center">
 <jsp:include page="../upTwo.jsp"/>
    </div></td>
  </tr>
  
  <tr><td width="24%" height="40"><jsp:include page="../../leftManager.jsp"/>  </td></tr>
  
  <tr>
    
    <td width="76%" height="36" bgcolor="#FFFFFF" class="linkBlack">
    <div align="center">	
	<table width="99%" height="30"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="#E6E6E6"><div align="center"><font size="4" color="#990000"><b>添加管理员信息</b></font></div></td>
      </tr>
    </table>
<br><br>

	  <form name="form" method="post" action="managerAction.do?action=3" onSubmit="return checkEmpty(form)">
        <table width="58%"  border="1" cellspacing="0" cellpadding="0">
          <tr>
            <td width="23%" height="30"><div align="center">管理员账号<br>(英文或数字)</div></td>
            <td>&nbsp;<input onkeyup="value=value.replace(/[\W]/g,'') "onbeforepast="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" name="account" size="35"></td>
       <!--     <td width="77%">&nbsp;<input name="account" type="text" size="35"></td> -->
          </tr>
          <tr>
            <td height="30"><div align="center">密&nbsp;码</div></td>
            <td>&nbsp;<input name="password" type="password" size="35"></td>
          </tr>
          <tr>
            <td height="30"><div align="center">请再次输入密码</div></td>
            <td>&nbsp;<input name="passwordOne" type="password" size="35"></td>
          </tr>
          <tr>
            <td height="30"><div align="center">姓&nbsp;名</div></td>
            <td>&nbsp;<input name="name" type="text" size="35"></td>
          </tr>
        </table>
        <p>
          <input type="submit" name="Submit2" value="添加">&nbsp;
          <input type="reset" name="reset" value="清除">&nbsp;
          <input type="button" name="back" value="返回" onClick="javasrcipt:history.go(-1)">
	      </p>
	  </form>
	  <p><br>
	  </p>
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	  <p>&nbsp;        </p>
    </div></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="60" colspan="2"><p align="center"><jsp:include page="../downNews.jsp"/>

</p>    </td>
  </tr>
</table>
</body>
</html>
