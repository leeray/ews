package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ewa.bean.*;
import com.ewa.util.*;
import java.util.*;

public final class customerManage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>工程师工作纪要 客户管理</title>\r\n");
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
      out.write("\t\t$(\"#pageSize\").change(function(){\r\n");
      out.write("\t\t\t$(\"#formId\").submit();\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t})\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");

String howdo = (String)request.getAttribute("howdo");
String username = (String)request.getAttribute("username");

int pageNum = (Integer)request.getAttribute("pageNum");
int pageCount = (Integer)request.getAttribute("pageCount");
int pageSize = (Integer)request.getAttribute("pageSize");
int pageAll = (Integer)request.getAttribute("pageAll");

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
      out.write("\t\t\t\t\t<li class=\"navcurrent\"><a href=\"/servlet/Customer?howdo=list\">客户管理</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/servlet/User?howdo=list\">帐号管理</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form action=\"/servlet/Customer\" id=\"formId\">\r\n");
      out.write("\t\t<div class=\"searchDiv\">\r\n");
      out.write("\t\t<input type=\"text\" name=\"howdo\" value=\"find\" hidden/>\r\n");
      out.write("\t\t\t<div class=\"grayBtn w80 fl\" style=\"margin-left: 15px\"\r\n");
      out.write("\t\t\t\tonclick=\"pageHref('/servlet/Customer?howdo=addPage')\">添加</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<input name=\"username\" id=\"\" class=\"searchInput fl\" style=\"margin-left: 30px\"\r\n");
      out.write("\t\t\t\tvalue=\"");
 if(username!=null) {
      out.print(username );
}else{
      out.write("客户名称");
}
      out.write("\"\r\n");
      out.write("\t\t\t\tonfocus=\"javascript:if(this.value=='客户名称')this.value='';\"\r\n");
      out.write("\t\t\t\tonBlur=\"javascript:if(this.value=='')this.value='客户名称';\" />\r\n");
      out.write("\t\t\t<div class=\"grayBtn w80 fl\" style=\"margin-left: 15px\" id=\"btnClicked\">查询</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"forPageTop\">\r\n");
      out.write("\t\t\t共 <span style=\"color:#120eb8\">");
      out.print(pageCount );
      out.write("</span> 条\r\n");
      out.write("\t\t\t&nbsp;&nbsp; \r\n");
      out.write("\t\t\t每页 \r\n");
      out.write("\t\t\t<select id=\"pageSize\" name=\"pageSize\" style=\"width:45px\">\r\n");
      out.write("\t\t\t\t<option value=\"25\"");
 if (pageSize == 25) { 
      out.write(" selected=\"true\" ");
 } 
      out.write(">25</option>\r\n");
      out.write("\t\t\t\t<option value=\"50\"");
 if (pageSize == 50) { 
      out.write(" selected=\"true\" ");
 } 
      out.write(">50</option>\r\n");
      out.write("\t\t\t\t<option value=\"100\"");
 if (pageSize == 100) { 
      out.write(" selected=\"true\" ");
 } 
      out.write(">100</option>\r\n");
      out.write("\t\t\t</select> \r\n");
      out.write("\t\t\t条&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"rTableDiv\">\r\n");
      out.write("\t\t\t<table class=\"rinTb\" width=\"100%\" border=\"0\" cellspacing=\"0\"\r\n");
      out.write("\t\t\t\tcellpadding=\"0\">\r\n");
      out.write("\t\t\t\t<tr class=\"rinTbH\">\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">ID</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">客户</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">描述</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\" width=\"200px\">操作</th>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
 
				List<CustomerBean> customerList = (ArrayList<CustomerBean>)request.getAttribute("CustomerList");
				int i = 0;
				i = (pageNum - 1) * pageSize + 1;
				for (CustomerBean customer : customerList) {
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(i++ );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(customer.getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t<td><div class=\"operBtn\"\r\n");
      out.write("\t\t\t\t\t\t\tonclick=\"pageHref('/servlet/Customer?howdo=edit&id=");
      out.print(customer.getId());
      out.write("')\">编辑</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"operBtn\" onclick=\"pageHref('/servlet/Customer?howdo=del&id=");
      out.print(customer.getId());
      out.write("')\">删除</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
 
				}
				
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div class=\"forPage\">\r\n");
      out.write("\t\t\t");

			if (howdo==null || howdo.isEmpty() || username==null || username.isEmpty()) {
			
      out.write("\r\n");
      out.write("\t\t\t\t共 <span style=\"color:#120eb8\">");
      out.print(pageAll);
      out.write("</span> 页&nbsp;&nbsp; 当前第 <span\r\n");
      out.write("\t\t\t\t\tstyle=\"color:#120eb8\">");
      out.print(pageNum);
      out.write("</span> 页 \r\n");
      out.write("\t\t\t\t\t<a href=\"/servlet/Customer?howdo=list&pageNum=1&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;\r\n");
      out.write("\t\t\t\t<a href=\"/servlet/Customer?howdo=list&pageNum=");
      out.print( pageNum-1 );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">上一页</a> &nbsp;\r\n");
      out.write("\t\t\t\t<a href=\"/servlet/Customer?howdo=list&pageNum=");
      out.print( pageNum+1 );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">下一页</a>&nbsp;\r\n");
      out.write("\t\t\t\t<a href=\"/servlet/Customer?howdo=list&pageNum=");
      out.print( pageAll );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">末页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t");

			} else {
			
      out.write("\r\n");
      out.write("\t\t\t\t共 <span style=\"color:#120eb8\">");
      out.print(pageAll);
      out.write("</span> 页&nbsp;&nbsp; 当前第 <span\r\n");
      out.write("\t\t\t\t\tstyle=\"color:#120eb8\">");
      out.print(pageNum);
      out.write("</span> 页 \r\n");
      out.write("\t\t\t\t\t<a href=\"/servlet/Customer?howdo=find&username=");
      out.print(username );
      out.write("&pageNum=1&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">&nbsp;&nbsp;&nbsp;&nbsp;首页</a>&nbsp;\r\n");
      out.write("\t\t\t\t<a href=\"/servlet/Customer?howdo=find&username=");
      out.print(username );
      out.write("&pageNum=");
      out.print( pageNum-1 );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">上一页</a> &nbsp;\r\n");
      out.write("\t\t\t\t<a href=\"/servlet/Customer?howdo=find&username=");
      out.print(username );
      out.write("&pageNum=");
      out.print( pageNum+1 );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">下一页</a>&nbsp;\r\n");
      out.write("\t\t\t\t<a href=\"/servlet/Customer?howdo=find&username=");
      out.print(username );
      out.write("&pageNum=");
      out.print( pageAll );
      out.write("&pageSize=");
      out.print( pageSize );
      out.write("&pageCount=");
      out.print( pageCount );
      out.write("\">末页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
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
