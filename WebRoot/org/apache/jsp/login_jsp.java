package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ewa.util.*;
import com.ewa.bean.*;
import java.util.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("\n");
      out.write("<title>工程师工作纪要 登陆</title>\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/css.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function () {\n");
      out.write("    \t$(\"#btnClicked\").click(function () {\n");
      out.write("    \t\t$(\"#formId\").submit();\n");
      out.write("    \t\treturn;\n");
      out.write("    \t});\n");
      out.write("\t\t$(\"input[name=pwdPrompt]\").focus(function () {  \n");
      out.write("\t\t\t$(\"input[name=pwdPrompt]\").hide(); \n");
      out.write("\t\t\t$(\"input[name=password]\").show().focus(); \n");
      out.write("\t\t}); \n");
      out.write("\t\t$(\"input[name=password]\").blur(function () { \n");
      out.write("\t\t\tif ($(this).val() == \"\") { \n");
      out.write("\t\t\t\t$(\"input[name=pwdPrompt]\").show(); \n");
      out.write("\t\t\t\t$(\"input[name=password]\").hide(); \n");
      out.write("\t\t\t} \n");
      out.write("\t\t});\n");
      out.write("\t});\n");
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
      out.write("</head>\n");

String action = request.getParameter("action");
if (action !=null && action.equals("logout")) {
	session.setAttribute("userBean", null);	
	session.setAttribute("userid", null);
}

      out.write("\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container\" >\n");
      out.write("\t<div style=\"background: #f6f6f6; min-width: 1080px\">\n");
      out.write("\t\t<div class=\"header h80\" >\n");
      out.write("\t\t\t<div class=\"loginTop\">工程师工作纪要</div>\n");
      out.write("\t\t</div></div>\n");
      out.write("\t\t<div class=\"loginPage\">\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"content\">\n");
      out.write("\t\t\t\t<div class=\"loginDiv\">\n");
      out.write("\t\t\t\t\t<div class=\"loginDiv1\">\n");
      out.write("\t\t\t\t\t\t<img src=\"/images/logint1.png\" />\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"loginDiv2\">\n");
      out.write("\t\t\t\t       \t <form action=\"/servlet/User\" id=\"formId\" method=\"post\">\n");
      out.write("                                                 <table width=\"325\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\n");
      out.write("\t\t\t\t\t\t\tclass=\"registerTable\">\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"center\" height=\"114px\" valign=\"top\">\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("                                    <input type=\"hidden\" name=\"howdo\" value=\"login\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t<div >\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"loginInput1\" name=\"username\" \n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"账号名\" onfocus=\"javascript:if(this.value=='账号名')this.value='';\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"loginInput2\" name=\"pwdPrompt\" value=\"密码\" />\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"password\" class=\"loginInput2\" name=\"password\" style=\" display:none;\"  /> \n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"loginBtn\" style=\"margin-top: 10px;\" id=\"btnClicked\">登&nbsp;&nbsp;录</div>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("                                              </form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div style=\"background: #ffffff\">\n");
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
      out.write("\t\t</div>\n");
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
