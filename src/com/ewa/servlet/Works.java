package com.ewa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ewa.bean.UserBean;
import com.ewa.bean.WorksBean;
import com.ewa.bean.CustomerBean;
import com.ewa.bean.dao.*;
import com.ewa.util.ErrorInfo;

public class Works extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Works() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		UserBean userBean = (UserBean)session.getAttribute("userBean");
		
		if (userBean == null) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setDetailMessage("请您登录后操作");
			
			request.setAttribute("ErrorInfo", errorInfo);
			
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
	        rd.forward(request,response);
	        
	        return;
		}

		String howdo = request.getParameter("howdo");
		
		if (howdo.equals("addPage")) {
			List<CustomerBean> customerList = this.getCustomerList(request, response);
			request.setAttribute("CustomerList", customerList);
			
			RequestDispatcher rd=request.getRequestDispatcher("/addEvents.jsp");  
	        rd.forward(request,response);
	        
	        return;
		} else if (howdo.equals("add")) {
			request.setCharacterEncoding("UTF-8");
			String customerid = request.getParameter("customerid");
			String level = request.getParameter("level");
			String describe = request.getParameter("describe");
			String isphonecall = request.getParameter("isphonecall");
			String phonenumber = request.getParameter("phonenumber");
			String solution = request.getParameter("solution");
			String isclosed = request.getParameter("isclosed");
			String erjidanwei  = request.getParameter("erjidanwei");
			String kehulianxiren = request.getParameter("kehulianxiren");
			String lianxifangshi = request.getParameter("lianxifangshi");
			String lianximail = request.getParameter("lianximail");
			if (customerid==null || level==null || isphonecall==null || isclosed==null || customerid.isEmpty() || level.isEmpty() || isphonecall.isEmpty() || isclosed.isEmpty()) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("字段不能为空");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=addPage");  
		        rd.forward(request,response);
		        
		        return;
			}
			
			WorksDAO worksDao = new WorksDAO();
			CustomerDAO customerDao = new CustomerDAO();
			boolean result = false;
			
			String userid = Integer.toString(userBean.getId());
			
			try {
				if (userid==null || userid.isEmpty()) {
					result = false;
				} else {
					CustomerBean customerBean = customerDao.getCustomerBean(Integer.valueOf(customerid));
					
					if (customerBean == null) {
						result = false;
					} else {
						result = worksDao.addWorks(
								Integer.valueOf(customerid), 
								customerBean.getName(), 
								Integer.valueOf(userid), 
								userBean.getName(), 
								level, 
								describe, 
								Integer.valueOf(isphonecall), 
								phonenumber, 
								solution, 
								Integer.valueOf(isclosed),
								erjidanwei,
								kehulianxiren,
								lianxifangshi,
								lianximail);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
			
			if (result) {
				forwordWorksList(request, response);
				return;
			} else {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("增加工作纪要失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=addPage");  
		        rd.forward(request,response);
		        
		        return;
			}
		} else if (howdo.equals("list")) {
			
			forwordWorksList(request, response);
			
			return;
		} else if (howdo.equals("del")) {
			try {
				int id = Integer.valueOf(request.getParameter("id"));
			
				WorksDAO worksDao = new WorksDAO();
				
				if (worksDao.delWorksById(id)) {
					
					forwordWorksList(request, response);
					
					return;
				} else {
					ErrorInfo errorInfo = new ErrorInfo();
					errorInfo.setDetailMessage("删除失败");
					
					request.setAttribute("ErrorInfo", errorInfo);
					
					forwordWorksList(request, response);
			        
			        return;
				}
				
			} catch (Exception e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("删除失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				forwordWorksList(request, response);
		        
		        return;
			}
		} else if (howdo.equals("edit")) {
			WorksDAO worksDao = new WorksDAO();
			
			WorksBean worksBean = null;
			
			int id = Integer.valueOf(request.getParameter("id"));
			
			try {
				worksBean = worksDao.getLastWorksById(id);
			} catch (Exception e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("查询出错");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=edit&id="+id);  
		        rd.forward(request,response);

		        return;
			}
			
			request.setAttribute("fid", id);
			request.setAttribute("worksBean", worksBean);
			RequestDispatcher rd=request.getRequestDispatcher("/updateEvents.jsp");  
	        rd.forward(request,response);
	        return;
			
		} else if (howdo.equals("update")) {
			int id = Integer.valueOf(request.getParameter("id"));
			String customerid = request.getParameter("customerid");
			String level = request.getParameter("level");
			String describe = request.getParameter("describe");
			String isphonecall = request.getParameter("isphonecall");
			String phonenumber = request.getParameter("phonenumber");
			String solution = request.getParameter("solution");
			String isclosed = request.getParameter("isclosed");
			String newcontent = request.getParameter("newcontent");
			String erjidanwei  = request.getParameter("erjidanwei");
			String kehulianxiren = request.getParameter("kehulianxiren");
			String lianxifangshi = request.getParameter("lianxifangshi");
			String lianximail = request.getParameter("lianximail");
			if (customerid==null || level==null || isphonecall==null || isclosed==null || customerid.isEmpty() || level.isEmpty() || isphonecall.isEmpty() || isclosed.isEmpty()) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("字段不能为空");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=edit&id="+id);  
		        rd.forward(request,response);
		        
		        return;
			}
			
			WorksDAO worksDao = new WorksDAO();
			CustomerDAO customerDao = new CustomerDAO();
			boolean result = false;
			
			try {
				
				CustomerBean customerBean = customerDao.getCustomerBean(Integer.valueOf(customerid));
				WorksBean worksBean = worksDao.getWorksById(id);
				
				if (customerBean == null) {
					result = false;
				} else {
					result = worksDao.updateWorks(id, 
							Integer.valueOf(customerid), 
							customerBean.getName(), 
							userBean.getId(), 
							userBean.getName(), 
							level, 
							describe, 
							Integer.valueOf(isphonecall), 
							phonenumber, 
							solution, 
							Integer.valueOf(isclosed), 
							newcontent,
							erjidanwei,
							kehulianxiren,
							lianxifangshi,
							lianximail);
					
					// 更改关闭字段了， 就要把问题父列和子列的关闭字段都改一下
					if (worksBean.getIsclosed() != Integer.valueOf(isclosed)) {
						worksDao.updateWorksClosedField(id, Integer.valueOf(isclosed));
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
			
			if (result) {
				forwordWorksList(request, response);
				return;
			} else {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("更新工作纪要失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=edit&id="+id);  
		        rd.forward(request,response);
		        
		        return;
			}
		} else if (howdo.equals("history")) {
			String id = request.getParameter("id");
			if (id==null || id.isEmpty()) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("查看失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=list");  
		        rd.forward(request,response);
		        
		        return;
			}
			request.setAttribute("id", id);
			
			forwordWorksHistoryList(request, response);
			
			return;
		} else if (howdo.equals("stat")) {
			String id = request.getParameter("id");
			if (id==null || id.isEmpty()) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("查看失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=list");  
		        rd.forward(request,response);
		        
		        return;
			}
			request.setAttribute("id", id);
			
			forwordWorksStatList(request, response);
			
			return;
		} else if (howdo.equals("view")) {
			WorksDAO worksDao = new WorksDAO();
			
			WorksBean worksBean = null;
			
			int id = Integer.valueOf(request.getParameter("id"));
			
			try {
				worksBean = worksDao.getWorksById(id);
			} catch (Exception e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("查询出错");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=list");  
		        rd.forward(request,response);

		        return;
			}
			
			request.setAttribute("worksBean", worksBean);
			RequestDispatcher rd=request.getRequestDispatcher("/viewEvents.jsp");  
	        rd.forward(request,response);
	        return;
		} else if (howdo.equals("find")) {
			String customername = request.getParameter("customername");
			String username = request.getParameter("username");
			String isclosed = request.getParameter("isclosed");
			String createtime = request.getParameter("createtime");
			String closetime = request.getParameter("closetime");
			
			if (customername!=null && (customername.equals("客户") || customername.equals(""))) {
				customername = null;
			}
			String userid = null;
			if (userBean.getPriv() == 1) {
				//username = userBean.getName();
				userid = Integer.toString(userBean.getId());
			}
			
			if (username!=null && (username.equals("用户") || username.equals(""))) {
				username = null;
			}
			
			if (isclosed!=null && (isclosed.equals("事件状态") || isclosed.equals(""))) {
				isclosed = null;
			}
			if (createtime!=null && (createtime.equals("新增时间") || createtime.equals(""))) {
				createtime = null;
			}
			if (closetime!=null && (closetime.equals("关闭时间") || closetime.equals(""))) {
				closetime = null;
			}
			
			int pageSize = 25;
			int pageNum = 1;
			try {
				pageSize = Integer.valueOf(request.getParameter("pageSize"));
				pageNum = Integer.valueOf(request.getParameter("pageNum"));
			} catch (Exception e) {}
			
			if (pageNum <= 0) pageNum = 1;
			
			WorksDAO worksDao = new WorksDAO();
			List<WorksBean> worksList = null;
			int pageCount = 0;
			try {
				pageCount = worksDao.findWorksCount(userid, username, customername, isclosed, createtime, closetime);
				
				if ((pageCount / pageSize) < pageNum) {
					pageNum = ((pageCount % pageSize)==0)?(pageCount/pageSize):(pageCount/pageSize+1);
				}
				
				if (pageNum <= 0) pageNum = 1;
			
				worksList = worksDao.findWorks(userid, username, customername, isclosed, createtime, closetime,(pageNum-1)*pageSize, pageSize);
				request.setAttribute("WorksList", worksList);
				
			} catch (SQLException e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("数据库查询失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				return;
			}
			
			
			
			int pageAll = 0;
			if ((pageCount % pageSize) == 0) {
				pageAll = (pageCount / pageSize);
			} else {
				pageAll = (pageCount / pageSize) + 1;
			}
			request.setAttribute("pageAll", pageAll);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("howdo", "find");
			if (customername !=null && !customername.isEmpty()) {
				request.setAttribute("customername", customername);
			}
			if (username !=null && !username.isEmpty()) {
				request.setAttribute("username", username);
			}
			if (isclosed != null && !isclosed.isEmpty()) {
				request.setAttribute("isclosed", isclosed);
			}
			if (createtime!=null && !createtime.isEmpty()) {
				request.setAttribute("createtime", createtime);
			}
			if (closetime!=null && !closetime.isEmpty()) {
				request.setAttribute("closetime", closetime);				
			}
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	private List<CustomerBean> getCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserBean userBean = (UserBean)session.getAttribute("userBean");
		
		if (userBean == null) {
	        return null;
		} else {
			
			CustomerDAO customerDao = new CustomerDAO();
			List<CustomerBean> customerList = null; 
			try {
				customerList = customerDao.getCustomers(userBean.getId());
			} catch (SQLException e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("数据库查询失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
			}
			return customerList;
		}
	}
	
	private void forwordWorksList(int pageSize, int pageNum, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserBean userBean = (UserBean)session.getAttribute("userBean");
		
		if (userBean == null) {
	        return;
		}
		
		int userid = userBean.getId();
		int priv = userBean.getPriv();
		
		int pageCount = 0;
		
		WorksDAO worksDao = new WorksDAO();
		
		if (priv == 0) {
			pageCount = worksDao.getAllWorksCount();
		} else {
			pageCount = worksDao.getAllWorksCount(userid);
		}
		
		if ((pageCount / pageSize) < pageNum) {
			pageNum = ((pageCount % pageSize)==0)?(pageCount/pageSize):(pageCount/pageSize+1);
		}
		
		if (pageCount <= 0) pageCount = 0;
		if (pageNum <= 0) pageNum = 1;
		
		List<WorksBean> customerList = null;
		if (priv == 0) {
			customerList = worksDao.getAllWorksGroup((pageNum-1)*pageSize, pageSize);
		} else {
			customerList = worksDao.getAllWorksGroup(userid, (pageNum-1)*pageSize, pageSize);
		}
		request.setAttribute("WorksList", customerList);
		
		int pageAll = 0;
		if ((pageCount % pageSize) == 0) {
			pageAll = (pageCount / pageSize);
		} else {
			pageAll = (pageCount / pageSize) + 1;
		}
		request.setAttribute("pageAll", pageAll);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private void forwordWorksList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 25;
		int pageNum = 1;
		try {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		} catch (Exception e) {}
		
		if (pageNum <= 0) pageNum = 1;
		
		forwordWorksList(pageSize, pageNum, request, response);
		
	}
	
	private void forwordWorksHistoryList(int pageSize, int pageNum, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorksDAO worksDao = new WorksDAO();
		
		int pageCount = worksDao.getWorksHistoryCount(Integer.valueOf(request.getParameter("id")));
		
		if ((pageCount / pageSize) < pageNum) {
			pageNum = ((pageCount % pageSize)==0)?(pageCount/pageSize):(pageCount/pageSize+1);
		}
		
		if (pageCount <= 0) pageCount = 0;
		if (pageNum <= 0) pageNum = 1;
		
		List<WorksBean> customerList = worksDao.getWorksHistory(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("WorksList", customerList);
		
		int pageAll = 0;
		if ((pageCount % pageSize) == 0) {
			pageAll = (pageCount / pageSize);
		} else {
			pageAll = (pageCount / pageSize) + 1;
		}
		request.setAttribute("pageAll", pageAll);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		
		request.getRequestDispatcher("/historyEvents.jsp").forward(request, response);
	}
	
	private void forwordWorksHistoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 25;
		int pageNum = 1;
		try {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		} catch (Exception e) {}
		
		forwordWorksHistoryList(pageSize, pageNum, request, response);
		
	}
	
	private void forwordWorksStatList(int pageSize, int pageNum, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorksDAO worksDao = new WorksDAO();
		List<WorksBean> customerList = worksDao.getWorksHistory(Integer.valueOf(request.getParameter("id")));
		request.setAttribute("WorksList", customerList);
		
		int pageCount = worksDao.getWorksHistoryCount(Integer.valueOf(request.getParameter("id")));
		if (pageCount / pageSize < pageNum) {
			pageNum = pageCount / pageSize;
		}
		if (pageNum < 1) {
			pageNum = 1;
		}
		int pageAll = 0;
		if ((pageCount % pageSize) == 0) {
			pageAll = (pageCount / pageSize);
		} else {
			pageAll = (pageCount / pageSize) + 1;
		}
		request.setAttribute("pageAll", pageAll);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		
		request.getRequestDispatcher("/statEvents.jsp").forward(request, response);
	}
	
	private void forwordWorksStatList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 25;
		int pageNum = 1;
		try {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		} catch (Exception e) {}
		
		forwordWorksStatList(pageSize, pageNum, request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
