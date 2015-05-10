<%@ page contentType="text/html; charset=gb2312"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.GoodsForm"%>
<jsp:useBean id="big" scope="page" class="com.dao.BigTypeDao"/>
<jsp:useBean id="small" scope="page" class="com.dao.SmallTypeDao"/>
<jsp:useBean id="hummode" scope="page" class="com.dao.HummodetypeDao"/>
<jsp:useBean id="operat" scope="page" class="com.dao.OperattypeDao"/>
<%
List list=(List)request.getAttribute("list");
int number=Integer.parseInt((String)request.getAttribute("number"));
int maxPage=Integer.parseInt((String)request.getAttribute("maxPage"));
int pageNumber=Integer.parseInt((String)request.getAttribute("pageNumber"));
int start=number*6;//开始条数
int over=(number+1)*6;//结束条数
int count=pageNumber-over;//还剩多少条记录
if(count<=0){
  over=pageNumber;
  }
%>
 <script Language="JavaScript">
 function deleteType(date) {
  if(confirm("确定要删除吗？")){
    window.location="goodsAction.do?action=6&id="+date;
	}
  }
 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>网上订餐系统后台</title>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);
//-->
</script>
<style type="text/css">
<!--
.style1 {
	color: #990000;
	font-weight: bold;
}
-->
</style>

</head>

<body >

<!-- 
<div id="Layer1" style="position:absolute; left:300px; top:164px; width:700px; height:23px; z-index:1" class="linkBlack">
  <div align="left"><a href="goodsAction.do?action=0" >餐品信息查询</a>&nbsp;&nbsp;<a href="bigTypeAction.do?action=0">餐品类型查询</a>&nbsp;&nbsp;
  <a href="smallTypeAction.do?action=0">品牌查询</a>&nbsp;&nbsp;<a href="hummodetypeAction.do?action=0" >餐品方式查询</a>&nbsp;&nbsp;
  <a href="operattypeAction.do?action=0" >操作方式查询</a>&nbsp;&nbsp;<a href="javascript:history.go(-1)">返回</a>&nbsp;&nbsp;</div>
</div>
 -->
 
<table width="1000" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr valign="bottom">
    <td colspan="2" background="image/banner1.jpg"  height="108">     <div align="center">
   <jsp:include page="../upTwo.jsp"/>
      </div></td>
  </tr>
  
  <tr><td width="24%" height="40"><jsp:include page="../../leftManager.jsp"/> </td></tr>
  
  <tr>
    
    <td width="76%" bgcolor="#FFFFFF">    <div align="center">
      <table width="99%" height="30"  border="0" cellpadding="0" cellspacing="0">
      <tr >
        <td bgcolor="#E6E6E6" ><div align="center"><font size="4" color="#990000"><b>餐品信息</b></font></div></td>
      </tr>
    </table><br>
    <table width="60%" height="16"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="25%" class="linkLeixing"><div align="center"><a href="bigTypeAction.do?action=0">餐品类型查询</a></div></td>
        <td width="25%" class="linkLeixing"><div align="center"><a href="smallTypeAction.do?action=0">品牌查询</a></div></td>
        <!-- <td class="linkBlack2"><div align="center"><a href="goodsAction.do?action=0" >餐品信息查询</a></div></td>  -->
        <td width="25%" class="linkLeixing"><div align="center"><a href="hummodetypeAction.do?action=0" >餐品方式查询</a></div></td>
        <td width="25%" class="linkLeixing"><div align="center"><a href="operattypeAction.do?action=0" >操作方式查询</a></div></td>
       <!-- <td width="8%" class="linkRed"><div align="right"><a href="javascript:history.go(-1)">返回</a></div></td> -->
      </tr>
    </table>
    <br>
	  <table width="90%"  border="1" cellspacing="0" cellpadding="0">
        <tr>
          <td width="12%" height="25"><div align="center">数据编号</div></td>
          <td width="16%"><div align="center">餐品名称</div></td>
          <td width="12%"><div align="center">餐品类型</div></td>
          <td width="12%"><div align="center">品牌</div></td>
          <td width="12%"><div align="center">是否特价</div></td>
           <td width="12%"><div align="center">餐品方式</div></td>
          <td width="12%"><div align="center">操作方式</div></td>
          <td width="12%"><div align="center">操作</div></td>
        </tr>
		     <%for(int i=start;i<over;i++){
            GoodsForm form=(GoodsForm)list.get(i);

  %>
        <tr>
          <td height="25"><div align="center"><%=form.getId()%></div></td>
          <td class="linkBlack"><div align="center"><a href="<%=form.getPicture()%>" target="_blank"><%=form.getGoodName()%></a></div></td>

          <td class="linkBlack"><div align="center"><a href="goodsAction.do?action=9&big=<%=form.getBigId()%>"><%=big.selectName(form.getBigId())%></a></div></td>

          <td class="linkBlack"><div align="center"><a href="goodsAction.do?action=8&small=<%=form.getSmallId()%>"><%=small.selectName(form.getSmallId())%></a></div></td>
          <td class="linkBlack"><div align="center"><a href="goodsAction.do?action=7&mark=<%=form.getMark()%>"><%if(form.getMark().toString().equals("0")){%>否<%}else{%>是<%}%></a></div></td>
          
          
          <td class="linkBlack"><div align="center"><a href="goodsAction.do?action=5&id=<%=form.getId()%>">详细信息</a>&nbsp;&nbsp;
		  <a href="javascript:deleteType(<%=form.getId()%>)">删除</a>

		 
		  </div></td>
          <%}%>  </tr>
      </table>
	  <br>
	  <table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td width="13%">共为<%=maxPage%>页</td>
          <td width="16%">共有<%=pageNumber%>条记录</td>
          <td width="14%">当前为第<%=number+1%>页</td>
          <td width="19%" class="linkBlack"><%if((number+1)==1){%>  
	  上一页  
        <%}else{%>
		
		<a href="goodsAction.do?action=0&i=<%=number-1%>">
		  上一页</a></td>
          <%}%>
          <td width="18%" class="linkBlack"><%if(maxPage<=(number+1)){%>
            下一页
              <%}else{%>
	 
		<a href="goodsAction.do?action=0&i=<%=number+1%>">下一页</a>
<%}%>


          <td width="20%" class="linkBlack">
            <div align="right"><a href="goodsAction.do?action=1">添加餐品</a>&nbsp;</div></td>

        </tr>
      </table>
	  <p><br>

    </p>
    </div></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="60" colspan="2"><p align="center"><jsp:include page="../downNews.jsp"/>

</p>    </td>
  </tr>
</table>
</body>
</html>
