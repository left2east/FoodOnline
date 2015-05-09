<%@ page contentType="text/html; charset=gb2312"%>

<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.BigTypeForm"%>
<%@page import="com.domain.SmallTypeForm"%>
<%@page import="com.domain.GoodsForm"%>

<%@page import="com.domain.HummodetypeForm"%>
<%@page import="com.domain.OperattypeForm"%>

<jsp:useBean id="big" scope="page" class="com.dao.BigTypeDao"/>
<jsp:useBean id="small" scope="page" class="com.dao.SmallTypeDao"/>
 
<jsp:useBean id="hummode" scope="page" class="com.dao.HummodetypeDao"/>
<jsp:useBean id="operat" scope="page" class="com.dao.OperattypeDao"/>


<%
GoodsForm goodsForm=(GoodsForm)request.getAttribute("form");

%>

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

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>加湿器网购系统后台</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<table width="1000" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">

  <tr valign="bottom">
    <td height="108" colspan="2" background="image/banner1.jpg" ><div align="center">
 <jsp:include page="../upTwo.jsp"/>
    </div></td>
  </tr>
 
  <tr> <td width="24%" height="40"><jsp:include page="../../leftManager.jsp"/>  </td></tr>

  <tr>

    <td width="76%" height="36" bgcolor="#FFFFFF" class="linkBlack">
    <div align="center">	
	       <table width="99%" height="30"  border="0" cellpadding="0" cellspacing="0">
      <tr >
        <td bgcolor="#E6E6E6" ><div align="center"><font size="4" color="#990000"><b>查看加湿器的详细情况</b></font></div></td>
      </tr>
    </table><br><br>
	

        <table width="90%" height="209"  border="1" cellpadding="0" cellspacing="0">
          <tr>
            <td width="20%" height="26">&nbsp;&nbsp;所属加湿类型</td>
            <td width="31%">&nbsp;&nbsp;<%=big.selectName(goodsForm.getBig())%></td>
            <td width="20%">&nbsp;&nbsp;所属品牌</td>
            <td width="31%">&nbsp;&nbsp;<%=small.selectName(goodsForm.getSmall())%></td>
          </tr>
          
           <tr>
            <td width="20%" height="26">&nbsp;&nbsp;加湿方式</td>
            <td width="31%">&nbsp;&nbsp;<%=hummode.selectName(goodsForm.getHummode())%></td>
            <td width="20%">&nbsp;&nbsp;操作方式</td>
            <td width="31%">&nbsp;&nbsp;<%=operat.selectName(goodsForm.getOperat())%></td>
           </tr>
          
          <tr>
            <td height="26">&nbsp;&nbsp;加湿器名称</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getName()%></td>
            <td>&nbsp;&nbsp;生产厂家</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getFrom()%></td>
          </tr>
          
          <tr>
            <td height="26">&nbsp;&nbsp;加湿器颜色</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getColor()%></td>
            <td>&nbsp;&nbsp;加湿器型号</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getMadel()%></td>
          </tr>
          
          <tr>
            <td height="26">&nbsp;&nbsp;加湿器容量</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getVolume()%></td>
            <td>&nbsp;&nbsp;加湿器功率</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getRatedPower()%></td>
          </tr>
          
          <tr>
            <td height="26">&nbsp;&nbsp;加湿器定价</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getNowPrice()%>元</td>
            <td>&nbsp;&nbsp;特价</td>
            <td>&nbsp;&nbsp;<%=goodsForm.getFreePrice()%>元</td>
          </tr>
          <tr>
            <td height="26">&nbsp;&nbsp;加湿器描述</td>
            <td colspan="3">&nbsp;&nbsp;<%=goodsForm.getIntroduce()%></td>
          </tr>
          <tr>
            <td height="79">&nbsp;&nbsp;图片</td>
            <td colspan="3">&nbsp;&nbsp;<input name="imageField" type="image" src="<%=goodsForm.getPicture()%>" width="140" height="126"></td>
          </tr>
        </table>
        <table width="90%"  border="0" cellspacing="0" cellpadding="0">
          <tr><%String mark=goodsForm.getMark().toString();%>
            <td width="65%" height="29" align="right" class="linkRed">			
			  <%if(mark.equals("0")){%>
			
			<%}else{%>
			<a href="goodsAction.do?action=11&id=<%=goodsForm.getId()%>&mark=0">删除特价加湿器信息</a>
			<%}%>
			&nbsp;&nbsp;</td>
           
		    <td class="linkRed" width="22%" align="right">
                        <%if(mark.equals("0")){%>
              <a href="goodsAction.do?action=10&id=<%=goodsForm.getId()%>">设置特价加湿器</a>
              <%}else{%>
              <a href="goodsAction.do?action=10&id=<%=goodsForm.getId()%>">调整特价加湿器</a>
              <%}%>
&nbsp;&nbsp;</td>
           <!--  <td width="13%"> <a href="javascript:history.back();">返回</a></td> -->
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
