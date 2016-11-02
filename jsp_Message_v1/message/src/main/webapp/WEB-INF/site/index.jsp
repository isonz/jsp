<%@ page language="java" pageEncoding="UTF-8" import="java.util.*, cn.ptp.model.Message"%>
<%@include file="header.jsp" %>

<div id="content">

<table id="msglist" width="90%" cellspacing="1" bgcolor="#eee">
<%int k=1;%>
<c:forEach items="${list}" var="l">
  <tr>
    <td class="listnum" width="5%">${l.getId()}</td>
    <td width="5%"><img src="<%=path%>/images/<%=k%>.gif" /></td>
    <td width="15%">${l.getName()}</td>
    <td>${l.getMsg()}</td>
    <td width="15%">${l.getCreate_at("yyyy-MM-dd HH:mm:ss")}</td>
    <td width="5%"><a href="<%=path%>/edit?id=${l.getId()}">修改</a></td>
    <td width="5%"><a href="<%=path%>/delete?id=${l.getId()}">删除</a></td>
  </tr>
<%if(k>1){k=1;}else{k++;}%>
</c:forEach>
</table>

<form id="form1" name="form1" method="post" action="<%=path%>/add">
<table id="msgadd" width="90%" cellspacing="1" bgcolor="#eee">
  <tr>
    <td width="30%">姓名</td>
    <td class="left"><input type="text" name="name" id="name" /></td>
  </tr>
  <tr>
    <td>留言</td>
    <td class="left"><textarea name="msg" id="msg" cols="45" rows="5"></textarea></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="button" id="button" value="提 交" /></td>
  </tr>
</table>
</form>

</div>

<jsp:include page="footer.jsp" />