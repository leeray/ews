<%@ page language="java" import="java.util.*,com.ewa.bean.*" pageEncoding="utf-8"%>
<%@ include file="SessionUser.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>工程师工作纪要</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/css.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
</head>

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
		<%
		int pageNum = (Integer)request.getAttribute("pageNum");
		int pageCount = (Integer)request.getAttribute("pageCount");
		int pageSize = (Integer)request.getAttribute("pageSize");
		int pageAll = (Integer)request.getAttribute("pageAll");
		%>
		<div class="searchDiv">
			<div class="divBtn ml10 fl mt10" onclick="pageHref('/servlet/Works?howdo=stat&id=<%=request.getAttribute("id")%>')">统计</div>
			<div class="divBtn ml10 fl mt10" onclick="window.history.back(-1);">返回</div>
		</div>
		<div class="forPageTop">
			共 <span style="color:#120eb8"><%=pageCount %></span> 条&nbsp;&nbsp; <!-- 每页 <select
				name="" style="width:45px"><option value="25">25</option>
				<option value="50">50</option>
				<option value="100">100</option>
			</select> 条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 -->
		</div>

		<div class="rTableDiv">

			<table class="rinTb" width="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr class="rinTbH">
					<th scope="col">ID</th>
					<th scope="col">客户</th>
					<th scope="col">事件属性</th>
					<th scope="col">是否转800</th>
					<th scope="col">800 case号码</th>
					<th scope="col">是否关闭</th>
					<th scope="col">时间</th>
					<th scope="col" width="120px">操作</th>

				</tr>
				<%
				List<WorksBean> workList = (ArrayList<WorksBean>)request.getAttribute("WorksList");
				int i = 0;
				i = (pageNum - 1) * pageSize + 1;
				
				for (WorksBean works : workList) {
				%>
				<tr>
					<td><%=i++ %></td>
					<td><%=works.getCustomername() %></td>
					<td><%=works.getLevel() %></td>
					<td><% if (works.isIsphonecall()) { %>是 <%} else {%> 否<%} %></td>
					<td><%=works.getPhonecallnumber() %></td>
					<td><% if (works.getIsclosed() == 1) { %>关闭 <%} else {%> 开启<%} %></td>
					<td><%=works.getCreatedate() %></td>
					<td>
						<div class="operBtn" style="width:80px" onclick="pageHref('/servlet/Works?howdo=view&id=<%=works.getId()%>')">查看</div>
						<!-- div class="operBtn" onclick="pageHref('/servlet/Works?howdo=edit&id=<%=works.getId()%>')">编辑</div -->
					</td>
				</tr>
				<%
				}
				%>
			</table>
			<!-- div class="forPage">
				共 <span style="color:#120eb8"><%=pageAll%></span> 页&nbsp;&nbsp; 当前第 <span
					style="color:#120eb8"><%=pageNum%></span> 页 <a href="/servlet/Works?howdo=history&pageNum=1&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;
				<a href="/servlet/Works?howdo=history&pageNum=<%= pageNum-1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">上一页</a> &nbsp;
				<a href="/servlet/Works?howdo=history&pageNum=<%= pageNum+1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">下一页</a>&nbsp;
				<a href="/servlet/Works?howdo=history&pageNum=<%= pageCount %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div -->
		</div>
		<%@ include file="foot.jsp"%>
		<!-- end .container -->
	</div>

</body>
</html>
