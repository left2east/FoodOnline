<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="com.domain.GoodsForm"%>
<jsp:useBean id="goods" scope="page" class="com.dao.GoodsDao"/>
<%GoodsForm form=goods.selectOneGoods(Integer.valueOf(request.getParameter("id")));%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>餐品网购</title>
<style type="text/css">
<!--
.style1 {
	font-size: 16px;
	font-weight: bold;
	
}
-->
</style>
</head>

<body>
<table width="1000" height="150%"  border="0" align="center" cellpadding="0" cellspacing="0">

  <tr>
  <td height="100"><div align="center"><jsp:include page="topOne.jsp"/></div></td>
  </tr>
  
  <tr>
    <td height="40" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="topTwo.jsp"/></td>
  </tr>
  
   <tr><td height="680"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
        <tr>
        <td width="20%" height="638" rowspan="2" valign="top" background="image/zuocedaohangbeijing.jpg">
		   <jsp:include page="leftOne.jsp"/></td>
		   
        <td width="70%" height="40" align="center" valign="middle" background="image/link.jpg"  bgcolor="#FFFFFF">
           </td>
           
        <td width="20%" height="638" rowspan="2" valign="top" background="image/zuocedaohangbeijing.jpg">
		   <jsp:include page="left.jsp"/></td>  
      </tr>
      
      <tr>
        <td  height="613" valign="top" bgcolor="#FFFFFF">
		<br>
		<br>	<span class="style1" >第<%=request.getParameter("account")%>名</span>		<br>
		<table width="96%" height="120"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#EFEFEF" >
                <tr>
                  <td width="60%" rowspan="4" height="120"><div align="center">
                      <input name="pricture" type="image" src="<%=form.getPicture()%>" width="420" height="136">
                  </div></td>
                  <td width="40%" height="30"><div align="center"><%=form.getGoodName()%></div></td>
                </tr>
                <tr>
                  <td height="30"><div align="center"><font color="#F14D83">单价：<%=form.getNowPrice()%>元</font></div></td>
                </tr>
                <tr>
                  <td height="30"><div align="center"><%=form.getIntroduce()%></div></td>
                </tr>
                <tr>
                  <td height="30" class="linkBlack"><div align="center">
                      <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
                      <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=form.getId()%>','','width=800,height=400');">查看详细内容</a></div>
                      <%}else{%>
                      <div align="center">登录后才能购买！</div></td>
                  <%}%>
                </tr>
          </table>		</td>
      </tr>
    </table></td>
  </tr>
  <tr  bgcolor="#FFFFFF">
    <td height="100"><p align="center"><jsp:include page="downNews.jsp"/></p></td>
  </tr>
</table>
</body>
</html>
