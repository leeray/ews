<%@ page language="java" import="java.util.*,com.ewa.util.*,com.ewa.bean.*" pageEncoding="utf-8"%>
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

<title>工程师工作纪要 更新</title>
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
   		if($("#erjidanwei").val()=="") {
			alert("二级单位不可以为空!");
			return;
		}
		if($("#erjidanwei").val().length > 200) {
			alert("二级单位超出200字!");
			return;
		}
		
   		if($("#kehulianxiren").val()==""){
			alert("客户联系人不可以为空!");
			return;
		}
		if($("#kehulianxiren").val().length > 200){
			alert("客户联系人超出200字!");
			return;
		}
		
		var reg = /^(1[0-9]{1}[0-9]{1})+\d{8}$/;
		var v = $("#lianxifangshi").val();
		if(v=="") {
			alert("联系方式不能为空!");
			return;
		}
		if(v.length > 200) {
			alert("联系方式超出200字!");
			return;
		}
		if(!reg.test(v)) {
			alert("联系方式格式错误!");
			return;
		}
		
		var lianxi_reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
		var lianxi = $("#lianximail").val();
		if(lianxi=="") {
			alert("联系邮箱不能为空!");
			return;
		}
		if(lianxi.length > 200) {
			alert("联系邮箱超出200字!");
			return;
		}
		if(!lianxi_reg.test(lianxi)) {
			alert("联系邮箱格式错误!");
			return;
		}
		
		if($("#describe").val()=="") {
			alert("事件描述不能为空!");
			return;
		}
		if($("#describe").val().length > 1000) {
			alert("事件描述超出1000字!");
			return;
		}
		
		if($("#phonenumber").val()=="" || isNaN($("#phonenumber").val()) || $("#phonenumber").val().length > 20) {
			alert("800CASE号码不能为空，或者格式错误!");
			return;
		}
		
		if($("#solution").val()=="") {
			alert("解决办法不能为空!");
			return;
		}

		if($("#solution").val().length > 1000) {
			alert("解决办法超出1000字!");
			return;
		}
		
		if($("#newcontent").val()=="") {
			alert("更新内容不能为空!");
			return;
		}

		if($("#newcontent").val().length > 1000) {
			alert("更新内容超出1000字!");
			return;
		}
   	
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
					<li class="navcurrent"><a href="/servlet/Works?howdo=list&pageNum=1">工作纪要</a></li>
					<%
					if (sessionUser!=null && sessionUser.getPriv() == 0) {
					%>
					<li><a href="/servlet/Customer?howdo=list&pageNum=1">客户管理</a></li>
					<li><a href="/servlet/User?howdo=list&pageNum=1">帐号管理</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
		<div class="titleDiv">工作纪要更新</div>
		<div class="titleLineDiv"></div>
		<div class="addContentDiv">
		<form action="/servlet/Works" id="formId" method="post">
			<input type="hidden" name="howdo" value="update" />
			<input type="hidden" name="id" value="<%=request.getAttribute("fid")%>" />
			<table class="addContentTable" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="180px" align="right">客户:</td>
					<td>
					<select name="customerid" id="" class="addSelect fl" onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex;">
						<option value="<%=worksBean.getCustomerid() %>"><%=worksBean.getCustomername() %></option>
					</select></td>
				</tr>
				<tr>
					<td align="right">二级单位:</td>
					<td><input type="text" name="erjidanwei" id="erjidanwei" class="addInput fl" value="<%=worksBean.getErjidanwei() %>"  readonly/>
					</td>
				</tr>
				<tr>
					<td align="right">客户联系人:</td>
					<td><input type="text" name="kehulianxiren" id="kehulianxiren" class="addInput fl" value="<%=worksBean.getKehulianxiren() %>"  readonly/>
					</td>
				</tr>
				<tr>
					<td align="right">联系方式:</td>
					<td><input type="text" name="lianxifangshi" id="lianxifangshi" class="addInput fl" value="<%=worksBean.getLianxifangshi() %>"  readonly/>
					</td>
				</tr>
				<tr>
					<td align="right">联系邮箱:</td>
					<td><input type="text" name="lianximail" id="lianximail" class="addInput fl" value="<%=worksBean.getLianximail() %>"  readonly/>
					</td>
				</tr>
				
				<tr>
					<td align="right">事件属性:</td>
					<td>
						<select name="level" id="" class="addSelect fl">
							<option value="一级问题" <% if (worksBean.getLevel().equals("一级问题")) { %> selected="true" <% } %>>一级问题</option>
							<option value="二级问题" <% if (worksBean.getLevel().equals("二级问题")) { %> selected="true" <% } %>>二级问题</option>
							<option value="普通问题" <% if (worksBean.getLevel().equals("普通问题")) { %> selected="true" <% } %>>普通问题</option>
							<option value="技术咨询" <% if (worksBean.getLevel().equals("技术咨询")) { %> selected="true" <% } %>>技术咨询</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">事件描述(1000字以内):</td>
					<td><textarea name="describe" id="describe" class="addArea fl" readonly><%=worksBean.getDescribe() %></textarea>
					</td>
				</tr>
				
				<tr>
					<td align="right">是否转800:</td>
					<td>
						<input type="radio" name="isphonecall" id="" class="ml15" value="1" <% if (worksBean.isIsphonecall()) { %> checked="checked" <% } %> /> 是 
						<input type="radio" name="isphonecall" id="" class="ml15" value="0" <% if (!worksBean.isIsphonecall()) { %> checked="checked" <% } %>/> 否</td>
				</tr>
				<tr>
					<td align="right">800 CASE号码:</td>
					<td><input type="text" name="phonenumber" id="phonenumber" class="addInput fl" value="<%=worksBean.getPhonecallnumber() %>"/></td>
				</tr>
				<tr>
					<td align="right">解决办法(1000字以内):</td>
					<td><textarea name="solution" id="solution" class="addArea fl" readonly><%=worksBean.getSolution() %></textarea>
					</td>
				</tr>
				<tr>
					<td align="right">是否关闭:</td>
					<td>
						<input type="radio" name="isclosed" id="" class="ml15" value="1" <% if (worksBean.getIsclosed()==1) { %> checked="checked" <% } %>/> 是 
						<input type="radio" name="isclosed" id="" class="ml15" value="0" <% if (worksBean.getIsclosed()==0) { %> checked="checked" <% } %> /> 否
					</td>
				</tr>
				<tr>
					<td align="right">更新内容(1000字以内):</td>
					<td><textarea name="newcontent" id="newcontent" class="addArea fl"><% if(worksBean.getNewcontent()!=null) {%> <%=worksBean.getNewcontent() %> <%} %></textarea></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td><div class="divBtn ml20 fl mt20" id="btnClicked">保存</div>
						<div class="divBtn ml20 fl mt20" onclick="window.history.back(-1);">返回</div></td>
				</tr>
			</table>

		</div>
		<%@ include file="foot.jsp"%>
		<!-- end .container -->
	</div>

</body>
</html>
