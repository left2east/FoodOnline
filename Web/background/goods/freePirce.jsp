<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.BigTypeForm"%>
<%@page import="com.domain.SmallTypeForm"%>
<%@page import="com.domain.GoodsForm"%>



<jsp:useBean id="big" scope="page" class="com.dao.BigTypeDao"/>
<jsp:useBean id="small" scope="page" class="com.dao.SmallTypeDao"/>


<%
GoodsForm goodsForm=(GoodsForm)request.getAttribute("form");

%>

<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("����Ϣ����Ϊ��");
return false;
}
}
if(isNaN(document.form.free.value)){
window.alert("�۸�ֻ��Ϊ����");
return false;
}
if(document.form.free.value==document.form.now.value){
window.alert("�������ؼ۲�Ʒ�ļ۸�Ӧ����ԭ���ļ۸��ǵȼ۵ģ����������룡����");
return false;
}
if(document.form.free.value-document.form.now.value>0){
window.alert("�������ؼ۲�Ʒ�ļ۸�Ӧ�ñ�ԭ���ļ۸�ߣ����������룡����");
return false;
}

if(document.form.free.value==0){
window.alert("�۸���Ϊ0�����������룡����");
return false;
}
}

</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��Ʒ����ϵͳ��̨</title>
</head>

<body>
<table width="1000" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr valign="bottom">
    <td height="116" colspan="2" background="image/banner1.jpg">     <div align="center">
   <jsp:include page="../upTwo.jsp"/>
      </div></td>
  </tr>
  
  <tr><td width="24%" height="40"><jsp:include page="../../leftManager.jsp"/> </td></tr>
  
  <tr>
    
    <td width="76%" height="318" bgcolor="#FFFFFF" class="linkBlack">
    <div align="center"><br>	
	       <table width="99%" height="30"  border="0" cellpadding="0" cellspacing="0">
      <tr >
        <td bgcolor="#E6E6E6" ><div align="center"><font size="4" color="#990000"><b>�����ؼ۲�Ʒ</b></font></div></td>
      </tr>
    </table>
	

      <br><br>  <form name="form" method="post" action="goodsAction.do?action=11&id=<%=goodsForm.getId()%>&mark=1" onSubmit="return checkEmpty(form)">
        <table width="90%" height="233"  border="1" cellpadding="0" cellspacing="0">
          <tr>
            <td width="20%" height="26">&nbsp;&nbsp;��������</td>
            <td width="31%">&nbsp;&nbsp;<%=big.selectName(goodsForm.getBigId())%></td>
            <td width="20%">&nbsp;&nbsp;��������</td>
            <td width="31%">&nbsp;&nbsp;<%=small.selectName(goodsForm.getSmallId())%></td>
          </tr>
          

          
          <tr>
            <td height="26">&nbsp;&nbsp;��Ʒ����</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getGoodName()%></td>
            <td>&nbsp;&nbsp;��������</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getGoodFrom()%></td>
          </tr>

                   
          <tr>
            <td height="26">&nbsp;&nbsp;��Ʒ����</td>
            <td>&nbsp;&nbsp;<input name="now" type="hidden" value="<%=goodsForm.getNowPrice()%>"><%=goodsForm.getNowPrice()%>Ԫ</td>
            <td>&nbsp;&nbsp;�Ƿ��ؼ�</td>
            <td>&nbsp;&nbsp;<%if(goodsForm.getMark().toString().equals("0")){%>��<%}else{%>��<%}%></td>
          </tr>
          <tr>
            <td height="23">&nbsp;&nbsp;��Ʒ����</td>
            <td >&nbsp;&nbsp;<%=goodsForm.getIntroduce()%></td>
		    <td>&nbsp;&nbsp;�ؼۼ۸�</td>
            <td>
            &nbsp;
              <input name="free" type="text" size="12" >
                 <input type="submit" name="Submit" value="�ύ">
            
           </td>
          </tr>
          <tr>
            <td height="79">&nbsp;&nbsp;��ƷͼƬ</td>
            <td colspan="3">&nbsp;&nbsp;<input name="imageField" type="image" src="<%=goodsForm.getPicture()%>" width="140" height="126"></td>
          </tr>
        </table>  </form>              
        <table width="90%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="87%" height="29" align="right">&nbsp;&nbsp;&nbsp;</td>
            <td width="13%" class="linkRed"> <a href="javascript:history.back();">���ز�Ʒ��Ϣ</a></td>
          </tr>
        </table>
     

	  </div></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="60" colspan="2"><p align="center"><jsp:include page="../downNews.jsp"/>

</p>    </td>
  </tr>
</table>
</body>
</html>
