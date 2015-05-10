<%@ page contentType="text/html; charset=gb2312" %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<%@ page import="com.domain.ManagerForm"%>
<%java.util.Date date=new java.util.Date();%>
<%ManagerForm manager=(ManagerForm)session.getAttribute("manager");%>
<%if(manager==null||manager.equals("")){%> 
<meta http-equiv="refresh" content="0;URL=background/connectionFail.jsp">
    
	  <%}else{%>
	  <table width="100%" height="15"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="24%" height="18">&nbsp;&nbsp;&nbsp;</td>
        </tr>
      </table>
	  <%}%>