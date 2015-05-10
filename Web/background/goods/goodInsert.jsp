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
alert("表单信息不能为空！");
return false;
}
}
if(isNaN(document.form.nowPirce.value)){
window.alert("价格只能为数字！");
return false;
}

if(document.form.nowPirce.value < 0 || document.form.nowPirce.value > 10000){
window.alert("价格必须在1到10000之间！");
return false;
}

if(document.form.name.value.length > 10){
window.alert("输入的名称过长！");
return false;
}
if(document.form.madel.value.length > 10){
window.alert("输入的型号太长！");
return false;
}
if(document.form.ratedPower.value.length > 10){
window.alert("输入的功率太长！");
return false;
}
if(document.form.from.value.length > 10){
window.alert("输入生产厂商太长，可以输入简称！");
return false;
}
if(document.form.volume.value.length > 10){
window.alert("输入的容量超过最大长度！");
return false;
}

if(document.form.color.value.length > 10){
window.alert("输入的颜色太长！");
return false;
}

if(document.form.introduce.value.length > 20){
window.alert("餐品描述超过字数限制！");
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
<title>网上订餐系统后台</title>

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
        <td bgcolor="#E6E6E6"><div align="center" class="style1"><font size="4"><b>添加餐品信息</b></font></div></td>
      </tr>
    </table>
      <br>
	  <form action="goodsAction.do?action=3" method="post" enctype="multipart/form-data"  name="form" onSubmit="return checkEmpty(form)" >
        <table width="90%"  border="1" cellspacing="0" cellpadding="0">
          <tr>
            <td width="20%" height="26">&nbsp;&nbsp;所属餐品类型</td>
            <td width="31%">&nbsp;
            <select name="big" onChange="ChangeItem()">
            <option value="">请选择</option>
                   <%for(int i=0;i<bigList.size();i++){
                   BigTypeForm bigForm=(BigTypeForm)bigList.get(i);%>
           <option value="<%=bigForm.getId()%>" <%if(bigId.equals(bigForm.getId())){out.println("selected");}%>>
		           <%=big.selectName(bigForm.getId())%></option>
                                                    <%}%>
            </select></td>
            
            <td width="20%">&nbsp;&nbsp;所属品牌</td>
            <td width="31%">&nbsp;
            <select name="small">
            <option value="">请选择</option>
                  <%for(int i=0;i<smallList.size();i++){
                  SmallTypeForm smallForm=(SmallTypeForm)smallList.get(i);%>
           <option value="<%=smallForm.getId()%>"><%=smallForm.getSmallName()%></option>
                                                     <%}%>
            </select></td>
          </tr>
          
          <tr>
            <td height="25">&nbsp;&nbsp;餐品名称(不超过10字)</td>
            <td>&nbsp;<input name="name"  type="text" size="40"></td>
            <td height="27">&nbsp;&nbsp;餐品颜色(10字以内)</td>
            <td>&nbsp;<input name="color" type="text" size="40"></td>
          </tr>
          <tr>
            <td height="27">&nbsp;&nbsp;餐品定价(1~10000之间)</td>
            <td>&nbsp;<input name="nowPirce" type="text" size="40"></td>
            <td>&nbsp;&nbsp;初始化特价</td>
            <td>&nbsp;<input name="freePirce" type="hidden" size="20" value="0">0元</td>
          </tr>
          <tr>           
            <td>&nbsp;&nbsp;餐品型号(10字以内)</td>
            <td>&nbsp;<input name="madel"  type="text" size="40"></td>
            <td>&nbsp;&nbsp;生产厂商(不超过20字)</td>
            <td>&nbsp;<input name="from"  type="text" size="40"></td> 
          </tr>
          <tr>           
            <td>&nbsp;&nbsp;餐品容量(10字以内)</td>
            <td>&nbsp;<input name="volume" type="text" size="40"></td>
            <td>&nbsp;&nbsp;餐品功率(10字以内)</td>
            <td>&nbsp;<input name="ratedPower" type="text" size="40"></td> 
          </tr>
          <tr>
            <td height="28">&nbsp;&nbsp;餐品描述(不超过20字)</td>
            <td colspan="3">&nbsp;<input name="introduce" type="text" size="70"></td>
          </tr>
		  
        </table>
        <p align="center">
          <input type="submit" name="Submit2" value="添加">&nbsp;
          <input type="reset" name="reset" value="清除">&nbsp;
          <input type="button" name="back" value="返回" onClick="javasrcipt:history.go(-1)">
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
