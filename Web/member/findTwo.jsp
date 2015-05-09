<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.domain.MemberForm"%>
<%@page import="com.tool.Chinese"%>
<jsp:useBean id="dao" scope="page" class="com.dao.MemberDao"/>

<%MemberForm form=dao.selectMemberForm(Chinese.chinese(request.getParameter("name")));%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>找回密码步骤二</title>
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
  <tr><td width="100%" height="100%" background="image/bg1.jpg">


<br>
<table width="452" height="358"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td background="../image/land3.jpg">
    


<p>&nbsp;</p>
<div align="center">
  <%if(form==null||form.equals("")){%>
 <p><strong><font color="red">不存在此会员名称,请重新输入！！！</font></strong></p>
 <meta http-equiv="refresh" content="3;URL=findOne.jsp">
  <%}else{%>
  <p><strong><font size="4" color="red">密保验证</font></strong></p>
  <form name="form" method="post" action="findThree.jsp" onSubmit="return checkEmpty(form)">
    <table width="298"  border="1" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
      <tr>
        <td width="105" height="35"><div align="center">密保问题：</div></td>
        <td width="187"><div align="center"><input type="hidden" name="name" value="<%=form.getName()%>">
          <input type="hidden" name="question" value="<%=form.getQuestion()%>"><%=form.getQuestion()%>
        </div></td>
      </tr>
      
       <tr>
        <td width="105" height="35"><div align="center">答案：</div></td>
        <td width="187"><div align="center">
          <input type="text" name="result" maxlength="20" size="20">
        </div></td>
      </tr>
    </table>
    <br><br><br>
    <table width="298"  border="0" cellspacing="0" cellpadding="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF"><tr>
    <td align="right" ><input type="submit" name="Submit2" value="下一步"></td>
    <td align="center" ><input type="reset" name="Submit3" value="重置"></td>
    <td align="left" > <a href="../index.jsp"><font color="blue" size="3">返回</font></a></td>
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
