<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.SmallTypeForm"%>
<%@page import="com.domain.GoodsForm"%>
<%@page import="com.domain.AfficheForm"%>


<jsp:useBean id="goods" scope="page" class="com.dao.GoodsDao"/>
<jsp:useBean id="small" scope="page" class="com.dao.SmallTypeDao"/>
<jsp:useBean id="affiche" scope="page" class="com.dao.AfficheDao"/>
<!--<jsp:useBean id="advert" scope="page" class="com.dao.AdvertDao"/>-->

<%List smallList=(List)small.selectSmall();%>
<!-- <%List advertList=(List)advert.selectAdvert();%> -->
<%List afficheList=(List)affiche.selectAffiche();%>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

  <table width="190" height="638"  border="0" align="center" cellpadding="0" cellspacing="0">


<tr><td height="1"></td></tr>
<tr><td height="252" align="center" valign="bottom">
            <table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
            <tr><td height="50"></td></tr>
              <tr>
                <td height="50" background="image/shangchenggenggao.jpg"><br></td>
              </tr>
              <tr>
                <td height="111">
				  <table width="84%" height="209"  border="0" align="center" cellpadding="0" cellspacing="0"  >
				  <br><br>
                <tr>
                  <td height="166" valign="middle" >
                    
					<MARQUEE direction="up" height="180" onmouseout="this.start()" 
             onmouseover="this.stop()" scrollAmount="2" scrollDelay="1" class="linkRed">	  
		            <%
                      for(int i=0;i<afficheList.size();i++){
                        AfficheForm afficheForm=(AfficheForm)afficheList.get(i);
                        %>
						<div align="center"><a href="#" onClick="window.open('afficheSelect.jsp?id=<%=afficheForm.getId()%>','','width=580,height=430');"><%=afficheForm.getName()%></a></div><br><br>
						<%}%>
                                            </marquee>                  </td>
                </tr>
            </table>
          
</td></tr>
</table>


<tr><td width="100%" height="350" align="center" valign="top">
            <table width="93%" height="100"  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td height="50"  background="image/shangpinxiaoshoupaihang.jpg">&nbsp;</td>
              </tr>
              <br><br>
              <tr>
                <td height="192" >
				  <table width="90%" height="153"  border="0" align="center" cellpadding="0" cellspacing="0">
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
             <br>
                <tr align="center" >
                  <%if(form.getNumber().equals(new Integer(0))){%>
                  <td width="39%" >没有餐品排名</td>
                  <%}else{%>
                 
                  <td width="9%" height="10" class="linkBlack">&nbsp;</td>
                  <td width="44%" class="linkremai">                
                  <li type="square">
                   <div  align="left"><a href="sell_result.jsp?id=<%=form.getId()%>&account=<%=account+1%>"><%=form.getGoodName()%></a> </div>
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




</table>