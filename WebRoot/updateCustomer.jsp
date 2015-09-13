<%@ page language="java" import="java.util.*, com.ewa.bean.*,com.ewa.util.*" pageEncoding="utf-8"%>
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

<title>工程师工作纪要 修改客户</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/scroll.css" />
<link rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript">
	// 全部左移
	function allleft() {
		$("#selectedUser").find("option").appendTo($("#selectUser"))
	}

	// 全部右移
	function allright() {
		$("#selectUser").find("option").appendTo($("#selectedUser"))
	}

	// 右移
	function right() {
		$("#selectUser").find("option:selected").appendTo($("#selectedUser"));
	}
	
	// 左移
	function left() {
		$("#selectedUser").find("option:selected").appendTo($("#selectUser"));
	}
</script>
<script type="text/javascript">
	$(document).ready(function () {
    	$("#btnClicked").click(function () {
    		if($("#customername").val()==""){
				alert("客户名称不可以为空!");
				return;
			}
			if($("#customername").val().length > 50) {
				alert("客户名称超出50字!");
				return;
			}
			
			var selected = $("#selectedUser").find("option");
			if (selected.length <= 0) {
				alert("请为客户选择账号!");
				return;
			}
			
			$("#selectedUser").find("option").attr("selected",true);
    	
			/* $("#selectedUser").children("option").each(function(){  
				$(this).attr("selected","true");  
			}); */
    	
    		$("#formId").submit();
    		return;
    	});

	})
</script>
</head>
<%
CustomerBean customerBean = (CustomerBean)request.getAttribute("customerBean");
if (customerBean == null) {
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
					<li><a href="/servlet/Works?howdo=list&pageNum=1">工作纪要</a>
					</li>
					<li class="navcurrent"><a href="/servlet/Customer?howdo=list&pageNum=1">客户管理</a>
					</li>
					<li><a href="/servlet/User?howdo=list&pageNum=1">帐号管理</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="titleDiv">客户修改</div>
		<div class="titleLineDiv"></div>
		<div class="addContentDiv">
		<form action="/servlet/Customer" id="formId" method="post">
			<input type="hidden" name="howdo" value="update" />
			<input type="hidden" name="id" value="<%=customerBean.getId() %>" />
			<table class="addContentTable" border="0" cellspacing="0"
				cellpadding="0">
				<tr>
					<td width="120px" align="right">客户:</td>
					<td><input type="text" name="customername" id="customername" class="addInput fl" value="<%=customerBean.getName() %>" />
					</td>
				</tr>
				<tr>
					<td height="40px"></td>
					<td></td>
				</tr>
				<tr>
					<td align="right">帐号:</td>
					<td><table>
							<tr>
								<td><select id="selectUser" name="selectUser" class="muSelect" multiple="multiple" size="20">
								<%
								List<UserBean> userList1 = (ArrayList<UserBean>)request.getAttribute("UserList1");
								for (UserBean userBean1 : userList1) {
								%>
									<option value="<%=userBean1.getId()%>"><%=userBean1.getName() %></option>
								<%
								}
								%>
								</select></td>
								<td width="60px"><input type="button" value="&gt;&gt;"
									onclick="allright()" class="mubtn ml10 mt15"> <input
									type="button" value="&gt;" onclick="right()"
									class="mubtn ml10 mt15"> <input type="button"
									value="&lt;" onclick="left()" class="mubtn ml10 mt15">
									<input type="button" value="&lt;&lt;" onclick="allleft()"
									class="mubtn ml10 mt15"></td>
								<td>
								<select id="selectedUser" name="selectedUser" class="muSelect" multiple="multiple" size="20">
								<%
								List<UserBean> userList = (ArrayList<UserBean>)request.getAttribute("UserList");
								for (UserBean userBean1 : userList) {
								%>
									<option value="<%=userBean1.getId()%>"><%=userBean1.getName() %></option>
								<%
								}
								%>
								</select></td>
							</tr>
						</table></td>
				</tr>


				<tr>
					<td align="right"></td>
					<td><div class="divBtn ml20 fl mt20" id="btnClicked">保存</div>
						<div class="divBtn ml20 fl mt20" onclick="window.history.back(-1);">返回</div>
					</td>
				</tr>
			</table>
		</form>
		</div>
		<%@ include file="foot.jsp"%>
		<!-- end .container -->
	</div>

</body>
</html>
