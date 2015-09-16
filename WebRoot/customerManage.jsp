<%@ page language="java" import="java.util.*,com.ewa.bean.*,com.ewa.util.*" pageEncoding="utf-8"%>
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

<title>工程师工作纪要 客户管理</title>
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
		$("#pageSize").change(function(){
			$("#formId").submit();
    		return;
		});
	})
</script>
</head>
<%
String howdo = (String)request.getAttribute("howdo");
String username = (String)request.getAttribute("username");

int pageNum = (Integer)request.getAttribute("pageNum");
int pageCount = (Integer)request.getAttribute("pageCount");
int pageSize = (Integer)request.getAttribute("pageSize");
int pageAll = (Integer)request.getAttribute("pageAll");
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
					<li><a href="/servlet/Works?howdo=list&pageNum=1">工作纪要</a></li>
					<li class="navcurrent"><a href="/servlet/Customer?howdo=list&pageNum=1">客户管理</a></li>
					<li><a href="/servlet/User?howdo=list&pageNum=1">帐号管理</a></li>
				</ul>
			</div>
		</div>
		<form action="/servlet/Customer" id="formId">
		<div class="searchDiv">
		<input type="hidden" name="howdo" value="find" />
			<div class="grayBtn w80 fl" style="margin-left: 15px"
				onclick="pageHref('/servlet/Customer?howdo=addPage')">添加</div>

			<input name="username" id="" class="searchInput fl" style="margin-left: 30px"
				value="<% if(username!=null) {%><%=username %><%}else{%>客户名称<%}%>"
				onfocus="javascript:if(this.value=='客户名称')this.value='';"
				onBlur="javascript:if(this.value=='')this.value='客户名称';" />
			<div class="grayBtn w80 fl" style="margin-left: 15px" id="btnClicked">查询</div>
		</div>
		<div class="forPageTop">
			共 <span style="color:#120eb8"><%=pageCount %></span> 条
			&nbsp;&nbsp; 
			每页 
			<select id="pageSize" name="pageSize" style="width:45px">
				<option value="25"<% if (pageSize == 25) { %> selected="true" <% } %>>25</option>
				<option value="50"<% if (pageSize == 50) { %> selected="true" <% } %>>50</option>
				<option value="100"<% if (pageSize == 100) { %> selected="true" <% } %>>100</option>
			</select> 
			条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		</form>
		
		<div class="rTableDiv">
			<table class="rinTb" width="100%" border="0" cellspacing="0"
				cellpadding="0">
				<tr class="rinTbH">
					<th scope="col">ID</th>
					<th scope="col">客户</th>
					<th scope="col">&nbsp;</th>
					<th scope="col" width="200px">操作</th>
				</tr>
				<% 
				List<CustomerBean> customerList = (ArrayList<CustomerBean>)request.getAttribute("CustomerList");
				int i = 0;
				i = (pageNum - 1) * pageSize + 1;
				for (CustomerBean customer : customerList) {
				%>
				<tr>
					<td><%=i++ %></td>
					<td><%=customer.getName() %></td>
					<td>&nbsp;</td>
					<td><div class="operBtn"
							onclick="pageHref('/servlet/Customer?howdo=edit&id=<%=customer.getId()%>')">编辑</div>
						<div class="operBtn" onclick="pageHref('/servlet/Customer?howdo=del&id=<%=customer.getId()%>')">删除</div>
					</td>
				</tr>
				<% 
				}
				%>
			</table>
			<div class="forPage">
			<%
			if (howdo==null || howdo.isEmpty() || username==null || username.isEmpty()) {
			%>
				共 <span style="color:#120eb8"><%=pageAll%></span> 页&nbsp;&nbsp; 当前第 <span
					style="color:#120eb8"><%=pageNum%></span> 页 
					<a href="/servlet/Customer?howdo=list&pageNum=1&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;
				<a href="/servlet/Customer?howdo=list&pageNum=<%= pageNum-1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">上一页</a> &nbsp;
				<a href="/servlet/Customer?howdo=list&pageNum=<%= pageNum+1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">下一页</a>&nbsp;
				<a href="/servlet/Customer?howdo=list&pageNum=<%= pageAll %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">末页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%
			} else {
			%>
				共 <span style="color:#120eb8"><%=pageAll%></span> 页&nbsp;&nbsp; 当前第 <span
					style="color:#120eb8"><%=pageNum%></span> 页 
					<a href="/servlet/Customer?howdo=find&username=<%=username %>&pageNum=1&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;
				<a href="/servlet/Customer?howdo=find&username=<%=username %>&pageNum=<%= pageNum-1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">上一页</a> &nbsp;
				<a href="/servlet/Customer?howdo=find&username=<%=username %>&pageNum=<%= pageNum+1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">下一页</a>&nbsp;
				<a href="/servlet/Customer?howdo=find&username=<%=username %>&pageNum=<%= pageAll %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">末页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%
			}
			%>
			</div>
		</div>
		<%@ include file="foot.jsp"%>
		<!-- end .container -->
	</div>

</body>
</html>
