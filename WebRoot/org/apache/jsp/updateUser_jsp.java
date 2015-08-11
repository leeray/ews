package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ewa.bean.*;
import com.ewa.util.*;
import java.util.*;

public final class updateUser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
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

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write('\r');
      out.write('\n');

ErrorInfo errorInfo = (ErrorInfo)request.getAttribute("ErrorInfo");
if (errorInfo!=null) {

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("alert('");
      out.print(errorInfo.getDetailMessage() );
      out.write("');\r\n");
      out.write("</script>\r\n");

}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<title>工程师工作纪要 编辑帐号</title>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/common.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function () {\r\n");
      out.write("    \t$(\"#btnClicked\").click(function () {\r\n");
      out.write("    \t\t$(\"#formId\").submit();\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t});\r\n");
      out.write("\r\n");
      out.write("\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");

UserBean userBean1 = (UserBean)request.getAttribute("userBean");
if (userBean1 == null) {
	return;
}

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"header headermiddle\">\r\n");
      out.write("\t\t\t<div class=\"headermleft\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"headermright vText\" style=\" float: right\">\r\n");
      out.write("\t\t\t\t<div style=\"font-size:12px\">您好！欢迎您来到工程师工作纪要</div>\r\n");
      out.write("\t\t\t\t<div style=\"margin-top: 20px\">\r\n");
      out.write("\t\t\t\t");
 
				UserBean userBean = (UserBean)session.getAttribute("userBean");
				if (userBean == null) {
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"/login.jsp\" target=\"_blank\">登陆</a>\r\n");
      out.write("\t\t\t\t");

				} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"/login.jsp?action=logout\">退出</a>\r\n");
      out.write("\t\t\t\t");
 
				}
				
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 导航 -->\r\n");
      out.write("\t\t<div class=\" headernav\">\r\n");
      out.write("\t\t\t<div class=\" nav\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/Works?howdo=list\">工作纪要</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/Customer?howdo=list\">客户管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li  class=\"navcurrent\"><a href=\"/servlet/User?howdo=list\">帐号管理</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"titleDiv\">帐号编辑</div>\r\n");
      out.write("\t\t<div class=\"titleLineDiv\"></div>\r\n");
      out.write("\t\t<div class=\"addContentDiv\">\r\n");
      out.write("\t\t<form action=\"/servlet/User\" id=\"formId\">\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"howdo\" value=\"update\" hidden/>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"id\" value=\"");
      out.print(userBean1.getId());
      out.write("\" hidden/>\r\n");
      out.write("\t\t\t<table class=\"addContentTable\" border=\"0\" cellspacing=\"0\"\r\n");
      out.write("\t\t\t\tcellpadding=\"0\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"120px\" align=\"right\">账号:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"username\" id=\"\" class=\"addInput fl\" value=\"");
      out.print(userBean1.getName() );
      out.write("\" readonly/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">密码:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"password\" id=\"\" class=\"addInput fl\" value=\"\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">确认密码:</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"password\" name=\"confirPassword\" id=\"\" class=\"addInput fl\" value=\"\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">描述:</td>\r\n");
      out.write("\t\t\t\t\t<td><textarea name=\"describe\" id=\"\" class=\"addArea fl\">");
      out.print(userBean1.getDescribe() );
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\"></td>\r\n");
      out.write("\t\t\t\t\t<td><div class=\"divBtn ml20 fl mt20\" id=\"btnClicked\">保存</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"divBtn ml20 fl mt20\" onclick=\"window.history.back(-1);\">返回</div></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
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
      out.write("\r\n");
      out.write("\t\t<!-- end .container -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
