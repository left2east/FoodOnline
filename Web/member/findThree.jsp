<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.domain.MemberForm"%>
<%@page import="com.tool.Chinese"%>
<jsp:useBean id="dao" scope="page" class="com.dao.MemberDao"/>
<%
String name=Chinese.chinese(request.getParameter("name")).trim();
String result=Chinese.chinese(request.getParameter("result")).trim();
MemberForm form=dao.selectFind(name,result);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�һ����벽����</title>
</head>
 <link href="../css/css1.css" rel="stylesheet" type="text/css">
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
}
</script>
<body>

<table width="100%" height="100%" boder="0" cellpadding="0" cellspacing="0">
  <tr><td width="100%" height="100%" background="image/bg1.jpg">


<br>
<table width="452" height="358"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="../image/land3.jpg">
    


<p>&nbsp;</p>
<div align="center">
  <%if(form==null||form.equals("")){%>
 <p><strong><font color="red">�𰸲���ȷ,���������룡</font>����</strong></p>
 <meta http-equiv="refresh" content="3;URL=findTwo.jsp?name=<%=name%>">
  <%}else{%>
  <p><strong><font size="4" color="red">����������</font></strong></p>
  <form name="form" method="post" action="findFour.jsp?id=<%=form.getId()%>" onSubmit="return checkEmpty(form)">
    <table width="298"  border="1" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      <tr>
        <td width="105" height="35"><div align="center">������:</div></td>
        <td width="187"><div align="center">
          <input type="password" name="password" maxlength="20" size="20">
        </div></td>
      </tr>
      
       <tr>
        <td width="105" height="35"><div align="center">����ȷ��:</div></td>
        <td width="187"><div align="center">
                 <input type="password" name="passwordOne" maxlength="20" size="20">
        </div></td>
      </tr>
    </table>
    <br><br><br>
    <table width="298"  border="0" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF"><tr>
    <td align="right" ><input type="submit" name="Submit2" value="�ύ"></td>
    <td align="center" ><input type="reset" name="Submit3" value="����"></td>
    <td align="left" > <a href="../index.jsp"><font color="blue" size="3">����</a></td>
    
    </tr></table>
  </form>
<%}%>

</div>


<p>&nbsp;</p>
	<p>&nbsp;</p></td>
  </tr>
</table>
<p>&nbsp;</p>


</td></tr>
</table>

</body>
</html>
