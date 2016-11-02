<%@ page language="java" pageEncoding="UTF-8" import="java.util.*, cn.ptp.model.Message"%>
<%@include file="header.jsp" %>

<div id="content">

<form id="form1" name="form1" method="post" action="<%=path%>/update">
<table id="msgadd" width="90%" cellspacing="1" bgcolor="#eee">
  <tr>
    <td width="30%">姓名</td>
    <td class="left"><input type="text" name="name" id="name" value="${message.getName()}" /></td>
  </tr>
  <tr>
    <td>留言</td>
    <td class="left"><textarea name="msg" id="msg" cols="45" rows="5">${message.getMsg()}</textarea></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="button" id="button" value="提 交" /></td>
  </tr>
</table>
<input type="hidden" name="id" id="id" value="${message.getId()}" />
</form>

</div>

<jsp:include page="footer.jsp" />