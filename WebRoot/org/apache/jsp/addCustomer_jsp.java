package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ewa.bean.*;
import com.ewa.util.*;
import java.util.*;

public final class addCustomer_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write('\n');

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("\n");
      out.write("<title>工程师工作纪要 添加客户</title>\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/scroll.css\" />\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/common.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t// 全部左移\n");
      out.write("\tfunction allleft() {\n");
      out.write("\t\t$(\"#selectedUser\").find(\"option\").appendTo($(\"#selectUser\"))\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t// 全部右移\n");
      out.write("\tfunction allright() {\n");
      out.write("\t\t$(\"#selectUser\").find(\"option\").appendTo($(\"#selectedUser\"))\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\t// 右移\n");
      out.write("\tfunction right() {\n");
      out.write("\t\t$(\"#selectUser\").find(\"option:selected\").appendTo($(\"#selectedUser\"));\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t// 左移\n");
      out.write("\tfunction left() {\n");
      out.write("\t\t$(\"#selectedUser\").find(\"option:selected\").appendTo($(\"#selectUser\"));\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function () {\n");
      out.write("    \t$(\"#btnClicked\").click(function () {\n");
      out.write("    \t\tif($(\"#customername\").val()==\"\"){\n");
      out.write("\t\t\t\talert(\"客户名称不可以为空!\");\n");
      out.write("\t\t\t\treturn;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tvar selected = $(\"#selectedUser\").find(\"option\");\n");
      out.write("\t\t\tif (selected.length <= 0) {\n");
      out.write("\t\t\t\talert(\"请为客户选择账号!\");\n");
      out.write("\t\t\t\treturn;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$(\"#selectedUser\").find(\"option\").attr(\"selected\",true);\n");
      out.write("\t    \t\n");
      out.write("    \t\t$(\"#formId\").submit();\n");
      out.write("    \t\treturn;\n");
      out.write("    \t});\n");
      out.write("\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("</head>\n");
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
      out.write("\t\t\t\t\t<font class=\"fontsong17\">当前用户</font>: <font class=\"fontsong14\">");
      out.print(userBean.getName() );
      out.write("</font>, &nbsp;\n");
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
      out.write("\t\t\t\t\t<li><a href=\"/servlet/Works?howdo=list\">工作纪要</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li class=\"navcurrent\"><a href=\"/servlet/Customer?howdo=list\">客户管理</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/User?howdo=list\">帐号管理</a>\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"titleDiv\">客户添加</div>\n");
      out.write("\t\t<div class=\"titleLineDiv\"></div>\n");
      out.write("\t\t<div class=\"addContentDiv\">\n");
      out.write("\t\t<form action=\"/servlet/Customer\" id=\"formId\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"howdo\" value=\"add\" />\n");
      out.write("\t\t\t<table class=\"addContentTable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td width=\"120px\" align=\"right\">客户:</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"customername\" id=\"customername\" class=\"addInput fl\" />\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td height=\"40px\"></td>\n");
      out.write("\t\t\t\t\t<td></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">帐号:</td>\n");
      out.write("\t\t\t\t\t<td><table>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"selectUser\" class=\"muSelect\" multiple=\"multiple\" size=\"20\">\n");
      out.write("\t\t\t\t\t\t\t\t");

								List<UserBean> userList = (ArrayList<UserBean>)request.getAttribute("UserList");
								for (UserBean userBean1 : userList) {
								
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(userBean1.getId());
      out.write('"');
      out.write('>');
      out.print(userBean1.getName() );
      out.write("</option>\n");
      out.write("\t\t\t\t\t\t\t\t");

								}
								
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"60px\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"button\" value=\"&gt;&gt;\" onclick=\"allright()\" class=\"mubtn ml10 mt15\"> \n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"button\" value=\"&gt;\" onclick=\"right()\" class=\"mubtn ml10 mt15\"> \n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"button\" value=\"&lt;\" onclick=\"left()\" class=\"mubtn ml10 mt15\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<input type=\"button\" value=\"&lt;&lt;\" onclick=\"allleft()\" class=\"mubtn ml10 mt15\">\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<select id=\"selectedUser\" name=\"selectedUser\" class=\"muSelect\" multiple=\"multiple\" size=\"20\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</table></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\"></td>\n");
      out.write("\t\t\t\t\t<td><div class=\"divBtn ml20 fl mt20\" id=\"btnClicked\">保存</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"divBtn ml20 fl mt20\" onclick=\"window.history.back(-1);\">返回</div>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</form>\n");
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
