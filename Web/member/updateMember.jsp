<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.domain.MemberForm"%>
<%MemberForm form=(MemberForm)request.getAttribute("form");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�޸Ļ�Ա��Ϣ</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ��");
return false;
}
}
if(document.form.oldPassword.value!=document.form.passwordOld.value){
window.alert("�������������ԭ���Ĳ�һ�£�����������");
return false;
}
if(document.form.password.value!=document.form.passwordOne.value){
window.alert("��������������벻һ�£�����������");
return false;
}

if(document.form.reallyName.value.length >10){
window.alert("�������ʵ������������������ȷ��������");
return false;
}

if(document.form.profession.value.length >20){
window.alert("�����ְҵ��������������ȷ��ְҵ��");
return false;
}

if(document.form.password.value.length < 3 || document.form.password.value.length > 9){
window.alert("������ӦΪ3��9λ!");
return false;
}
if(isNaN(document.form.age.value) || document.form.age.value<0 || document.form.age.value>120){
window.alert("���������1��120֮�䲢��ֻ��Ϊ����");
return false;
}

if(document.form.email.value.length >20){
window.alert("�����Email��ַ������");
return false;
}
}
</script>
<body>

<table width="1000" height="150" align="center" border="0" cellpadding="0" cellspacing="0"  background="image/banner.jpg">
  <tr>
          <td width="82%" height="106">&nbsp;</td>
         
           
 </tr>
</table>
<table width="452" height="400"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="image/xiugai.jpg">

<div align="center">
 <p>&nbsp; </p>
    <p>&nbsp; </p> 
     
     
   <br><form name="form" method="post" action="memberAction.do?action=6&id=<%=form.getId()%>" onSubmit="return checkEmpty(form)">
    <table width="400"  border="1" cellspacing="0" cellpadding="0"  bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      
      <tr>
        <td width="30%" height="40" ><div align="center"><font size="3">��Ա���ƣ�</font></div></td>
        <td width="70%"><div align="center">
        <font size="4">  <input type="hidden" name="name" value="<%=form.getName()%>"><%=form.getName()%></font></div></td>
      </tr>
      
       <tr>
        <td height="40" ><div align="center"><font size="3">�����룺</font></div></td>
        <td><div align="center"><font size="4">
          <input type="hidden" name="result" value="<%=form.getResult()%>">
          <input type="hidden" name="question" value="<%=form.getQuestion()%>">
          <input type="hidden" name="passwordOld" value="<%=form.getPassword()%>">
          <input type="password" name="oldPassword">
       </font></font></td>
      </tr>
      
      <tr>
        <td height="40" ><div align="center"><font size="3">�����룺</font></div></td>
        <td><div align="center"><font size="4">
          <input type="password" name="password" size="20"></font></div></td>
      </tr>
      
      <tr>
        <td height="40" ><div align="center"><font size="3">ȷ�����룺</font></div></td>
        <td><div align="center"><font size="4">
          <input type="password" name="passwordOne" size="20"></font>
        </div></td>
      </tr>
      
      <tr>
        <td height="40" ><div align="center"><font size="3">��ʵ������</font></div></td>
        <td><div align="center"><font size="3">
          <input type="text" size="20" name="reallyName" value="<%=form.getReallyName()%>"></font>
        </div></td>
      </tr>
      
      <tr>
        <td height="40" ><div align="center"><font size="3">���䣺</font></div></td>
        <td><div align="center"><font size="3">
          <input type="text" name="age" value="<%=form.getAge()%>"></font>
        </div></td>
      </tr>
      
      <tr>
        <td height="40" ><div align="center"><font size="3">ְҵ��</font></div></td>
        <td><div align="center"><font size="3">
          <input type="text" name="profession" value="<%=form.getProfession()%>"></font>
        </div></td>
      </tr>
      
      <tr>
        <td height="40" ><div align="center"><font size="3">Email��ַ��</font></div></td>
        <td><div align="center"><font size="3">
          <input name="email" type="text"  value="<%=form.getEmail()%>"></font>
        </div></td>
      </tr>


    </table>
    <br><br>
    <input type="submit" name="Submit2" value="�޸�">&nbsp;&nbsp;
    <input type="reset" name="Submit3" value="����">
    &nbsp;&nbsp;
   <input type="button" name="back" value="����" onClick="javascript:history.go(-1)">
  </form>
  <p>&nbsp;  </p>
</div>


<p>&nbsp;</p></td>
  </tr>
</table>
<p>&nbsp;</p>



</body>
</html>
