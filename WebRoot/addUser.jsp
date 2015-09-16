<%@ page language="java" import="java.util.*,com.ewa.util.*,com.ewa.bean.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>工程师工作纪要 添加帐号</title>
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
    		if($("#username").val()=="") {
				alert("账号不能为空!");
				return;
			}
			
			if(!(/^[A-Za-z0-9_-]+$/.test($("#username").val()))) {
				alert("账号只能包含大写字母、小写字母和数字!");
				return;
			}
	
			if($("#username").val().length > 20) {
				alert("账号超出20字!");
				return;
			}
			
			if($("#password").val()=="") {
				alert("密码不能为空!");
				return;
			}
	
			if($("#password").val().length > 20 || $("#password").val().length < 6) {
				alert("密码长度在6-20位之间!");
				return;
			}
			
			if($("#confirPassword").val()!=$("#password").val()) {
				alert("两个密码不匹配!");
				return;
			}
	
			if($("#describe").val().length > 200) {
				alert("描述超过200字!");
				return;
			}
    	
    		$("#formId").submit();
    		return;
    	});

	})
	</script>
	
<%
ErrorInfo errorInfo = (ErrorInfo)request.getAttribute("ErrorInfo");
if (errorInfo!=null) {
%>
<script type="text/javascript">
alert('<%=errorInfo.getDetailMessage() %>');
</script>
<%
}
UserBean userBean = (UserBean)session.getAttribute("userBean");
if (userBean == null) {

%>
<script type="text/javascript"> 
	alert("您没有登陆"); 
	window.location.href="/login.jsp"; 
</script>
<%
	return;
}

if (userBean.getPriv() != 0) {
%>
<script type="text/javascript"> 
	alert("您没有权限创建用户"); 
	window.location.href="/servlet/Works?howdo=list"; 
</script>
<%
	return;
}
%>
</head>

<body>
	<div class="container">
		<div class="header headermiddle">
			<div class="headermleft"></div>

			<div class="headermright vText" style=" float: right">
				<div style="font-size:12px">您好！欢迎您来到工程师工作纪要</div>
				<div style="margin-top: 20px">
				<% 
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
					<li><a href="/servlet/Works?howdo=list&pageNum=1">工作纪要</a></li>
					<li><a href="/servlet/Customer?howdo=list&pageNum=1">客户管理</a></li>
					<li  class="navcurrent"><a href="/servlet/User?howdo=list&pageNum=1">帐号管理</a></li>
				</ul>
			</div>
		</div>
		<div class="titleDiv">帐号添加</div>
		<div class="titleLineDiv"></div>
		<div class="addContentDiv">
		<form action="/servlet/User" id="formId" method="post">
			<input type="hidden" name="howdo" value="add" />
			<table class="addContentTable" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="120px" align="right">账号:</td>
					<td><input type="text" name="username" id="username" class="addInput fl" autocomplete="off" /></td>
				</tr>
				<tr>
					<td align="right">密码:</td>
					<td><input type="password" name="password" id="password" class="addInput fl" autocomplete="off"/></td>
				</tr>
				<tr>
					<td align="right">确认密码:</td>
					<td><input type="password" name="confirPassword" id="confirPassword" class="addInput fl" autocomplete="off"/></td>
				</tr>
				<tr>
					<td align="right">描述(200字以内):</td>
					<td><textarea name="describe" id="describe" class="addArea fl"></textarea></td>
				</tr>
				
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
