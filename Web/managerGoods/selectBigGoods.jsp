<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.GoodsForm" %>
<%@page import="com.domain.SmallTypeForm" %>
<%List bigList=(List)request.getAttribute("list");%>
<%List smallList=(List)request.getAttribute("smallList");%>
<%
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*4;//开始条数
int over=(number+1)*4;//结束条数
int count=pageNumber-over;//还剩多少条记录

if(count<=0){
  over=pageNumber;
  }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>餐品网购购书</title>

</head>
 <link href="css/css.css" rel="stylesheet" type="text/css">
<body>

<table width="1000" height="150%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="100" ><div align="center">
    <jsp:include page="../topOne.jsp"/></div>    </td>
  </tr>
  <tr>
    <td height="70" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="../topTwo.jsp"/></td>

  </tr>
  <tr>
    <td height="680" class="linkBlack" bgcolor="#FFFFFF"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="20%" height="638" rowspan="3" valign="top" background="image/zuocedaohangbeijing.jpg">
		<jsp:include page="../leftOne.jsp"/></td>
		
        <td width="70%" height="35" align="center" valign="middle" background="image/daohang.jpg"><jsp:include page="../topThree.jsp"/></td>

       <td width="20%" height="638" rowspan="3" valign="top" background="image/zuocedaohangbeijing.jpg">
		<jsp:include page="../left.jsp"/></td>
      </tr>
      <tr>
        <td height="25" align="center" valign="middle">
<%if(smallList.size()==0){%>没有餐品品牌<%}else{%>
    <table width="99%" height="21"  border="1"  bgcolor="#DAD9D9" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr align="center">
        <%for(int small=0;small<smallList.size();small++){
            SmallTypeForm smallForm=(SmallTypeForm)smallList.get(small);
            %>
            <td width="537"><a href="goodsAction.do?action=13&big=<%=request.getParameter("big")%>&small=<%=smallForm.getId()%>&id=<%=smallForm.getBigId()%>"><%=smallForm.getSmallName()%></a></td>
         <%}%>
          </tr>
        </table>
<%}%>

		</td>
      </tr>
      <tr>
        <td height="588" align="center" valign="top">
<%if(bigList.size()==0){%><br><br><br><br>没有餐品的信息<br><br><br><br><%}else{%>
           <%
          

              for(int i=start;i<over;i++)
              {
                GoodsForm bigForm=(GoodsForm)bigList.get(i);
                %>
<br>
		<table width="96%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
          <tr>
            <td width="60%" rowspan="4" height="120"><input name="pricture<%=i%>" type="image" src="<%=bigForm.getPicture()%>" width="420" height="138"></td>
            <td width="40%" height="30"><div align="center"><%=bigForm.getGoodName()%></div></td>
          </tr>
          <tr>
            <td height="30"><div align="center">
            <%if(bigForm.getMark().toString().equals("0")){%>
              单价：<%=bigForm.getNowPrice()%>元
            <%}else{%>
             <font color="#FF0000"> 特价：<%=bigForm.getFreePrice()%>元</font>
            <%}%>
            </div></td>
          </tr>
          <tr>
            <td height="30"><div align="center"><%=bigForm.getIntroduce()%></div></td>
          </tr>
          <tr>
            <td height="30"> <div align="center">  <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
              <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=bigForm.getId()%>','','width=800,height=400');">查看详细内容</a>
				
				    <%}else{%>
				   登录后才能购买
			    
				   <%}%>
			    </div></td>
          </tr>
        </table>
		<%}}%><br>
        <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
          <tr align="center">
            <td width="13%">共为<%=maxPage%>页</td>
            <td width="16%">共有<%=pageNumber%>条记录</td>
            <td width="14%">当前为第<%=number+1%>页</td>
            <td width="19%"><%if((number+1)==1){%>
      上一页
        <%}else{%>
        <a href="goodsAction.do?action=12&big=<%=request.getParameter("big")%>&i=<%=number-1%>">上一页</a></td>
            <%}%>
            <td width="18%"><%if(maxPage<=(number+1)){%>
      下一页
        <%}else{%>
        <a href="goodsAction.do?action=12&big=<%=request.getParameter("big")%>&i=<%=number+1%>">下一页</a></td>
            <%}%>
           
          </tr>
        </table>
</td>
      </tr>
    </table></td>
  </tr>
 <tr bgcolor="#FFFFFF">
    <td height="100" ><p align="center"><jsp:include page="../downNews.jsp"/>

   </td>
  </tr>
</table>
</body>
</html>
