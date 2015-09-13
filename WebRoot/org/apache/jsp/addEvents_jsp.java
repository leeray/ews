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

public final class addEvents_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	request.setCharacterEncoding("UTF-8");

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
      out.write("<title>工程师工作纪要 添加</title>\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/common.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("$(document).ready(function () {\n");
      out.write("   \t$(\"#btnClicked\").click(function () {\n");
      out.write("   \t\tif($(\"#erjidanwei\").val()==\"\") {\n");
      out.write("\t\t\talert(\"二级单位不可以为空!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("   \t\tif($(\"#kehulianxiren\").val()==\"\"){\n");
      out.write("\t\t\talert(\"客户联系人不可以为空!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\tvar reg = /^(1[0-9]{1}[0-9]{1})+\\d{8}$/;\n");
      out.write("\t\tvar v = $(\"#lianxifangshi\").val();\n");
      out.write("\t\tif(v==\"\") {\n");
      out.write("\t\t\talert(\"联系方式不能为空!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\tif(!reg.test(v)) {\n");
      out.write("\t\t\talert(\"联系方式格式错误!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\tvar lianxi_reg = /^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$/;\n");
      out.write("\t\tvar lianxi = $(\"#lianximail\").val();\n");
      out.write("\t\tif(lianxi==\"\") {\n");
      out.write("\t\t\talert(\"联系邮箱不能为空!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\tif(!lianxi_reg.test(lianxi)) {\n");
      out.write("\t\t\talert(\"联系邮箱格式错误!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\tif($(\"#describe\").val()==\"\") {\n");
      out.write("\t\t\talert(\"事件描述不能为空!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\tif($(\"#describe\").val().length > 1000) {\n");
      out.write("\t\t\talert(\"事件描述超出1000字!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\tif($(\"#phonenumber\").val()==\"\" || isNaN($(\"#phonenumber\").val()) || $(\"#phonenumber\").val().length > 20) {\n");
      out.write("\t\t\talert(\"800CASE号码不能为空，或者格式错误!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\tif($(\"#solution\").val()==\"\") {\n");
      out.write("\t\t\talert(\"解决办法不能为空!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("\t\tif($(\"#solution\").val().length > 1000) {\n");
      out.write("\t\t\talert(\"解决办法超出1000字!\");\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\t}\n");
      out.write("\n");
      out.write("   \t\t$(\"#formId\").submit();\n");
      out.write("   \t\treturn;\n");
      out.write("   \t});\n");
      out.write("\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</head>\n");

List<CustomerBean> customerList = (ArrayList<CustomerBean>)request.getAttribute("CustomerList");

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
      out.write("\t\t<div class=\"titleDiv\">工作纪要添加</div>\n");
      out.write("\t\t<div class=\"titleLineDiv\"></div>\n");
      out.write("\t\t<div class=\"addContentDiv\">\n");
      out.write("\t\t\t<form action=\"/servlet/Works\" id=\"formId\" method=\"post\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"howdo\" value=\"add\" />\n");
      out.write("\t\t\t<table class=\"addContentTable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td width=\"160px\" align=\"right\">客户:</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"\" id=\"\" />\n");
      out.write("\t\t\t\t\t<select name=\"customerid\" id=\"\" class=\"addSelect fl\">\n");
      out.write("\t\t\t\t\t");

					for (CustomerBean customerBean : customerList) {
					
      out.write("\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(customerBean.getId() );
      out.write('"');
      out.write('>');
      out.print(customerBean.getName() );
      out.write("</option>\n");
      out.write("\t\t\t\t\t");

					}
					
      out.write("\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">二级单位:</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"erjidanwei\" type=\"text\" name=\"erjidanwei\" class=\"addInput fl\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">客户联系人:</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"kehulianxiren\" type=\"text\" name=\"kehulianxiren\" class=\"addInput fl\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">联系方式:</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"lianxifangshi\" type=\"text\" name=\"lianxifangshi\" class=\"addInput fl\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">联系邮箱:</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"lianximail\" id=\"lianximail\" class=\"addInput fl\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">事件属性:</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t<select name=\"level\" id=\"\" class=\"addSelect fl\">\n");
      out.write("\t\t\t\t\t\t<option value=\"一级问题\">一级问题</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"二级问题\">二级问题</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"普通问题\">普通问题</option>\n");
      out.write("\t\t\t\t\t\t<option value=\"技术咨询\">技术咨询</option>\n");
      out.write("\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">事件描述(1000字以内):</td>\n");
      out.write("\t\t\t\t\t<td><textarea name=\"describe\" id=\"describe\" class=\"addArea fl\"></textarea></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">是否转800:</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"isphonecall\" id=\"\" class=\"ml15\" value=\"1\" checked/> 是 \n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"isphonecall\" id=\"\" class=\"ml15\" value=\"0\" /> 否\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">800 CASE号码:</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"phonenumber\" id=\"phonenumber\" class=\"addInput fl\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">解决办法(1000字以内):</td>\n");
      out.write("\t\t\t\t\t<td><textarea name=\"solution\" id=\"solution\" class=\"addArea fl\"></textarea></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">是否关闭:</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"isclosed\" id=\"\" class=\"ml15\" value=\"1\" /> 是 \n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"isclosed\" id=\"\" class=\"ml15\" value=\"0\" checked /> 否\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\"></td>\n");
      out.write("\t\t\t\t\t<td><div class=\"divBtn ml20 fl mt20\" id=\"btnClicked\">保存</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"divBtn ml20 fl mt20\" onclick=\"window.history.back(-1);\">返回</div></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t\t</form>\n");
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
