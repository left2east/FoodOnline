<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.BigTypeForm"%>
<%@page import="com.domain.SmallTypeForm"%>



<jsp:useBean id="big" scope="page" class="com.dao.BigTypeDao"/>
<jsp:useBean id="small" scope="page" class="com.dao.SmallTypeDao"/>

 

 
<%
List bigList=big.selectBig();
String id=(String)request.getAttribute("bigId");
if(id==null){id="1";}

Integer bigId=Integer.valueOf(id);
List smallList=small.selectOneBigId(bigId);
%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ�գ�");
return false;
}
}
if(isNaN(document.form.nowPirce.value)){
window.alert("�۸�ֻ��Ϊ���֣�");
return false;
}

if(document.form.nowPirce.value < 0 || document.form.nowPirce.value > 10000){
window.alert("�۸������1��10000֮�䣡");
return false;
}

if(document.form.name.value.length > 10){
window.alert("��������ƹ�����");
return false;
}
if(document.form.madel.value.length > 10){
window.alert("������ͺ�̫����");
return false;
}
if(document.form.ratedPower.value.length > 10){
window.alert("����Ĺ���̫����");
return false;
}
if(document.form.from.value.length > 10){
window.alert("������������̫�������������ƣ�");
return false;
}
if(document.form.volume.value.length > 10){
window.alert("���������������󳤶ȣ�");
return false;
}

if(document.form.color.value.length > 10){
window.alert("�������ɫ̫����");
return false;
}

if(document.form.introduce.value.length > 20){
window.alert("��Ʒ���������������ƣ�");
return false;
}
}
function ChangeItem(){
var big=form.big.value;
window.location.href="goodsAction.do?action=2&bigId="+big;
}
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>���϶���ϵͳ��̨</title>

<style type="text/css">
<!--
.style1 {	color: #990000;
	font-weight: bold;
}
-->
</style>
</head>

<body background="image/beijingtu.jpg">
<table width="1000" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr valign="bottom">
    <td height="108" colspan="2" background="image/banner1.jpg"> <div align="center"><jsp:include page="../upOne.jsp"/> </div>      <div align="center">
   <jsp:include page="../upTwo.jsp"/>
      </div></td>
  </tr>
  
  <tr><td width="24%" height="40"><jsp:include page="../../leftManager.jsp"/> </td></tr>
  
  <tr>
    
    <td width="76%" height="318" bgcolor="#FFFFFF"><div align="center">

       <table width="99%" height="30"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="#E6E6E6"><div align="center" class="style1"><font size="4"><b>��Ӳ�Ʒ��Ϣ</b></font></div></td>
      </tr>
    </table>
      <br>
	  <form action="goodsAction.do?action=3" method="post" enctype="multipart/form-data"  name="form" onSubmit="return checkEmpty(form)" >
        <table width="90%"  border="1" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20%" height="26">&nbsp;&nbsp;������Ʒ����</td>
            <td width="31%">&nbsp;
            <select name="big" onChange="ChangeItem()">
            <option value="">��ѡ��</option>
                   <%for(int i=0;i<bigList.size();i++){
                   BigTypeForm bigForm=(BigTypeForm)bigList.get(i);%>
           <option value="<%=bigForm.getId()%>" <%if(bigId.equals(bigForm.getId())){out.println("selected");}%>>
		           <%=big.selectName(bigForm.getId())%></option>
                                                    <%}%>
            </select></td>
            
            <td width="20%">&nbsp;&nbsp;����Ʒ��</td>
            <td width="31%">&nbsp;
            <select name="small">
            <option value="">��ѡ��</option>
                  <%for(int i=0;i<smallList.size();i++){
                  SmallTypeForm smallForm=(SmallTypeForm)smallList.get(i);%>
           <option value="<%=smallForm.getId()%>"><%=smallForm.getSmallName()%></option>
                                                     <%}%>
            </select></td>
          </tr>
          
          <tr>
            <td height="25">&nbsp;&nbsp;��Ʒ����(������10��)</td>
            <td>&nbsp;<input name="name"  type="text" size="40"></td>
            <td height="27">&nbsp;&nbsp;��Ʒ��ɫ(10������)</td>
            <td>&nbsp;<input name="color" type="text" size="40"></td>
          </tr>
          <tr>
            <td height="27">&nbsp;&nbsp;��Ʒ����(1~10000֮��)</td>
            <td>&nbsp;<input name="nowPirce" type="text" size="40"></td>
            <td>&nbsp;&nbsp;��ʼ���ؼ�</td>
            <td>&nbsp;<input name="freePirce" type="hidden" size="20" value="0">0Ԫ</td>
          </tr>
          <tr>           
            <td>&nbsp;&nbsp;��Ʒ�ͺ�(10������)</td>
            <td>&nbsp;<input name="madel"  type="text" size="40"></td>
            <td>&nbsp;&nbsp;��������(������20��)</td>
            <td>&nbsp;<input name="from"  type="text" size="40"></td> 
          </tr>
          <tr>           
            <td>&nbsp;&nbsp;��Ʒ����(10������)</td>
            <td>&nbsp;<input name="volume" type="text" size="40"></td>
            <td>&nbsp;&nbsp;��Ʒ����(10������)</td>
            <td>&nbsp;<input name="ratedPower" type="text" size="40"></td> 
          </tr>
          <tr>
            <td height="28">&nbsp;&nbsp;��Ʒ����(������20��)</td>
            <td colspan="3">&nbsp;<input name="introduce" type="text" size="70"></td>
          </tr>
		  
        </table>
        <p align="center">
          <input type="submit" name="Submit2" value="���">&nbsp;
          <input type="reset" name="reset" value="���">&nbsp;
          <input type="button" name="back" value="����" onClick="javasrcipt:history.go(-1)">
        </p>
	  </form>
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	  <p>&nbsp;</p>
	  </div></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="60" colspan="2"><p align="center"><jsp:include page="../downNews.jsp"/>

</p>    </td>
  </tr>
</table>
</body>
</html>
