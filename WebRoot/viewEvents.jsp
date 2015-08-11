<%@ page language="java" import="java.util.*,com.ewa.bean.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>工程师工作纪要 查看</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/css.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<%

WorksBean worksBean = (WorksBean)request.getAttribute("worksBean");

if (worksBean == null) {
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
					<li><a href="/servlet/Customer?howdo=list">客户管理</a></li>
					<li><a href="/servlet/User?howdo=list">帐号管理</a></li>
				</ul>
			</div>
		</div>
		<div class="titleDiv">工作纪要查看</div>
		<div class="titleLineDiv"></div>
		<div class="addContentDiv">
			<table class="addContentTable" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="120px" align="right">客户:</td>
					<td><span style="margin-left: 20px"><%=worksBean.getCustomername() %></span></td>
				</tr>
				<tr>
					<td width="120px" align="right">工程师:</td>
					<td><span style="margin-left: 20px"><%=worksBean.getUsername() %></span></td>
				</tr>
				<tr>
					<td align="right">事件属性:</td>
					<td><span style="margin-left: 20px"><%=worksBean.getLevel() %></span>
					</td>
				</tr>
				<tr>
					<td align="right">事件描述:</td>
					<td><div class="lineDiv"><%=worksBean.getDescribe() %></div>
					</td>
				</tr>
				<tr>
					<td align="right">二级单位:</td>
					<td><span style="margin-left: 20px;max-width: 700px"><%=worksBean.getErjidanwei() %></span>
					</td>
				</tr>
				<tr>
					<td align="right">客户联系人:</td>
					<td><span style="margin-left: 20px;max-width: 700px"><%=worksBean.getKehulianxiren() %></span>
					</td>
				</tr>
				<tr>
					<td align="right">联系方式:</td>
					<td><span style="margin-left: 20px;max-width: 700px"><%=worksBean.getLianxifangshi() %></span>
					</td>
				</tr>
				<tr>
					<td align="right">联系邮箱:</td>
					<td><span style="margin-left: 20px;max-width: 700px"><%=worksBean.getLianximail() %></span>
					</td>
				</tr>
				<tr>
					<td align="right">是否转800:</td>
					<td><span style="margin-left: 20px"><% if (worksBean.isIsphonecall()) { %>是 <%} else {%> 否<%} %></span></td>
				</tr>
				<tr>
					<td align="right">800 case号码:</td>
					<td><span style="margin-left: 20px"><%=worksBean.getPhonecallnumber() %></span></td>
				</tr>
				<tr>
					<td align="right">解决办法:</td>
					<td><div class="lineDiv"><%=worksBean.getSolution() %></div>
					</td>
				</tr>
				<tr>
					<td align="right">是否关闭:</td>
					<td><span style="margin-left: 20px "><% if (worksBean.getIsclosed() == 1) { %>关闭 <%} else {%> 开启<%} %></span></td>
				</tr>
				<tr>
					<td align="right">更新内容:</td>
					<td><div class="lineDiv"><% if(worksBean.getNewcontent() != null) { %> <%=worksBean.getNewcontent() %> <%}%></div></td>
				</tr>
				<%
				if (worksBean.getIsclosed() == 1 && worksBean.getClosedate()!=null) {
				%>
				<tr>
					<td align="right">关闭时间:</td>
					<td><span style="margin-left: 20px"><%=worksBean.getClosedate() %></span></td>
				</tr>
				<%
				}
				%>
				<tr>
					<td align="right"></td>
					<td>
						<div class="divBtn ml20 fl mt20" onclick="window.history.back(-1);">返回</div></td>
				</tr>
			</table>

		</div>
		<%@ include file="foot.jsp"%>
		<!-- end .container -->
	</div>

</body>
</html>
