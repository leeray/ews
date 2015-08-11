package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ewa.bean.*;
import java.util.*;
import com.ewa.bean.*;

public final class statEvents_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/SessionUser.jsp");
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
      out.write('\r');
      out.write('\n');

UserBean sessionUser = (UserBean)session.getAttribute("userBean");

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<title>工程师工作纪要 查看</title>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/css.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/common.js\"></script>\r\n");
      out.write("</head>\r\n");
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
      out.write("\t\t\t\t\t<li class=\"navcurrent\"><a href=\"/servlet/Works?howdo=list\">工作纪要</a></li>\r\n");
      out.write("\t\t\t\t\t");

					if (sessionUser!=null && sessionUser.getPriv() == 0) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/Customer?howdo=list\">客户管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/User?howdo=list\">帐号管理</a></li>\r\n");
      out.write("\t\t\t\t\t");

					}
					
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"searchDiv\">\r\n");
      out.write("\t\t\t<div class=\"divBtn ml10 fl mt10\" onclick=\"window.history.back(-1);\">返回</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"titleDiv\">工作历史统计</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"titleLineDiv\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"addContentDiv\">\r\n");
      out.write("\t\t<table class=\"addContentTable\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t");

		int pageNum = (Integer)request.getAttribute("pageNum");
		int pageCount = (Integer)request.getAttribute("pageCount");
		int pageSize = (Integer)request.getAttribute("pageSize");
		int pageAll = (Integer)request.getAttribute("pageAll");
		List<WorksBean> workList = (ArrayList<WorksBean>)request.getAttribute("WorksList");
		int i = 0;
		i = (pageNum - 1) * pageSize + 1;
		
		for (WorksBean worksBean : workList) {
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"120px\" align=\"right\">客户:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getCustomername() );
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"120px\" align=\"right\">读取账号:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getUsername() );
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">事件属性:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getLevel() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">事件描述:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getDescribe() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">二级单位:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getErjidanwei() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">客户联系人:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getKehulianxiren() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">联系方式:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getLianxifangshi() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">联系邮箱:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getLianximail() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">是否转800:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
 if (worksBean.isIsphonecall()) { 
      out.write('是');
      out.write(' ');
} else {
      out.write(' ');
      out.write('否');
} 
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">800 case号码:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
      out.print(worksBean.getPhonecallnumber() );
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">解决办法:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px;max-width: 700px\">");
      out.print(worksBean.getSolution() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">是否关闭:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
 if (worksBean.getIsclosed() == 1) { 
      out.write('是');
      out.write(' ');
} else {
      out.write(' ');
      out.write('否');
} 
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">更新内容:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
 if(worksBean.getNewcontent() != null) { 
      out.write(' ');
      out.print(worksBean.getNewcontent() );
      out.write(' ');
}
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"right\">创建时间:</td>\r\n");
      out.write("\t\t\t\t\t<td><span style=\"margin-left: 20px\">");
 if(worksBean.getCreatedate() != null) { 
      out.write(' ');
      out.print(worksBean.getCreatedate() );
      out.write(' ');
}
      out.write("</span></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" style=\"border-bottom:1px dashed #000000\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t");

		}
		
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
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