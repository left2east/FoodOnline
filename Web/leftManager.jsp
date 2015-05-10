<%@ page contentType="text/html; charset=gb2312" %>
 <link href="css/css.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
 <script Language="JavaScript">
 function quit() {
  if(confirm("确定要退出后台吗？")){
    window.location.href="loginOut.jsp";
	}
  }
 </script>
<table width="100%" height="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <!-- <td height="45" colspan="2" background="image/zuocedaohang1.jpg">       </td> -->      
        <td width="13%"   background="image/zuocedaohang2.jpg" class="linkWhite"><p align="center"><a href="goodsAction.do?action=0">餐品管理</a></p></td>
      
        <td height="40" background="image/zuocedaohang2.jpg" class="linkWhite"><p align="center"><a href="memberAction.do?action=2">会员管理</a></p></td>
      
        <td height="40" background="image/zuocedaohang2.jpg" class="linkWhite"><p align="center"><a href="managerAction.do?action=1">管理员管理 </a></p></td>
     
        <td height="40" background="image/zuocedaohang2.jpg" class="linkWhite"><p align="center"><a href="orderAction.do?action=0">订单管理</a></p></td>
        
        <td height="40" background="image/zuocedaohang2.jpg" class="linkWhite"><p align="center"><a href="advertAction.do?action=0">广告发布</a> </p></td>
      
        <td height="40" background="image/zuocedaohang2.jpg" class="linkWhite"><p align="center"><a href="afficheAction.do?action=0">公告设置</a> </p></td>
      
        <td height="40" background="image/zuocedaohang2.jpg" class="linkWhite"><p align="center"><a href="linkAction.do?action=0">友情连接设置</a></p></td>
    
        <td height="40" background="image/zuocedaohang2.jpg" class="linkWhite"><p align="center"><a href="javascript:quit()">退出后台</a></p></td>
        

      </tr>
</table>
