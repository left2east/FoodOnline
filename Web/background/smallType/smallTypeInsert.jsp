<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.BigTypeForm"%>
<jsp:useBean id="big" scope="page" class="com.dao.BigTypeDao"/>

<%List list=big.selectBig();%>
<script language="javascript">
function checkEmpty(form){
for(i=0;i<form.length;i++){
if(form.elements[i].value==""){
alert("表单信息不能为空");
return false;
}
}

if(document.form.name.value.length >10){
window.alert("请输入10字以内的名称！");
return false;
}
}
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>网上订餐系统后台</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<table width="1000" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
  
  <tr valign="bottom">
    <td height="108" colspan="2" background="image/banner1.jpg"><div align="center">
 <jsp:include page="../upTwo.jsp"/>
    </div></td>
  </tr>
  
  <tr><td width="24%" height="40"><jsp:include page="../../leftManager.jsp"/>  </td></tr>
  
  <tr>
    
    <td width="76%" height="36" bgcolor="#FFFFFF">
	
    <div align="center">	
		<table width="99%" height="30"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td bgcolor="#E6E6E6"><div align="center"><font size="4" color="#990000"><b>添加品牌信息</b></font></div></td>
      </tr>
    </table>
<br><br>
	

	  <form action="smallTypeAction.do?action=2" method="post"  name="form" onSubmit="return checkEmpty(form)" >
        <table width="90%" height="60"  border="1" cellpadding="0" cellspacing="0">
          <tr>
            <td width="25%" height="30"><div align="center">请选择餐品类型</div></td>
            <td width="75%">&nbsp;&nbsp;&nbsp;
			
              <select name="bigId" >
              <option value="">请选择</option>
			<%for(int i=0;i<list.size();i++){
                          BigTypeForm form=(BigTypeForm)list.get(i);
                          %>
                <option value="<%=form.getId()%>"><%=form.getBigName()%></option>
                          <%}%>
			  </select>

			  </td>
          </tr>
           <tr>
            <td width="25%" height="30"><div align="center">品牌名称</div></td>
            <td width="75%">&nbsp;&nbsp;&nbsp;&nbsp;<input name="name" type="text" size="50"></td>
          </tr>
        </table>
        <p>
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
