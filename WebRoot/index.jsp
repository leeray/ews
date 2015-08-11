<%@ page language="java" import="java.util.*,com.ewa.bean.*,com.ewa.util.*" pageEncoding="utf-8"%>
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
<link rel="stylesheet" type="text/css" href="/css/css.css" />
<link rel="stylesheet" type="text/css" href="/css/calendar.css"/>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
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
	});
	
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
%>

</head>
<%
String howdo = (String)request.getAttribute("howdo");
String username = (String)request.getAttribute("username");
String customername = (String)request.getAttribute("customername");
String isclosed = (String)request.getAttribute("isclosed");
String createtime = (String)request.getAttribute("createtime");
String closetime = (String)request.getAttribute("closetime");

int closed = 99;
if (isclosed != null && !isclosed.equals("")) {
	try{
		closed = Integer.valueOf(isclosed);
	}catch(Exception e){}
}

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
		<form action="/servlet/Works" id="formId">
		<div class="searchDiv">
		<input type="hidden" name="howdo" value="find" />
			<div class="grayBtn w80 fl" style="margin-left: 15px"
				onclick="pageHref('/servlet/Works?howdo=addPage')">添加</div>

			<input name="username" id="" class="searchInput fl" style="margin-left: 30px"
				value="<% if(username!=null) {%><%=username %><%}else{%>用户<%}%>" onfocus="javascript:if(this.value=='用户' || this.value=='null')this.value='';"
				onBlur="javascript:if(this.value=='' || this.value=='null')this.value='用户';" />
			<input name="customername" id="" class="searchInput fl" 
				value="<% if(customername!=null) {%><%=customername %><%}else{%>客户<%}%>" onfocus="javascript:if(this.value=='客户')this.value='';"
				onBlur="javascript:if(this.value=='')this.value='客户';" /> 
			<select name="isclosed" id="" class="searchSelect fl">
				<option value="事件状态">事件状态</option>
				<option value="0" <% if(closed == 0) {%> selected <%}%>>开启</option>
				<option value="1" <% if(closed == 1) {%> selected <%}%>>关闭</option>
			</select> 
			<input name="createtime" id="createtime" class="searchInput fl" value="<% if(createtime!=null) {%><%=createtime %><%}else{%>新增时间<%}%>"
				onfocus="javascript:if(this.value=='新增时间')this.value='';" 
				onBlur="javascript:if(this.value=='')this.value='新增时间';"
				onClick="WdatePicker({errDealMode:1})" /> 
			<input name="closetime" id="closetime" class="searchInput fl" value="<% if(closetime!=null) {%><%=closetime %><%}else{%>关闭时间<%}%>"
				onfocus="javascript:if(this.value=='关闭时间')this.value='';"
				onBlur="javascript:if(this.value=='')this.value='关闭时间';"
				onClick="WdatePicker({errDealMode:1})" />

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
					<th scope="col">事件属性</th>
					<th scope="col">是否转800</th>
					<th scope="col">800 case号码</th>
					<th scope="col">是否关闭</th>
					<th scope="col">时间</th>
					<th scope="col" width="200px">操作</th>

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
						<div class="operBtn"
							onclick="pageHref('/servlet/Works?howdo=edit&id=<%=works.getId()%>')">更新</div>
						<div class="operBtn" style="width:70px"
							onclick="pageHref('/servlet/Works?howdo=history&id=<%=works.getId()%>')">查看历史</div>
						
					</td>
				</tr>
				<%
				}
				%>
			</table>
			<div class="forPage">
			<%
			if (howdo==null || howdo.isEmpty()) {
			%>
				共 <span style="color:#120eb8"><%=pageAll%></span> 页&nbsp;&nbsp; 当前第 <span
					style="color:#120eb8"><%=pageNum%></span> 页 <a href="/servlet/Works?howdo=list&pageNum=1&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;
				<a href="/servlet/Works?howdo=list&pageNum=<%= pageNum-1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">上一页</a> &nbsp;
				<a href="/servlet/Works?howdo=list&pageNum=<%= pageNum+1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">下一页</a>&nbsp;
				<a href="/servlet/Works?howdo=list&pageNum=<%= pageAll %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<%
			} else {
			
				String where = "";
				if (customername !=null && !customername.isEmpty()) {
					where = "&customername="+customername;
				}
				if (username !=null && !username.isEmpty()) {
					where = "&username="+username;
				}
				if (isclosed != null && !isclosed.isEmpty()) {
					where = "&isclosed="+isclosed;
				}
				if (createtime!=null && !createtime.isEmpty()) {
					where = "&createtime="+createtime;
				}
				if (closetime!=null && !closetime.isEmpty()) {
					where = "&closetime="+closetime;				
				}
				
			%>
				共 <span style="color:#120eb8"><%=pageAll%></span> 页&nbsp;&nbsp; 当前第 <span
					style="color:#120eb8"><%=pageNum%></span> 页 <a href="/servlet/Works?howdo=find&<%=where %>&pageNum=1&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;
				<a href="/servlet/Works?howdo=find&<%=where %>&pageNum=<%= pageNum-1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">上一页</a> &nbsp;
				<a href="/servlet/Works?howdo=find&<%=where %>&pageNum=<%= pageNum+1 %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">下一页</a>&nbsp;
				<a href="/servlet/Works?howdo=find&<%=where %>&pageNum=<%= pageAll %>&pageSize=<%= pageSize %>&pageCount=<%= pageCount %>">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
