<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="com.domain.MemberForm"%>
<%java.util.Date date=new java.util.Date();%>
<jsp:useBean id="dao" scope="page" class="com.dao.MemberDao"/>
<%
String id=(String)session.getAttribute("id");
MemberForm form=dao.selectOneMember(Integer.valueOf(id));
%>
<html>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ��!");
return false;
}
}
if(isNaN(document.form.tel.value)){
window.alert("�绷����ֻ��Ϊ����!");
return false;
}

if(document.form.address.value.length >30){
window.alert("�����ַ̫��!");
return false;
}

if(document.form.bz.value.length >16){
window.alert("��ע��Ϣ̫��!");
return false;
}

}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��ʪ������</title>

<style type="text/css">
<!--
.style1 {
	color: #FF0000;
	font-weight: bold;
}
-->
</style>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<table width="1000" height="150%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="100"><div align="center"><jsp:include page="topOne.jsp"/></div></td>
  </tr>
  
  <tr>
    <td height="70" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="topTwo.jsp"/></td>
  </tr>
  
  <tr>
    <td height="680">
    <table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
      <tr>
        <td width="20%" height="638" rowspan="2" valign="top" background="image/zuocedaohangbeijing.jpg">
        <jsp:include page="leftOne.jsp"/></td>
        
        <td width="70%" height="33" align="center" valign="middle" background="image/jiezhao.jpg">&nbsp;</td>

        <td width="20%" height="638" rowspan="2" valign="top" background="image/zuocedaohangbeijing.jpg">
        <jsp:include page="left.jsp"/></td>
      </tr>
      
      <tr>
        <td valign="top"  height="613">		  <div align="center"><br>
                    <form name="form" method="post" action="cart_checkOutOrder.jsp"  onSubmit="return checkEmpty(form)">
		  <table width="68%"  border="1" cellspacing="0" cellpadding="0"  bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
            <tr>
              <td height="30" colspan="2"> <div align="center" class="style1">ע�⣺������Ҫ�����Ƿ��ύ����������ɲ���Ҫ���鷳�� </div></td>
              </tr>
			   <tr>
              <td height="30"><div align="center">�������</div></td>
              <td>&nbsp;<input type="hidden" name="number" value="<%=date.getTime()%>"><%=date.getTime()%>(���μǣ�)</td>
            </tr>
            <tr>
              <td width="24%" height="30"><div align="center">��Ա����</div></td>
              <td width="76%">&nbsp;&nbsp;<%=form.getName()%><input type="hidden" name="name" value="<%=form.getName()%>"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">��ʵ����</div></td>
              <td>&nbsp;&nbsp;<%=form.getReallyName()%><input type="hidden" name="reallyName" value="<%=form.getReallyName()%>"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">��ϵ��ַ</div></td>
              <td>&nbsp;<input type="text" name="address" size="30"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">��ϵ�绰</div></td>
              <td>&nbsp;<input type="text" name="tel" maxlength="20" size="20"></td>
            </tr>
            <tr>
              <td height="30"><div align="center">���ʽ</div></td>
              
         <!--       <td>
              <input type="radio" value="���и���">���и���&nbsp;
              <input type="radio" value="��������">��������&nbsp;
              <input type="radio" value="�ֽ�֧��">�ֽ�֧��&nbsp;             
              </td>  
              -->           
            <td>&nbsp;
			  <select name="setMoney" class="textarea">
			        <option value="">��ѡ��</option>
      <option value="���и���">���и���</option>
      <option value="��������">��������</option>
      <option value="�ֽ�֧��">�ֽ�֧��</option>
    </select>
			  </td> 
            </tr>

            <tr>
              <td height="30"><div align="center">���ͷ�ʽ</div></td>
              <td>&nbsp;<select name="post" class="textarea">
			        <option value="">��ѡ��</option>
      <option value="��ͨ�ʼ�">��ͨ�ʼ�</option>
      <option value="�ؿ�ר��">�ؿ�ר��</option>
      <option value="EMSר�ݷ�ʽ">EMSר�ݷ�ʽ</option>
    </select>
			  
			  </td>
            </tr>
            <tr>
              <td height="60"><div align="center">��ע��Ϣ<br>(16������)</div></td>
              <td>&nbsp;<textarea name="bz"></textarea></td>
            </tr>                     
          </table>  

		  <br>
              <font color="red">ȷ�Ϲ�����޷�ȡ���������Ƿ�ȷ�Ϲ���</font>
                <input type="submit" name="Submit2" value="ȷ�Ϲ���">&nbsp;
                <input type="button" name="back" value="����" onClick="javasrcipt:history.go(-1)">
              </form>
        </div>
        </td>
      </tr>
    </table>
 </td></tr>
  
  <tr bgcolor="#FFFFFF">
   <td height="100"><p align="center"><jsp:include page="downNews.jsp"/></p></td>
  </tr>
</table>
</body>
</html>
