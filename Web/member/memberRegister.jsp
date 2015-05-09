<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>会员注册</title>
</head>
 
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}
if(document.form.password.value!=document.form.passwordOne.value){
window.alert("您两次输入的密码不一致，请重新输入");
return false;
}
if(document.form.password.value.length < 3 || document.form.password.value.length > 9){
window.alert("请输入3到9位密码！");
return false;
}
if(isNaN(document.form.age.value) || document.form.age.value <0  || document.form.age.value > 120){
window.alert("年龄必须在1到120之间且只能为数字");
return false;
}

if(document.form.reallyName.value.length >10){
window.alert("输入的真实姓名过长，请输入正确的姓名！");
return false;
}

if(document.form.name.value.length < 5 || document.form.name.value.length > 12){
window.alert("会员名称只能是5到12位字母或数字！");
return false;
}

if(document.form.profession.value.length >20){
window.alert("输入的职业过长，请输入正确的职业！");
return false;
}

if(document.form.question.value.length >20){
window.alert("您输入的问题过长！");
return false;
}

if(document.form.result.value.length >10){
window.alert("您输入的答案过长！");
return false;
}

if(document.form.email.value.length >20){
window.alert("输入的Email地址过长！");
return false;
}
}
<%--
function checkForm(){

if(document.form.email.value != ''){
if(!Isemail(document.form.email.value)){
alert("suru")
document.form.email.focus();
return false;
}
}
}

function Isemail(email){
var reemail=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
return(reemail.test(email));

}

--%>
</script>
<body >
<table width="100%" height="100%" boder="0" cellpadding="0" cellspacing="0">
  <tr><td width="100%" height="100%" background="../image/bg2.jpg">


<br>
<table width="452" height="100%"  border="0" align="right" cellpadding="0" cellspacing="0">
  <tr>
    <td background="../image/land1.jpg">
    <table width="450" height="300"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
  <td> 
<div align="center">
  <form name="form" method="post" action="../memberAction.do?action=0" onSubmit="return checkEmpty(form)">
    <table width="298"  border="1" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      <tr>
        <td width="105" height="35" >
        <div align="center">会员名称<br><font size="3">（字母数字）</font></div></td>
        <td width="187"><div align="center"><input onkeyup="value=value.replace(/[\W]/g,'') "onbeforepast="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" name="name" size="20"></div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">会员密码</div></td>
        <td><div align="center">
          <input type="password" name="password">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">密码确认</div></td>
        <td><div align="center">
          <input type="password" name="passwordOne">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">真实姓名</div></td>
        <td><div align="center">
          <input type="text" name="reallyName">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">年龄</div></td>
        <td><div align="center">
          <input type="text" name="age">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">职业</div></td>
        <td><div align="center">
          <input type="text" name="profession">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">Email地址</div></td>
        <td><div align="center">
          <input name="email" type="text" >
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">找回密码问题</div></td>
        <td><div align="center">
          <input type="text" name="question">
        </div></td>
      </tr>
      <tr>
        <td height="35">
        <div align="center">答案</div></td>
        <td><div align="center">
          <input type="text" name="result">
        </div></td>
      </tr>
    </table>
    <br><br><br>
    <input type="submit" name="Submit2" value="注册">&nbsp;&nbsp;
    <input type="reset" name="Submit3" value="重置">
    &nbsp;&nbsp;
    <input type="button" name="back" value="返回" onClick="javascript:history.go(-1)">
  </form>
  </td>
	</tr>
	</table>
	</td>
	</tr>
	</table>
  <p>&nbsp;  </p>
</div>
</td>
</tr>
</table>
</body>
</html>
