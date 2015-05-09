<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>找回密码步骤一</title>
</head>
 <link href="../css/css1.css" rel="stylesheet" type="text/css">
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
<body>
<table width="100%" height="100%" boder="0" cellpadding="0" cellspacing="0">
  <tr><td width="100%" height="100%" background="../image/bg1.jpg">


<br>
<table width="452" height="358"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="../image/land3.jpg">
    
    
<p>&nbsp;</p>
<div align="center">
  <p><strong><font size="4" color="red">输入会员账号</font></strong></p>
  <form name="form" method="post" action="findTwo.jsp" onSubmit="return checkEmpty(form)">
    <table width="298"  border="1" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      <tr>
        <td width="105" height="35" ><div align="center">会员账号：</div></td>
        <td width="187"><div align="center">
          <input type="text" name="name" maxlength="20" size="20">
        </div></td>
      </tr>

    </table>
    <br><br><br>
    <table width="298"  border="0" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF"><tr>
    <td align="right" ><input type="submit" name="Submit2" value="下一步"></td>
    <td align="center" ><input type="reset" name="Submit3" value="重置"></td>
    <td align="left" > <a href="../index.jsp"><font color="blue" size="3">返回</a></td>
    </tr></table>
  </form>
  <p>&nbsp;  </p>
</div>


<p>&nbsp;</p></td>
  </tr>
</table>
<p>&nbsp;</p>

  </td></tr>
</table>

</body>
</html>
