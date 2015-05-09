

<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.GoodsForm" %>
<html>
<head>
<%List newList =(List)request.getAttribute("list");%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>显示新加湿器上架</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<table width="1000" height="150%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="100"><div align="center">
    <jsp:include page="../topOne.jsp"/></div> </td>
  </tr>
  <tr>
    <td height="40" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="../topTwo.jsp"/></td>

  </tr>
  <tr>
    <td height="680"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="20%" height="638" rowspan="2" valign="top" background="image/zuocedaohangbeijing.jpg">
		<jsp:include page="../leftOne.jsp"/></td>
		
        <td width="70%" height="50" align="center" valign="middle" background="image/xinshu.jpg" bgcolor="#FFFFFF"><div align="left">&nbsp;</div></td>
      
      <td width="20%" height="638" rowspan="2" valign="top" background="image/zuocedaohangbeijing.jpg">
		<jsp:include page="../left.jsp"/></td>
      </tr>
      <tr bgcolor="#FFFFFF">
	 
        <td valign="top"  height="700">
		
		&nbsp;

  <div align="left">
		        <%
              int now=4;
              if(newList.size()<4){
              now=newList.size();
              }
             
              for(int i=0;i<now;i++)
              {
                GoodsForm newGoods=(GoodsForm)newList.get(i);
                %>
		    </div>
			 
			 <table width="99%" height="163"  border="2" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"   >
               <tr>
                 <td height="159" bordercolor="#666666" >
                   <table width="96%" height="120"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#EFEFEF" >
                     <tr>
                       <td width="60%" rowspan="4" height="120"><div align="center">
                           <input name="pricture<%=i%>" type="image" src="<%=newGoods.getPicture()%>" width="420" height="138">
                       </div></td>
                       <td width="40%" height="30"><div align="center"><%=newGoods.getName()%></div></td>
                     </tr>
                     <tr>
                       <td height="30"><div align="center"><font color="#F14D83">单价：<%=newGoods.getNowPrice()%>元</font></div></td>
                     </tr>
                     <tr>
                       <td height="30"><div align="center"><%=newGoods.getIntroduce()%></div></td>
                     </tr>
                     <tr>
                       <td height="30" class="linkBlack"><div align="center">
                           <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
                           <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=newGoods.getId()%>','','width=800,height=400');">查看详细内容</a></div>
                           <%}else{%>
                           <div align="center">登录后才能购买</div></td>
                       <%}%>
                     </tr>
                 </table></td>
               </tr>
             </table>
			 <br> <%}%><br>
           <table width="99%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                  <!-- <td class="linkRed"><div align="right"><a href="#" onClick="javasrcipt:history.go(-1);">返回</a></div></td>  -->
              </tr>
            </table>
 
	      <div align="center"></div></td>
      </tr>
    </table></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="100"><p align="center"><jsp:include page="../downNews.jsp"/></p></td>
  </tr>
</table>
</body>
</html>
