<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="com.domain.OrderDetailForm"%>
<%@ page import="com.domain.OrderForm"%>
<%@ page import="com.domain.MemberForm"%>
<jsp:useBean id="order" scope="page" class="com.dao.OrderDao"/>
<jsp:useBean id="orderDetail" scope="page" class="com.dao.OrderDetailDao"/>
<jsp:useBean id="goodsDao" scope="page" class="com.dao.GoodsDao"/>
<jsp:useBean id="member" scope="page" class="com.dao.MemberDao"/>
<%String id=(String)session.getAttribute("id");%>
<%MemberForm memberForm=member.selectOneMember(Integer.valueOf(id));%>
<%List orderList=order.selectOrderHead(memberForm.getName());%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>餐品网购</title>
</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>
<table width="1000" height="150%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="100"><div align="center">
    <jsp:include page="topOne.jsp"/></div>    </td>
  </tr>
  <tr>
    <td height="40" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="topTwo.jsp"/></td>

  </tr>
  <tr>
    <td height="680" bgcolor="#FFFFFF" class="linkBlack"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0" >
      <tr>
        <td width="20%" height="638" rowspan="2" valign="top"  background="image/zuocedaohangbeijing.jpg">
		<jsp:include page="leftOne.jsp"/></td>
		
        <td width="70%" height="35" align="center" valign="middle" background="image/chakandingdan.jpg">&nbsp;</td>
        
        <td width="20%" height="638" rowspan="2" valign="top"  background="image/zuocedaohangbeijing.jpg">
		<jsp:include page="left.jsp"/></td>
      </tr>
      <tr>
        <td valign="top"  height="613">
		  <div align="center"><br>
		      <br>
              <%if(orderList.size()==0){%>
     没有订货信息
     <%}else{%>
          </div>
		  <table width="99%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

       <tr align="center">
            <td width="15%" height="21">编号</td>

            <td width="15%">电话</td>
            <td width="21%">地址</td>

            <td width="24%">订货时间</td>
            <td width="13%">是否出货</td> <td width="12%">操作</td>
          </tr>
      <%
      for(int orderNumber=0;orderNumber<orderList.size();orderNumber++){
        OrderForm orderForm=(OrderForm)orderList.get(orderNumber);
        %>
          <tr align="center">
            <td height="24"><%=orderForm.getNumber()%></td>

            <td><%=orderForm.getTel()%></td>
            <td><%=orderForm.getAddress()%></td>

            <td><%=orderForm.getCreaTime()%></td>
            <td><%if(orderForm.getSign().equals("0")){%>
            否<%}else{%>是<%}%>
            </td>
             <td><a href="cart_detail.jsp?number=<%=orderForm.getNumber()%>">查看明细</a></td>
          </tr>

          <%}%>
        </table>
      <div align="center">

		   <br>
	      <%if(request.getParameter("number")!=null){%>

	      <br>
	      订单详细情况
	      <br>
<br>

      <table width="89%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">

        <tr align="center">
          <td width="25%" height="21">编号</td>
          <td width="24%">餐品名称</td>
          <td width="28%">餐品价格</td>
          <td width="23%">餐品数量</td>
        </tr>  <%
        float sum=0;
            List orderDetailList=orderDetail.selectOrderDetailNumber(request.getParameter("number"));
        for(int orderDetailNumber=0;orderDetailNumber<orderDetailList.size();orderDetailNumber++){
         OrderDetailForm orderDetailForm=(OrderDetailForm)orderDetailList.get(orderDetailNumber);

         sum=sum+orderDetailForm.getPrice()*orderDetailForm.getNumber();
         %>
        <tr  align="center" >
          <td height="21"><%=orderDetailForm.getOrderNumber()%></td>
          <td><%=goodsDao.selectOneGoods(orderDetailForm.getGoodsId()).getGoodName()%></td>
          <td><%=orderDetailForm.getPrice()%>元</td>
          <td><%=orderDetailForm.getNumber()%></td>
        </tr>
        <%}%>
      </table>

	   <table width="89%"  border="0" cellspacing="0" cellpadding="0">
         <tr>
           <td height="24"><div align="right">总金额：<%=sum%>元</div></td>
         </tr>
       </table> <%}%>
	   </div>
      <%}%>		</td>
      </tr>
    </table></td>
  </tr>
<tr bgcolor="#FFFFFF">
    <td height="100" ><p align="center"><jsp:include page="downNews.jsp"/>

   </td>
  </tr>
</table>
</body>
</html>
