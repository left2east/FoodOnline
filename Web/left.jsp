<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.AfficheForm"%>
<%@page import="com.domain.MemberForm"%>
<%@page import="com.domain.AdvertForm"%>

 <!--<%--   <%@page import="com.domain.GoodsForm"%>
    <jsp:useBean id="goods" scope="page" class="com.dao.GoodsDao"/> 
    
<jsp:useBean id="affiche" scope="page" class="com.dao.AfficheDao"/>  --%>--> 
<jsp:useBean id="advert" scope="page" class="com.dao.AdvertDao"/>


<link rel="stylesheet" href="css/css.css">
<%java.util.Date date=new java.util.Date();%>
<%List advertList=(List)advert.selectAdvert();%>
<script language="javascript">

function land(){                  //登录的脚本
if(document.form.name.value==""){
window.alert("请输入账号");
return false;
}
if(document.form.password.value==""){
window.alert("请输入密码");
return false;
}

return true;
}
function quit() {
  if(confirm("欢迎下次光临！！！")){
    window.location.href="loginOut.jsp";
	}
  }

</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<table width="193" height="635"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> <td width="193" height="300" valign="middle" background="image/zuocedaohangbeijing.jpg">
  
			<%if(session.getAttribute("id")==null||session.getAttribute("form")==null){%>
			<center><h2>会员登录</h2></center>
			<form name="form" method="post" action="memberAction.do?action=1" onSubmit="return land()">
			<table width="180" height="240"  border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td width="50%" height="20"><div align="center">用户名：</div></td>
                <td width="50%"><input name="name" type="text" size="13"></td>
              </tr>
              <tr>
                <td height="20"><div align="center">密&nbsp;&nbsp;码：</div></td>
                <td><input name="password" type="password" size="13"></td>
              </tr>
              <tr ><td>

                <td width="70%" height="30" ><div align="left"><input type="submit" name="Submit3"  value="会员登录"></div></td>             
            </td></tr>
       
       
            
          <tr align="center">
              <td height="30"><div align="right">
                <table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
                 <tr>
                    <td class="linkRed"><div align="center"> <a href="member/findOne.jsp">密码丢失</a></div></td>
                  </tr>
                  
                </table>
                </div></td> 
                <td><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
                 <tr>
                     <td class="linkRed"><div align="center"><a href="member/memberRegister.jsp">还不是会员</a></div></td>
                  </tr>
                </table></td>
          </tr>
          
          
          
          
         </table></form>
			
				<%}else{%>
				          <%MemberForm form=(MemberForm)session.getAttribute("form");%>
				          
			<font color="#FF2400 "><div align="center"><%=form.getName()%>，欢迎您的光临！</div><br></font>
			    <table width="93%" height="90"  border="0" align="center" cellpadding="0" cellspacing="0" 
			           bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
			       <tr>
                    <td class="linkRed"><font color="#FF1CAE"><div align="center"><%=form.getName()%>，欢迎您的光临！</div></font></td>
                  </tr>    
                  <tr>
                    <td align="center"> 今天是<%=date.getYear()+1900%>年<%=date.getMonth()+1%>月<%=date.getDate()%>日</td>
                  </tr>
                  <tr>
                    <td align="center" class="linkBlack" > <a href="javascript:quit()">安全退出</a></td>
                  </tr>
              </table>
       	<%}%> 
        
 
  </td></tr>
          
 
 
<tr><td height="150" align="center" valign="middle">
       <table width="100%" height="60%"  border="0" cellpadding="0" cellspacing="0" background="image/guanlibg.jpg">
     <tr>
      <td height="68"><div align="center"><a href="background/managerCheck.jsp"><h3>后台管理</h3></a>
     </td></tr>
     </table>    
</td></tr>
              
          
  <tr>
       <td>  
       <tr><td height="252" align="center" valign="bottom">
       <table width="193" height="100%"  border="0" cellpadding="0" cellspacing="0">
             
              <tr><td height="50" >
              <MARQUEE direction="right" height="30"  
             scrollAmount="5" scrollDelay="1" class="linkBlack">	
                                            <font size="6" color="BC1717"><b>！！ 机会不容错过！！</b></font>
              </MARQEE> 
             </td></tr>
             
              <tr>
                <td height="111">
				  <table width="84%" height="209"  border="0" align="center" cellpadding="0" cellspacing="0"  >
                <tr>
                  <td height="166" valign="middle" >
                    
					<MARQUEE direction="up" height="180" onmouseout="this.start()" 
             onmouseover="this.stop()" scrollAmount="3" scrollDelay="1" class="linkguanggao">	  
		            <%
                      for(int i=0;i<advertList.size();i++){
                       AdvertForm advertForm=(AdvertForm)advertList.get(i);
                        %>
						<div align="center"><a href="#" onClick="window.open('advertSelect.jsp?id=<%=advertForm.getId()%>','');"><%=advertForm.getName()%></a></div><br><br>
						<%}%>
                                            </marquee> 
                   </td>
                </tr>
            </table>
								
        </td>
      </tr>
    </table>			
            
            
      </td>
      </tr>
    </table>       
    

				
				
			
  
  
 <!--<%--   <tr>
            <td height="236" valign="top"><table width="100%" height="235"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="43" background="image/shangpinxiaoshoupaihang.jpg">&nbsp;</td>
              </tr>
              <tr>
                <td height="192">
				  <table width="84%" height="153"  border="0" align="center" cellpadding="0" cellspacing="0">
          <ul> 
          <%
             List goodsList =goods.selectGoodsNumber();
             int number=goodsList.size();
           if(number>6){
             number=5;
           }
             for(int account=0;account<number;account++){
             GoodsForm form=(GoodsForm)goodsList.get(account);
             %> 
             
                <tr align="center" >
                  <%if(form.getNumber().equals(new Integer(0))){%>
                  <td width="39%" >没有加湿器排名</td>
                  <%}else{%>
                 
                  <td width="12%" class="linkBlack">&nbsp;</td>
                  <td width="44%" class="linkBlack">                
                  <li type="square">
                   <div  align="left"><a href="sell_result.jsp?id=<%=form.getId()%>&account=<%=account+1%>"><%=form.getName()%></a> </div>
                   </li>
                   </td>
                  <%}%>
               <td width="5%">  </tr>
             <%}%> </ul>
            </table>	 							
								
				</td>
              </tr>
            </table></td>
  </tr>
 --%> -->
  


