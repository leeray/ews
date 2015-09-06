<%@ page language="java" import="java.util.*,com.ewa.bean.*,com.ewa.util.*" pageEncoding="utf-8"%>
<%@ include file="SessionUser.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
ErrorInfo errorInfo = (ErrorInfo)request.getAttribute("ErrorInfo");
if (errorInfo!=null) {
%>
<script type="text/javascript">
alert('<%=errorInfo.getDetailMessage() %>');
</script>
<%
}
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>工程师工作纪要 修改密码</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
    	$("#btnClicked").click(function () {
    		$("#formId").submit();
    		return;
    	});

	})
	</script>
</head>
<%
UserBean userBean1 = (UserBean)request.getAttribute("userBean");
if (userBean1 == null) {
	return;
}
%>
<body>
	<div class="container">
		<div class="header headermiddle">
			<div class="headermleft"></div>

			<div class="headermright vText" style=" float: right">
				<div style="font-size:12px">您好！欢迎您来到工程师工作纪要</div>
				<div style="margin-top: 20px">
				<% 
				UserBean userBean = (UserBean)session.getAttribute("userBean");
				if (userBean == null) {
				%>
					<a href="/login.jsp" target="_blank">登陆</a>
				<%
				} else {
				%>
					<font class="fontsong17">当前用户</font>: <font class="fontsong14"><%=userBean.getName() %></font>, &nbsp;
					<font class="fontsong17"><a href="/login.jsp?action=logout">退出</a></font>
				<% 
				}
				%>
				</div>
			</div>
		</div>
		<!-- 导航 -->
		<div class=" headernav">
			<div class=" nav">
				<ul>
					<li><a href="/servlet/Works?howdo=list">修改密码</a></li>
					<%
					if (sessionUser!=null && sessionUser.getPriv() == 0) {
					%>
					<li><a href="/servlet/Customer?howdo=list">客户管理</a></li>
					<li  class="navcurrent"><a href="/servlet/User?howdo=list">帐号管理</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
		<!-- div class="titleDiv">修改密码</div -->
		<!-- div class="titleLineDiv"></div -->
		<div class="addContentDiv">
		<form action="/servlet/User" id="formId">
			<input type="hidden" name="howdo" value="updatePwd" />
			<input type="hidden" name="id" value="<%=userBean1.getId()%>" />
			<table class="addContentTable" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="120px" align="right">账号:</td>
					<td><input type="text" name="username" id="" class="addInput fl" value="<%=userBean1.getName() %>" readonly/></td>
				</tr>
				<tr>
					<td align="right">密码:</td>
					<td><input type="password" name="password" id="" class="addInput fl" value=""/></td>
				</tr>
				<tr>
					<td align="right">确认密码:</td>
					<td><input type="password" name="confirPassword" id="" class="addInput fl" value=""/></td>
				</tr>
				<!-- tr>
					<td align="right">描述:</td>
					<td><textarea name="describe" id="" class="addArea fl"><%=userBean1.getDescribe() %></textarea></td>
				</tr-->
				
				<tr>
					<td align="right"></td>
					<td><div class="divBtn ml20 fl mt20" id="btnClicked">保存</div>
						<div class="divBtn ml20 fl mt20" onclick="window.history.back(-1);">返回</div></td>
				</tr>
			</table>
		</form>
		</div>
		<%@ include file="foot.jsp"%>
		<!-- end .container -->
	</div>

</body>
</html>
