<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.GoodsForm" %>
<jsp:useBean id="newGood" scope="page" class="com.dao.GoodsDao"/>
<%List nowList =newGood.selectMark(Integer.valueOf("0"));%>
<%List freeList =newGood.selectMark(Integer.valueOf("1"));%>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
<table width="100%" height="150"  border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">             
          <tr>
            <td height="50" colspan="2" align="center" valign="top" background="image/tejia.jpg">            
            </td>
         </tr>
                    
          <tr> 		  		  		  		  		  
		  <%
              int free=2;
              if(freeList.size()<2){
              free=freeList.size();
              }

              for(int i=0;i<free;i++)
              {
                GoodsForm newGoods=(GoodsForm)freeList.get(i);
                %>
            <td height="80" valign="middle">		
            	<table width="99%" height="136" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" bordercolorlight="#FFFFFF" bordercolordark="#819BBC">
              <tr>
                <td width="60%" rowspan="5" height="80"><input name="pricture<%=i%>" type="image" src="<%=newGoods.getPicture()%>" width="210" height="130"></td>
                <td width="40%" height="20"><div align="center"><%=newGoods.getName()%></div></td>
              </tr>
              <tr>
                <td height="20"><div align="center" style="text-decoration:line-through;color:#910402">ԭ�ۣ�<%=newGoods.getNowPrice()%>Ԫ</div></td>
              </tr>
              <tr>
                <td height="20"><div align="center"><font color="#F14D83">�ּۣ�<%=newGoods.getFreePrice()%>Ԫ</font></div></td>
              </tr>
              <tr>
                <td height="20"><div align="center"><%=newGoods.getIntroduce()%></div></td>
              </tr>
              <tr>
                <td height="13"><div align="center" class="linkBlack"><a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=newGoods.getId()%>','','width=800,height=400');">�鿴��ϸ����</a></div></td>
              </tr>
            </table></td>
            <%}%>
          </tr>
</table>


<%}%>

<table width="100%" height="590"  border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="50" align="center" valign="middle" background="image/xinshu.jpg"><div align="left">
              <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                 
                  
                </tr>
              </table>
            </div></td>
          </tr>
          <tr>
            <td height="529">
			<%
              int now=4;
              if(nowList.size()<4){
              now=nowList.size();
              }

              for(int i=0;i<now;i++)
              {
                GoodsForm newGoods=(GoodsForm)nowList.get(i);
                %><table width="100%" height="179"  border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="179">				
                <table width="99%" height="163" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"   >
                  <tr>
                    <td height="159" bordercolor="#666666" >
                      <table width="96%" height="120"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#EFEFEF" >
                        <tr>
                          <td width="60%" rowspan="4" height="120"><div align="center">
                              <input name="pricture<%=i%>" type="image" src="<%=newGoods.getPicture()%>"width="420" height="138">
                          </div></td>
                          <td width="40%" height="30"><div align="center"><%=newGoods.getName()%></div></td>
                        </tr>
                        <tr>
                          <td height="30"><div align="center"><font color="#F14D83">���ۣ�<%=newGoods.getNowPrice()%>Ԫ</font></div></td>
                        </tr>
                        <tr>
                          <td height="30"><div align="center"><%=newGoods.getIntroduce()%></div></td>
                        </tr>
                        <tr>
                          <td height="30" class="linkBlack"><div align="center">
                              <%if(session.getAttribute("form")!=null||session.getAttribute("id")!=null){%>
                              <a href="#" onClick="window.open('goodsAction.do?action=16&id=<%=newGoods.getId()%>','','width=800,height=400');">�鿴��ϸ����</a></div>
                              <%}else{%>
                              <div align="center">��¼����ܹ���</div></td>
                          <%}%>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table>
			<%}%>		
			
			
			
			
			
			</td>
			 
		       
          </tr>
</table>

