package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ewa.bean.*;
import java.util.*;

public final class viewEvents_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("\n");
      out.write("<title>工程师工作纪要 查看</title>\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\" />\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"js/common.js\"></script>\n");
      out.write("</head>\n");


WorksBean worksBean = (WorksBean)request.getAttribute("worksBean");

if (worksBean == null) {
	return;
}


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
      out.write("\t\t\t\t\t<li class=\"navcurrent\"><a href=\"/servlet/Works?howdo=list\">工作纪要</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/Customer?howdo=list\">客户管理</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/User?howdo=list\">帐号管理</a></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"titleDiv\">工作纪要查看</div>\n");
      out.write("\t\t<div class=\"titleLineDiv\"></div>\n");
      out.write("\t\t<div class=\"addContentDiv\">\n");
      out.write("\t\t\t<table class=\"addContentTable\" border=\"0\" cellspacing=\"0\"\n");
      out.write("\t\t\t\tcellpadding=\"0\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td width=\"120px\" align=\"right\">客户:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getCustomername() );
      out.write("</span></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td width=\"120px\" align=\"right\">工程师:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getUsername() );
      out.write("</span></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">事件属性:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getLevel() );
      out.write("</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">事件描述:</td>\n");
      out.write("\t\t\t\t\t<td><div class=\"lineDiv\">");
      out.print(worksBean.getDescribe() );
      out.write("</div>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">二级单位:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getErjidanwei() );
      out.write("</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">客户联系人:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getKehulianxiren() );
      out.write("</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">联系方式:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getLianxifangshi() );
      out.write("</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">联系邮箱:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getLianximail() );
      out.write("</span>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">是否转800:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
 if (worksBean.isIsphonecall()) { 
      out.write('是');
      out.write(' ');
} else {
      out.write(' ');
      out.write('否');
} 
      out.write("</span></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">800 case号码:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getPhonecallnumber() );
      out.write("</span></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">解决办法:</td>\n");
      out.write("\t\t\t\t\t<td><div class=\"lineDiv\">");
      out.print(worksBean.getSolution() );
      out.write("</div>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">是否关闭:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px \">");
 if (worksBean.getIsclosed() == 1) { 
      out.write('关');
      out.write('闭');
      out.write(' ');
} else {
      out.write(' ');
      out.write('开');
      out.write('启');
} 
      out.write("</span></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">更新内容:</td>\n");
      out.write("\t\t\t\t\t<td><div class=\"lineDiv\">");
 if(worksBean.getNewcontent() != null) { 
      out.write(' ');
      out.print(worksBean.getNewcontent() );
      out.write(' ');
}
      out.write("</div></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t");

				if (worksBean.getIsclosed() == 1 && worksBean.getClosedate()!=null) {
				
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\">关闭时间:</td>\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getClosedate() );
      out.write("</span></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t");

				}
				
      out.write("\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=\"right\"></td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<div class=\"divBtn ml20 fl mt20\" onclick=\"window.history.back(-1);\">返回</div></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\n");
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
