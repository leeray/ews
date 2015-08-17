<%@ page language="java" import="java.util.*,com.ewa.bean.*"
	pageEncoding="utf-8"%>
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

<body>
	<div class="container">
		<div class="header headermiddle">
			<div class="headermleft"></div>

			<div class="headermright vText" style=" float: right">
				<div style="font-size:12px">您好！欢迎您来到工程师工作纪要</div>
				<div style="margin-top: 20px">
					<a href="/login.jsp" target="_blank">登陆</a> <a
						href="/login.jsp?action=logout">退出</a>
				</div>
			</div>
		</div>
		<!-- 导航 -->
		<div class=" headernav">
			<div class=" nav">
				<ul>
					<li class="navcurrent"><a href="/servlet/Works?howdo=list">工作纪要</a>
					</li>
					<li><a href="/servlet/Customer?howdo=list">客户管理</a></li>
					<li><a href="/servlet/User?howdo=list">帐号管理</a></li>
				</ul>
			</div>
		</div>

		<div class="searchDiv">
			<div class="divBtn ml10 fl mt10" onclick="window.history.back(-1);">返回</div>
		</div>

		<div class="titleDiv">工作历史统计</div>

		<div class="titleLineDiv"></div>

		<div class="statEventsDiv">
			<div class="statEventsTitle">客户：联想控股</div>
			<table class="statEventsTable" border="0" cellspacing="0"
				cellpadding="0">

				<tr>
					<td width="120px" align="right">读取账号:</td>
					<td><span style="margin-left: 20px">水电费娃儿额问题</span></td>
				</tr>
				<tr>
					<td align="right">事件属性:</td>
					<td><span style="margin-left: 20px">12</span>
					</td>
				</tr>
				<tr>
					<td align="right">事件描述:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word; line-height: 20px">
							worksBean.getDescribe(，闻味儿水电费色污染轻微而且其污染奇特，额外任务而气温34天然独特人与他如愿，而且其污染奇特，额外任务而气温34天然独特人与他如</span>
					</td>
				</tr>
				<tr>
					<td align="right">二级单位:</td>
					<td><span style="margin-left: 20px;max-width: 700px">serwer</span>
					</td>
				</tr>
				<tr>
					<td align="right">客户联系人:</td>
					<td><span style="margin-left: 20px;max-width: 700px">金先生</span>
					</td>
				</tr>
				<tr>
					<td align="right">联系方式:</td>
					<td><span style="margin-left: 20px;max-width: 700px">13423454365</span>
					</td>
				</tr>
				<tr>
					<td align="right">联系邮箱:</td>
					<td><span style="margin-left: 20px;max-width: 700px">aaaaaaaaaaa@163.com</span>
					</td>
				</tr>
				<tr>
					<td align="right">是否转800:</td>
					<td><span style="margin-left: 20px">是</span></td>
				</tr>
				<tr>
					<td align="right">800 case号码:</td>
					<td><span style="margin-left: 20px">13021389012</span></td>
				</tr>
				<tr>
					<td align="right">解决办法:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word;line-height: 20px">
							啊的然然然然然vvv我水电费水电费问问题为色然然然然然然然然然然呜呜呜呜呜呜韦尔奇我，娃儿问问3423铁通4天固定团。</span>
					</td>
				</tr>
				<tr>
					<td align="right">是否关闭:</td>
					<td><span style="margin-left: 20px">是</span></td>
				</tr>
				<tr>
					<td align="right">更新内容:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word;line-height:20px">啊啊啊啊啊啊啊啊啊啊啊aaaaaaaaaaaaaaaaaaaaaaw啊啊啊啊啊啊啊啊啊啊啊啊
						
					</td>
				</tr>
				<tr>
					<td align="right">创建时间:</td>
					<td><span style="margin-left: 20px">2015-02-05 12:12:12</span>
					</td>
				</tr>

			</table>
		</div>
		<div class="statEventsDiv">
			<div class="statEventsTitle">客户：联想控股</div>
			<table class="statEventsTable" border="0" cellspacing="0"
				cellpadding="0">
				
				<tr>
					<td width="120px" align="right">读取账号:</td>
					<td><span style="margin-left: 20px">水电费娃儿额问题</span></td>
				</tr>
				<tr>
					<td align="right">事件属性:</td>
					<td><span style="margin-left: 20px">12</span>
					</td>
				</tr>
				<tr>
					<td align="right">事件描述:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word; line-height: 20px">
							worksBean.getDescribe(，闻味儿水电费色污染轻微而且其污染奇特，额外任务而气温34天然独特人与他如愿，而且其污染奇特，额外任务而气温34天然独特人与他如</span>
					</td>
				</tr>
				<tr>
					<td align="right">二级单位:</td>
					<td><span style="margin-left: 20px;max-width: 700px">serwer</span>
					</td>
				</tr>
				<tr>
					<td align="right">客户联系人:</td>
					<td><span style="margin-left: 20px;max-width: 700px">金先生</span>
					</td>
				</tr>
				<tr>
					<td align="right">联系方式:</td>
					<td><span style="margin-left: 20px;max-width: 700px">13423454365</span>
					</td>
				</tr>
				<tr>
					<td align="right">联系邮箱:</td>
					<td><span style="margin-left: 20px;max-width: 700px">aaaaaaaaaaa@163.com</span>
					</td>
				</tr>
				<tr>
					<td align="right">是否转800:</td>
					<td><span style="margin-left: 20px">是</span></td>
				</tr>
				<tr>
					<td align="right">800 case号码:</td>
					<td><span style="margin-left: 20px">13021389012</span></td>
				</tr>
				<tr>
					<td align="right">解决办法:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word;line-height: 20px">
							啊的然然然然然vvv我水电费水电费问问题为色然然然然然然然然然然呜呜呜呜呜呜韦尔奇我，娃儿问问3423铁通4天固定团。</span>
					</td>
				</tr>
				<tr>
					<td align="right">是否关闭:</td>
					<td><span style="margin-left: 20px">是</span></td>
				</tr>
				<tr>
					<td align="right">更新内容:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word;line-height:20px">啊啊啊啊啊啊啊啊啊啊啊aaaaaaaaaaaaaaaaaaaaaaw啊啊啊啊啊啊啊啊啊啊啊啊
						
					</td>
				</tr>
				<tr>
					<td align="right">创建时间:</td>
					<td><span style="margin-left: 20px">2015-02-05 12:12:12</span>
					</td>
				</tr>

			</table>
		</div>
		<div class="statEventsDiv">

			<div class="statEventsTitle">客户：联想控股</div>
			<table class="statEventsTable" border="0" cellspacing="0"
				cellpadding="0">
				
				<tr>
					<td width="120px" align="right">读取账号:</td>
					<td><span style="margin-left: 20px">水电费娃儿额问题</span></td>
				</tr>
				<tr>
					<td align="right">事件属性:</td>
					<td><span style="margin-left: 20px">12</span>
					</td>
				</tr>
				<tr>
					<td align="right">事件描述:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word; line-height: 20px">
							worksBean.getDescribe(，闻味儿水电费色污染轻微而且其污染奇特，额外任务而气温34天然独特人与他如愿，而且其污染奇特，额外任务而气温34天然独特人与他如</span>
					</td>
				</tr>
				<tr>
					<td align="right">二级单位:</td>
					<td><span style="margin-left: 20px;max-width: 700px">serwer</span>
					</td>
				</tr>
				<tr>
					<td align="right">客户联系人:</td>
					<td><span style="margin-left: 20px;max-width: 700px">金先生</span>
					</td>
				</tr>
				<tr>
					<td align="right">联系方式:</td>
					<td><span style="margin-left: 20px;max-width: 700px">13423454365</span>
					</td>
				</tr>
				<tr>
					<td align="right">联系邮箱:</td>
					<td><span style="margin-left: 20px;max-width: 700px">aaaaaaaaaaa@163.com</span>
					</td>
				</tr>
				<tr>
					<td align="right">是否转800:</td>
					<td><span style="margin-left: 20px">是</span></td>
				</tr>
				<tr>
					<td align="right">800 case号码:</td>
					<td><span style="margin-left: 20px">13021389012</span></td>
				</tr>
				<tr>
					<td align="right">解决办法:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word;line-height: 20px">
							啊的然然然然然vvv我水电费水电费问问题为色然然然然然然然然然然呜呜呜呜呜呜韦尔奇我，娃儿问问3423铁通4天固定团。</span>
					</td>
				</tr>
				<tr>
					<td align="right">是否关闭:</td>
					<td><span style="margin-left: 20px">是</span></td>
				</tr>
				<tr>
					<td align="right">更新内容:</td>
					<td><div
							style="margin-left: 20px;max-width: 700px;word-break: break-all;word-wrap: break-word;line-height:20px">啊啊啊啊啊啊啊啊啊啊啊aaaaaaaaaaaaaaaaaaaaaaw啊啊啊啊啊啊啊啊啊啊啊啊
						
					</td>
				</tr>
				<tr>
					<td align="right">创建时间:</td>
					<td><span style="margin-left: 20px">2015-02-05 12:12:12</span>
					</td>
				</tr>

			</table>
		</div>

		<!-- end .container -->
	</div>
	<%@ include file="foot.jsp"%>
</body>
</html>
