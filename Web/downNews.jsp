<%@ page contentType="text/html; charset=gb2312" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="com.domain.LinkForm" %>
<jsp:useBean id="link" scope="page" class="com.dao.LinkDao"/>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%List linkList=(List)link.selectLink();%>

<%--<%List list=dao.selectLink();--%>

<link href="css/css.css" rel="stylesheet" type="text/css">


<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0"  bordercolor="#FFFFFF" bordercolordark="#D6D3CE" bordercolorlight="#D6D3CE">
  <tr><td>
        <table align="center" width="100%" height="80%"  border="0" cellpadding="0" cellspacing="0">
            <tr><td><div align="center">品牌官网</div></td></tr>
  
              <tr><td><table align="center"><tr><td><%
            		  request.setCharacterEncoding("GB2312");  
                  String id=request.getParameter("id");
				  if(id==null){
				  id="none";
				  }
                  for(int i=0;i<linkList.size();i++){
                  LinkForm linkForm=(LinkForm)linkList.get(i);
				  
                    %>
           <td align="center" class="linkLeixing" <%if(id.equals(linkForm.getId().toString())){out.println("bgcolor='#DAD9D9'");}%>>
       <div class="linkWhite"><a href="<%=linkForm.getLinkAddress()%>"><%=linkForm.getLinkName()%></a></div></td>
                  
              <%}%> </td></tr></table></td></tr>
  
  
      <tr>
       <td height="40" class="linkBlack"><div align="center">本站请使用IE6.0或以上版本 1024*768为最佳显示效果</div></td>
      </tr>
  
    </table>    
 </td></tr></table>
 
  
  
     <!-- <%--    <td width="60%"><div align="center">&nbsp;
              <table width="90%" height="24"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="24" style="color:#FFFFFF "><ul>
				  <%
              for(int i=0;i<list.size();i++){
              LinkForm form=(LinkForm)list.get(i);
                %>
				  <li>
                    <div align="right" class="linkBlack">
                    <a href="<%=form.getLinkAddress()%>"><%=form.getLinkName()%></a></div>
                  </li>
				  <%}%>
                  </ul>
                  </td>
                </tr>
              </table></div>
     </td>--%> -->           
          


  <!-- <%--
 <td width="18%"><div align="center">&nbsp;
              <table width="61%" height="24"  border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td height="24" style="color:#FFFFFF "><ul>
				  <%
              for(int i=0;i<list.size();i++){
              LinkForm form=(LinkForm)list.get(i);
                %>
				  <li>
                    <div align="right" class="linkWhite"><a href="<%=form.getLinkAddress()%>"><%=form.getLinkName()%></a></div>
                  </li>
				  <%}%>
                  </ul>
                  </td>
                </tr>
              </table>
           </div></td>
           
  --%> -->         
           
           