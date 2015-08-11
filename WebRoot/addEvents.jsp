<%@ page language="java" import="java.util.*, com.ewa.bean.*,com.ewa.util.*" pageEncoding="utf-8"%>
<%@ include file="SessionUser.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("UTF-8");
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

<title>工程师工作纪要 添加</title>
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
List<CustomerBean> customerList = (ArrayList<CustomerBean>)request.getAttribute("CustomerList");
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
					<a href="/login.jsp?action=logout">退出</a>
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
					<li class="navcurrent"><a href="/servlet/Works?howdo=list">工作纪要</a></li>
					<%
					if (sessionUser!=null && sessionUser.getPriv() == 0) {
					%>
					<li><a href="/servlet/Customer?howdo=list">客户管理</a></li>
					<li><a href="/servlet/User?howdo=list">帐号管理</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
		<div class="titleDiv">工作纪要添加</div>
		<div class="titleLineDiv"></div>
		<div class="addContentDiv">
			<form action="/servlet/Works" id="formId" method="post">
			<input type="hidden" name="howdo" value="add" />
			<table class="addContentTable" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="160px" align="right">客户:</td>
					<td>
					<input type="hidden" name="" id="" />
					<select name="customerid" id="" class="addSelect fl">
					<%
					for (CustomerBean customerBean : customerList) {
					%>
						<option value="<%=customerBean.getId() %>"><%=customerBean.getName() %></option>
					<%
					}
					%>
					</select>
					</td>
				</tr>
				<tr>
					<td align="right">二级单位:</td>
					<td><input type="text" name="erjidanwei" id="" class="addInput fl"/></td>
				</tr>
				<tr>
					<td align="right">客户联系人:</td>
					<td><input type="text" name="kehulianxiren" id="" class="addInput fl"/></td>
				</tr>
				<tr>
					<td align="right">联系方式:</td>
					<td><input type="text" name="lianxifangshi" id="" class="addInput fl"/></td>
				</tr>
				<tr>
					<td align="right">联系邮箱:</td>
					<td><input type="text" name="lianximail" id="" class="addInput fl"/></td>
				</tr>
				<tr>
					<td align="right">事件属性:</td>
					<td>
					<select name="level" id="" class="addSelect fl">
						<option value="一级问题">一级问题</option>
						<option value="二级问题">二级问题</option>
						<option value="普通问题">普通问题</option>
						<option value="技术咨询">技术咨询</option>
					</select>
					</td>
				</tr>
				<tr>
					<td align="right">事件描述(1000字以内):</td>
					<td><textarea name="describe" id="" class="addArea fl"></textarea></td>
				</tr>
				<tr>
					<td align="right">是否转800:</td>
					<td>
						<input type="radio" name="isphonecall" id="" class="ml15" value="1" checked/> 是 
						<input type="radio" name="isphonecall" id="" class="ml15" value="0" /> 否
					</td>
				</tr>
				<tr>
					<td align="right">800 CASE号码:</td>
					<td><input type="text" name="phonenumber" id="" class="addInput fl" /></td>
				</tr>
				<tr>
					<td align="right">解决办法(1000字以内):</td>
					<td><textarea name="solution" id="" class="addArea fl"></textarea></td>
				</tr>
				<tr>
					<td align="right">是否关闭:</td>
					<td>
						<input type="radio" name="isclosed" id="" class="ml15" value="1" /> 是 
						<input type="radio" name="isclosed" id="" class="ml15" value="0" checked /> 否
					</td>
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
