<%@ page language="java" pageEncoding="UTF-8" import="java.util.*,cn.ptp.natives.model.*,cn.ptp.natives.lib.*"%>
<%@include file="header.jsp" %>
<div id="content">
<%
int id = Integer.parseInt(request.getParameter("id"));
MessageDo msgd = new MessageDo();
Message msg = msgd.getOne(id);
%>
<form id="form1" name="form1" method="post" action="<%=path%>/hibernate/editMessage">
<table id="msgadd" width="90%" cellspacing="1" bgcolor="#eee">
  <tr>
    <td width="30%">姓名</td>
    <td class="left"><input type="text" name="name" id="name" value="<%=msg.getName()%>" /></td>
  </tr>
  <tr>
    <td>留言</td>
    <td class="left"><textarea name="msg" id="msg" cols="45" rows="20"><%=msg.getMsg()%></textarea></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="button" id="button" value="提 交" /></td>
  </tr>
</table>
<input type="hidden" name="mid" id="mid" value="<%=id%>" />
</form>

</div>
<jsp:include page="footer.jsp" />