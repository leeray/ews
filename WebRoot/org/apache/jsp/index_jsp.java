package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ewa.bean.*;
import com.ewa.util.*;
import java.util.*;
import com.ewa.bean.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/SessionUser.jsp");
    _jspx_dependants.add("/foot.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\r');
      out.write('\n');

UserBean sessionUser = (UserBean)session.getAttribute("userBean");

      out.write("\r\n");
      out.write("\r\n");
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("\n");
      out.write("<title>工程师工作纪要</title>\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/css.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/calendar.css\"/>\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"/js/common.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"/js/My97DatePicker/WdatePicker.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function () {\n");
      out.write("    \t$(\"#btnClicked\").click(function () {\n");
      out.write("    \t\t$(\"#formId\").submit();\n");
      out.write("    \t\treturn;\n");
      out.write("    \t});\n");
      out.write("\t\t$(\"#pageSize\").change(function(){\n");
      out.write("\t\t\t$(\"#formId\").submit();\n");
      out.write("    \t\treturn;\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("</script>\n");

ErrorInfo errorInfo = (ErrorInfo)request.getAttribute("ErrorInfo");
if (errorInfo!=null) {

      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("alert('");
      out.print(errorInfo.getDetailMessage() );
      out.write("');\n");
      out.write("</script>\n");

}

      out.write("\n");
      out.write("\n");
      out.write("</head>\n");

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


      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"header headermiddle\">\n");
      out.write("\t\t\t<div class=\"headermleft\"></div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"headermright vText\" style=\" float: right\">\n");
      out.write("\t\t\t\t<div style=\"font-size:12px\">您好！欢迎您来到工程师工作纪要</div>\n");
      out.write("\t\t\t\t<div style=\"margin-top: 20px\">\n");
      out.write("\t\t\t\t");
 
				UserBean userBean = (UserBean)session.getAttribute("userBean");
				if (userBean == null) {
				
      out.write("\n");
      out.write("\t\t\t\t\t<a href=\"/login.jsp\" target=\"_blank\">登陆</a>\n");
      out.write("\t\t\t\t");

				} else {
				
      out.write("\n");
      out.write("\t\t\t\t\t<font class=\"fontsong17\">当前用户</font>: <font class=\"fontsong14\"><a href =\"/servlet/User?howdo=password\">");
      out.print(userBean.getName() );
      out.write("</a></font>, &nbsp;\n");
      out.write("\t\t\t\t\t<font class=\"fontsong17\"><a href=\"/login.jsp?action=logout\">退出</a></font>\n");
      out.write("\t\t\t\t");
 
				}
				
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- 导航 -->\n");
      out.write("\t\t<div class=\" headernav\">\n");
      out.write("\t\t\t<div class=\" nav\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li class=\"navcurrent\"><a href=\"/servlet/Works?howdo=list&pageNum=1\">工作纪要</a></li>\n");
      out.write("\t\t\t\t\t");

					if (sessionUser!=null && sessionUser.getPriv() == 0) {
					
      out.write("\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/Customer?howdo=list&pageNum=1\">客户管理</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/User?howdo=list&pageNum=1\">帐号管理</a></li>\n");
      out.write("\t\t\t\t\t");

					}
					
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<form action=\"/servlet/Works\" id=\"formId\">\n");
      out.write("\t\t<div class=\"searchDiv\">\n");
      out.write("\t\t<input type=\"hidden\" name=\"howdo\" value=\"find\" />\n");
      out.write("\t\t\t<div class=\"grayBtn w80 fl\" style=\"margin-left: 15px\"\n");
      out.write("\t\t\t\tonclick=\"pageHref('/servlet/Works?howdo=addPage')\">添加</div>\n");
      out.write("\n");
      out.write("\t\t\t<input name=\"username\" id=\"\" class=\"searchInput fl\" style=\"margin-left: 30px\"\n");
      out.write("\t\t\t\tvalue=\"");
 if(username!=null) {
      out.print(username );
}else{
      out.write('用');
      out.write('户');
}
      out.write("\" onfocus=\"javascript:if(this.value=='用户' || this.value=='null')this.value='';\"\n");
      out.write("\t\t\t\tonBlur=\"javascript:if(this.value=='' || this.value=='null')this.value='用户';\" />\n");
      out.write("\t\t\t<input name=\"customername\" id=\"\" class=\"searchInput fl\" \n");
      out.write("\t\t\t\tvalue=\"");
 if(customername!=null) {
      out.print(customername );
}else{
      out.write('客');
      out.write('户');
}
      out.write("\" onfocus=\"javascript:if(this.value=='客户')this.value='';\"\n");
      out.write("\t\t\t\tonBlur=\"javascript:if(this.value=='')this.value='客户';\" /> \n");
      out.write("\t\t\t<select name=\"isclosed\" id=\"\" class=\"searchSelect fl\">\n");
      out.write("\t\t\t\t<option value=\"事件状态\">事件状态</option>\n");
      out.write("\t\t\t\t<option value=\"0\" ");
 if(closed == 0) {
      out.write(" selected ");
}
      out.write(">开启</option>\n");
      out.write("\t\t\t\t<option value=\"1\" ");
 if(closed == 1) {
      out.write(" selected ");
}
      out.write(">关闭</option>\n");
      out.write("\t\t\t</select> \n");
      out.write("\t\t\t<input name=\"createtime\" id=\"createtime\" class=\"searchInput fl\" value=\"");
 if(createtime!=null) {
      out.print(createtime );
}else{
      out.write("新增时间");
}
      out.write("\"\n");
      out.write("\t\t\t\tonfocus=\"javascript:if(this.value=='新增时间')this.value='';\" \n");
      out.write("\t\t\t\tonBlur=\"javascript:if(this.value=='')this.value='新增时间';\"\n");
      out.write("\t\t\t\tonClick=\"WdatePicker({errDealMode:1})\" /> \n");
      out.write("\t\t\t<input name=\"closetime\" id=\"closetime\" class=\"searchInput fl\" value=\"");
 if(closetime!=null) {
      out.print(closetime );
}else{
      out.write("关闭时间");
}
      out.write("\"\n");
      out.write("\t\t\t\tonfocus=\"javascript:if(this.value=='关闭时间')this.value='';\"\n");
      out.write("\t\t\t\tonBlur=\"javascript:if(this.value=='')this.value='关闭时间';\"\n");
      out.write("\t\t\t\tonClick=\"WdatePicker({errDealMode:1})\" />\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"grayBtn w80 fl\" style=\"margin-left: 15px\" id=\"btnClicked\">查询</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"forPageTop\">\n");
      out.write("\t\t\t共 <span style=\"color:#120eb8\">");
      out.print(pageCount );
      out.write("</span> 条\n");
      out.write("\t\t\t&nbsp;&nbsp; \n");
      out.write("\t\t\t每页 \n");
      out.write("\t\t\t<select id=\"pageSize\" name=\"pageSize\" style=\"width:45px\">\n");
      out.write("\t\t\t\t<option value=\"25\"");
 if (pageSize == 25) { 
      out.write(" selected=\"true\" ");
 } 
      out.write(">25</option>\n");
      out.write("\t\t\t\t<option value=\"50\"");
 if (pageSize == 50) { 
      out.write(" selected=\"true\" ");
 } 
      out.write(">50</option>\n");
      out.write("\t\t\t\t<option value=\"100\"");
 if (pageSize == 100) { 
      out.write(" selected=\"true\" ");
 } 
      out.write(">100</option>\n");
      out.write("\t\t\t</select> \n");
      out.write("\t\t\t条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<div class=\"rTableDiv\">\n");
      out.write("\n");
      out.write("\t\t\t<table class=\"rinTb\" width=\"100%\" border=\"0\" cellspacing=\"0\"\n");
      out.write("\t\t\t\tcellpadding=\"0\">\n");
      out.write("\t\t\t\t<tr class=\"rinTbH\">\n");
      out.write("\t\t\t\t\t<th scope=\"col\">ID</th>\n");
      out.write("\t\t\t\t\t<th scope=\"col\">客户</th>\n");
      out.write("\t\t\t\t\t<th scope=\"col\">事件属性</th>\n");
      out.write("\t\t\t\t\t<th scope=\"col\">是否转800</th>\n");
      out.write("\t\t\t\t\t<th scope=\"col\">800 case号码</th>\n");
      out.write("\t\t\t\t\t<th scope=\"col\">是否关闭</th>\n");
      out.write("\t\t\t\t\t<th scope=\"col\">时间</th>\n");
      out.write("\t\t\t\t\t<th scope=\"col\" width=\"200px\">操作</th>\n");
      out.write("\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t");

				List<WorksBean> workList = (ArrayList<WorksBean>)request.getAttribute("WorksList");
				int i = 0;
				i = (pageNum - 1) * pageSize + 1;
				
				for (WorksBean works : workList) {
				
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(i++ );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(works.getCustomername() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(works.getLevel() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
 if (works.isIsphonecall()) { 
      out.write('是');
      out.write(' ');
} else {
      out.write(' ');
      out.write('否');
} 
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(works.getPhonecallnumber() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
 if (works.getIsclosed() == 1) { 
      out.write('关');
      out.write('闭');
      out.write(' ');
} else {
      out.write(' ');
      out.write('开');
      out.write('启');
} 
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>");
      out.print(works.getCreatedate() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<div class=\"operBtn\"\n");
      out.write("\t\t\t\t\t\t\tonclick=\"pageHref('/servlet/Works?howdo=edit&id=");
      out.print(works.getId());
      out.write("')\">更新</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"operBtn\" style=\"width:70px\"\n");
      out.write("\t\t\t\t\t\t\tonclick=\"pageHref('/servlet/Works?howdo=history&id=");
      out.print(works.getId());
      out.write("')\">查看历史</div>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t");

				}
				
      out.write("\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t<div class=\"forPage\">\n");
      out.write("\t\t\t");

			if (howdo==null || howdo.isEmpty()) {
			
      out.write("\n");
      out.write("\t\t\t\t共 <span style=\"color:#120eb8\">");
      out.print(pageAll);
      out.write("</span> 页&nbsp;&nbsp; 当前第 <span\n");
      out.write("\t\t\t\t\tstyle=\"color:#120eb8\">");
      out.print(pageNum);
      out.write("</span> 页 <a href=\"/servlet/Works?howdo=list&pageNum=1&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;\n");
      out.write("\t\t\t\t<a href=\"/servlet/Works?howdo=list&pageNum=");
      out.print( pageNum-1 );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">上一页</a> &nbsp;\n");
      out.write("\t\t\t\t<a href=\"/servlet/Works?howdo=list&pageNum=");
      out.print( pageNum+1 );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">下一页</a>&nbsp;\n");
      out.write("\t\t\t\t<a href=\"/servlet/Works?howdo=list&pageNum=");
      out.print( pageAll );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\t\t");

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
				
			
      out.write("\n");
      out.write("\t\t\t\t共 <span style=\"color:#120eb8\">");
      out.print(pageAll);
      out.write("</span> 页&nbsp;&nbsp; 当前第 <span\n");
      out.write("\t\t\t\t\tstyle=\"color:#120eb8\">");
      out.print(pageNum);
      out.write("</span> 页 <a href=\"/servlet/Works?howdo=find&");
      out.print(where );
      out.write("&pageNum=1&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;\n");
      out.write("\t\t\t\t<a href=\"/servlet/Works?howdo=find&");
      out.print(where );
      out.write("&pageNum=");
      out.print( pageNum-1 );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">上一页</a> &nbsp;\n");
      out.write("\t\t\t\t<a href=\"/servlet/Works?howdo=find&");
      out.print(where );
      out.write("&pageNum=");
      out.print( pageNum+1 );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">下一页</a>&nbsp;\n");
      out.write("\t\t\t\t<a href=\"/servlet/Works?howdo=find&");
      out.print(where );
      out.write("&pageNum=");
      out.print( pageAll );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">末页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\t\t");

			}
			
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<title>智友汇</title>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/css.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"footer\">\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"footerbottom\">\r\n");
      out.write("\t<div style=\"margin-top: 10px;margin-bottom: 30px\">Copyright&copy;2015\r\n");
      out.write("\t\t\t北京恒光数码科技有限公司 版权所有</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\n");
      out.write("\t\t<!-- end .container -->\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
