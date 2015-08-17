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

<title>工程师工作纪要 登陆</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/css/css.css" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
    	$("#btnClicked").click(function () {
    		$("#formId").submit();
    		return;
    	});
		$("input[name=pwdPrompt]").focus(function () {  
			$("input[name=pwdPrompt]").hide(); 
			$("input[name=password]").show().focus(); 
		}); 
		$("input[name=password]").blur(function () { 
			if ($(this).val() == "") { 
				$("input[name=pwdPrompt]").show(); 
				$("input[name=password]").hide(); 
			} 
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
String action = request.getParameter("action");
if (action !=null && action.equals("logout")) {
	session.setAttribute("userBean", null);	
	session.setAttribute("userid", null);
}
%>
<body>
	<div class="container" >
	<div style="background: #f6f6f6; min-width: 1080px">
		<div class="header h80" >
			<div class="loginTop">工程师工作纪要</div>
		</div></div>
		<div class="loginPage">

			<div class="content">
				<div class="loginDiv">
					<div class="loginDiv1">
						<img src="/images/logint1.png" />
					</div>
					<div class="loginDiv2">
				       	 <form action="/servlet/User" id="formId">
                                                 <table width="325" border="0" cellspacing="0" cellpadding="0"
							class="registerTable">
							<tr>
								<td align="center" height="114px" valign="top">
								</td>
							</tr>
							<tr>
								<td>
                                    <input type="hidden" name="howdo" value="login" />
									<div >
										<input type="text" class="loginInput1" name="username" 
											value="账号名" onfocus="javascript:if(this.value=='账号名')this.value='';" />
										<input type="text" class="loginInput2" name="pwdPrompt" value="密码" />
										<input type="password" class="loginInput2" name="password" style=" display:none;"  /> 
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="loginBtn" style="margin-top: 10px;" id="btnClicked">登&nbsp;&nbsp;录</div>
								</td>
							</tr>
						</table>
                                              </form>
					</div>
				</div>
			</div>

		</div>
		<div style="background: #ffffff">
		<%@ include file="/foot.jsp"%>
		</div>
		<!-- end .container -->
	</div>

</body>
</html>
