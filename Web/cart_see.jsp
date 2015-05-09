<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="com.domain.SellGoodsForm"%>
<jsp:useBean id="dao" scope="page" class="com.dao.GoodsDao"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>加湿器购买</title>

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
    <td height="680"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="20%" height="638" rowspan="2" valign="top"  background="image/zuocedaohangbeijing.jpg">
		<jsp:include page="leftOne.jsp"/></td>
		
        <td width="70%" height="35" align="center" valign="middle" background="image/gouwuche.jpg">&nbsp;</td>

        <td width="20%" height="638" rowspan="2" valign="top"  background="image/zuocedaohangbeijing.jpg">
		<jsp:include page="left.jsp"/></td>
      </tr>
      <tr>
        <td  height="613" valign="top" bgcolor="#FFFFFF">

<div align="center"><br>
              <%if(session.getAttribute("cart")==null){%>
          <font color="red" size="5"> 您还没有购物！</font>
          </div>
          <br><br><br><br>
           <div align="right" class="linkgouwu">
          <a href="index.jsp">前往购物！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
          
           <%}else{%>
          </div>
          
        <form method="post" action="cart_modify.jsp" name="form">
		  <table width="96%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#819BBC" bordercolorlight="#FFFFFF">
          <tr>
            <td width="16%" height="28"><div align="center">序号</div></td>
            <td width="23%"><div align="center">加湿器名称</div></td>
            <td width="22%"><div align="center">价格</div></td>
            <td width="22%"><div align="center">数量</div></td>
            <td width="17%"><div align="center">总金额</div></td>
          </tr>
            <%
            float sum=0;
        Vector cart=(Vector)session.getAttribute("cart");
        for(int i=0;i<cart.size();i++){
          SellGoodsForm form=(SellGoodsForm)cart.elementAt(i);
          sum=sum+form.number*form.price;
        
        %>
          <tr>
            <td height="28"><div align="center"><%=i+1%></div></td>
            <td><div align="center"><%=dao.selectOneGoods(new Integer(form.ID)).getGoodName()%></div></td>
            <td><div align="center"><%=form.price%>元</div></td>
            <td><div align="center"><input name="num<%=i%>" maxlength="5" size="5" type="text"  value="<%=form.number%>" onBlur="check(this.form)"></div></td>
            <td><div align="center"><%=form.number*form.price%>元</div></td>
          </tr>
		     <script language="javascript">
<!--
			function check(myform){
				if(isNaN(myform.num<%=i%>.value) || myform.num<%=i%>.value.indexOf('.',0)!=-1){
					alert("请不要输入非法字符!");myform.num<%=i%>.focus();return;}
				if(myform.num<%=i%>.value==""){
					alert("你还没有输入要买的数量!");myform.num<%=i%>.focus();return;}
					
				if(myform.num<%=i%>.value < 1 || myform.num<%=i%>.value > 10000){
					alert("只能购买1到10000件!");myform.num<%=i%>.focus();return;}	
			    
				myform.submit();
			}
-->               
		</script>
          <%}%>
        </table>

        </form>

<table width="100%" height="52" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr align="center" valign="middle">
		<td height="10">&nbsp;		</td>
        <td width="24%" height="10" colspan="-3" align="left">&nbsp;</td>
		</tr>
      <tr align="center" valign="middle">
        <td height="21" class="tableBorder_B1">&nbsp;</td>
        <td height="21" colspan="-3" align="left" >合计总金额：￥<%=sum%></td>
      </tr>
      <tr align="center" valign="middle">
        <td height="21" colspan="2" class="linkBlack">
        <span><a href="index.jsp">继续购物</a> | <a href="cart_checkOut.jsp">去收银台结账</a> | <a href="cart_clear.jsp">清空购物车</a> | <a href="#">修改数量</a></span></td>
        </tr>
</table>

<%}%></td>
      </tr>
    </table></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="100"><p align="center"><jsp:include page="downNews.jsp"/></p></td>
  </tr>
</table>
</body>
</html>
