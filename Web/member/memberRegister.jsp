<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��Աע��</title>
</head>
 
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ��");
return false;
}
}
if(document.form.password.value!=document.form.passwordOne.value){
window.alert("��������������벻һ�£�����������");
return false;
}
if(document.form.password.value.length < 3 || document.form.password.value.length > 9){
window.alert("������3��9λ���룡");
return false;
}
if(isNaN(document.form.age.value) || document.form.age.value <0  || document.form.age.value > 120){
window.alert("���������1��120֮����ֻ��Ϊ����");
return false;
}

if(document.form.reallyName.value.length >10){
window.alert("�������ʵ������������������ȷ��������");
return false;
}

if(document.form.name.value.length < 5 || document.form.name.value.length > 12){
window.alert("��Ա����ֻ����5��12λ��ĸ�����֣�");
return false;
}

if(document.form.profession.value.length >20){
window.alert("�����ְҵ��������������ȷ��ְҵ��");
return false;
}

if(document.form.question.value.length >20){
window.alert("����������������");
return false;
}

if(document.form.result.value.length >10){
window.alert("������Ĵ𰸹�����");
return false;
}

if(document.form.email.value.length >20){
window.alert("�����Email��ַ������");
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
        <div align="center">��Ա����<br><font size="3">����ĸ���֣�</font></div></td>
        <td width="187"><div align="center"><input onkeyup="value=value.replace(/[\W]/g,'') "onbeforepast="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" name="name" size="20"></div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">��Ա����</div></td>
        <td><div align="center">
          <input type="password" name="password">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">����ȷ��</div></td>
        <td><div align="center">
          <input type="password" name="passwordOne">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">��ʵ����</div></td>
        <td><div align="center">
          <input type="text" name="reallyName">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">����</div></td>
        <td><div align="center">
          <input type="text" name="age">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">ְҵ</div></td>
        <td><div align="center">
          <input type="text" name="profession">
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">Email��ַ</div></td>
        <td><div align="center">
          <input name="email" type="text" >
        </div></td>
      </tr>
      <tr>
        <td height="35" >
        <div align="center">�һ���������</div></td>
        <td><div align="center">
          <input type="text" name="question">
        </div></td>
      </tr>
      <tr>
        <td height="35">
        <div align="center">��</div></td>
        <td><div align="center">
          <input type="text" name="result">
        </div></td>
      </tr>
    </table>
    <br><br><br>
    <input type="submit" name="Submit2" value="ע��">&nbsp;&nbsp;
    <input type="reset" name="Submit3" value="����">
    &nbsp;&nbsp;
    <input type="button" name="back" value="����" onClick="javascript:history.go(-1)">
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
