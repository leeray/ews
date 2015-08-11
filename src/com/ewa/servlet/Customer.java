package com.ewa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ewa.bean.*;
import com.ewa.bean.dao.*;
import com.ewa.util.ErrorInfo;

public class Customer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Customer() {
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

		String howdo = request.getParameter("howdo");
		if (howdo.equals("addPage")) {
			List<UserBean> userList = this.getUserList(request, response);
			request.setAttribute("UserList", userList);
			
			RequestDispatcher rd=request.getRequestDispatcher("/addCustomer.jsp");  
	        rd.forward(request,response);
	        return;
		} else if (howdo.equals("add")) {
			String customername = request.getParameter("customername");
			if (customername.isEmpty()) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("字段不能为空");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				List<UserBean> userList = this.getUserList(request, response);
				request.setAttribute("UserList", userList);
				
				RequestDispatcher rd=request.getRequestDispatcher("/addCustomer.jsp");  
		        rd.forward(request,response);
		        
		        return;
			}
			
			String[] userIDs = request.getParameterValues("selectedUser");
			if (userIDs==null || userIDs.length == 0) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("请选择账号");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				List<UserBean> userList = this.getUserList(request, response);
				request.setAttribute("UserList", userList);
				
				RequestDispatcher rd=request.getRequestDispatcher("/addCustomer.jsp");  
		        rd.forward(request,response);
		        
		        return;
			}
			
			CustomerDAO customerDao = new CustomerDAO();
			try {
				CustomerBean uL = customerDao.getCustomerBean(customername);
				if (uL!=null) {
					ErrorInfo errorInfo = new ErrorInfo();
					errorInfo.setDetailMessage("添加客户同名");
					
					request.setAttribute("ErrorInfo", errorInfo);
					
					List<UserBean> userList = this.getUserList(request, response);
					request.setAttribute("UserList", userList);
					
					RequestDispatcher rd=request.getRequestDispatcher("/addCustomer.jsp");  
			        rd.forward(request,response);
			        
			        return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			List<String> userList = new ArrayList<String>(); 
			Collections.addAll(userList, userIDs);
			
			boolean result = true;
			
			try {
				customerDao.addCustomer(customername, new java.util.Date(), userList);
			} catch (Exception e) {
				result = false;
			}
			
			if (result) {
				forwordCustomerList(request, response);
				return;
			} else {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("增加客户失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				List<UserBean> userList1 = this.getUserList(request, response);
				request.setAttribute("UserList", userList1);
				
				RequestDispatcher rd=request.getRequestDispatcher("/addCustomer.jsp");  
		        rd.forward(request,response);
		        
		        return;
			}
		} else if (howdo.equals("list")) {
			
			HttpSession session = request.getSession();
			UserBean userBean = (UserBean)session.getAttribute("userBean");
			if (userBean == null) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("你还没有登陆");
				
				request.setAttribute("ErrorInfo", errorInfo);
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
		        rd.forward(request,response);
		        
		        return;
			} else if (userBean.getPriv() != 0) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("你没有权限管理客户");
				
				request.setAttribute("ErrorInfo", errorInfo);
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=list");  
		        rd.forward(request,response);
		        //response.sendRedirect("/servlet/Works?howdo=list");
		        return;
			}
			
			forwordCustomerList(request, response);
			
			return;
		} else if (howdo.equals("del")) {
			try {
				int id = Integer.valueOf(request.getParameter("id"));
			
				CustomerDAO customerDao = new CustomerDAO();
				
				if (customerDao.deleteCustomer(id)) {
					
					forwordCustomerList(request, response);
					
					return;
				} else {
					ErrorInfo errorInfo = new ErrorInfo();
					errorInfo.setDetailMessage("删除失败");
					
					request.setAttribute("ErrorInfo", errorInfo);
					
					forwordCustomerList(request, response);
			        
			        return;
				}
				
			} catch (Exception e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("删除失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				forwordCustomerList(request, response);
		        
		        return;
			}
		} else if (howdo.equals("edit")) {
			int id = Integer.valueOf(request.getParameter("id"));
			CustomerDAO customerDao = new CustomerDAO();
			CustomerBean customerBean = customerDao.getCustomerBean(id);
			request.setAttribute("customerBean", customerBean);
			
			List<UserBean> userList = null;
			try {
				userList = customerDao.getCustomersUser(customerBean.getId());
				request.setAttribute("UserList", userList);
			} catch (SQLException e) {
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Customer?howdo=list");  
		        rd.forward(request,response);
		        return;
			}
			
			List<UserBean> userList1 = this.getUserList(request, response);
			
			for (int i = 0; i < userList1.size(); i++) {  
				UserBean userBean1 = userList1.get(i);  
			    for (int j = 0; j < userList.size(); j++) {  
			    	UserBean userBean=userList.get(j);  
			        if (userBean1.getId() == userBean.getId()) {  
			        	userList1.remove(i);  
			            i--;  
			        }  
			    }  
			}
			
			request.setAttribute("UserList1", userList1);
			RequestDispatcher rd=request.getRequestDispatcher("/updateCustomer.jsp");  
	        rd.forward(request,response);
	        return;
		} else if (howdo.equals("update")) {
			int id = Integer.valueOf(request.getParameter("id"));
			String customername = request.getParameter("customername");
			if (customername.isEmpty()) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("字段不能为空");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				List<UserBean> userList = this.getUserList(request, response);
				request.setAttribute("UserList", userList);
				
				CustomerDAO customerDao = new CustomerDAO();
				CustomerBean userBean = customerDao.getCustomerBean(id);
				request.setAttribute("customerBean", userBean);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Customer?howdo=edit&id="+id);  
		        rd.forward(request,response);
		        
		        return;
			}
			
			String[] userIDs = request.getParameterValues("selectedUser");
			if (userIDs==null || userIDs.length == 0) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("请选择账号");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				List<UserBean> userList = this.getUserList(request, response);
				request.setAttribute("UserList", userList);
				
				CustomerDAO customerDao = new CustomerDAO();
				CustomerBean userBean = customerDao.getCustomerBean(id);
				request.setAttribute("customerBean", userBean);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Customer?howdo=edit&id="+id);  
		        rd.forward(request,response);
		        
		        return;
			}
			
			List<String> userList = new ArrayList<String>(); 
			Collections.addAll(userList, userIDs);
			
			CustomerDAO customerDao = new CustomerDAO();
			boolean result = false;
			
			try {
				customerDao.updateCustomer(id, customername, userList);
				result = true;
			} catch (SQLException e) {
				result = false;
			}
			
			if (result) {
				forwordCustomerList(request, response);
				return;
			} else {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("修改客户失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				List<UserBean> userList1 = this.getUserList(request, response);
				request.setAttribute("UserList", userList1);
				
				CustomerBean userBean = customerDao.getCustomerBean(id);
				request.setAttribute("customerBean", userBean);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Customer?howdo=edit&id="+id);  
		        rd.forward(request,response);
		        
		        return;
			}
		} else if (howdo.equals("find")) {
			String username = request.getParameter("username");

			if (username !=null && (username.equals("客户名称") || username.equals(""))) {
				username = null;
			}
			
			int pageSize = 25;
			int pageNum = 1;
			try {
				pageSize = Integer.valueOf(request.getParameter("pageSize"));
				pageNum = Integer.valueOf(request.getParameter("pageNum"));
			} catch (Exception e) {}
			
			if (pageNum <= 0) pageNum = 1;
			
			CustomerDAO customerDao = new CustomerDAO();
			List<CustomerBean> customerList = null;
			int pageCount = 0;
			try {
				pageCount = customerDao.findCustomerBeanCount(username);
				
				if ((pageCount / pageSize) < pageNum) {
					pageNum = ((pageCount % pageSize)==0)?(pageCount/pageSize):(pageCount/pageSize+1);
				}
				
				if (pageNum <= 0) pageNum = 1;
				
				customerList = customerDao.findCustomerBean(username,(pageNum-1)*pageSize, pageSize);
				request.setAttribute("CustomerList", customerList);
				
			} catch (SQLException e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("数据库查询失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
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
			request.setAttribute("username", username);
			request.getRequestDispatcher("/customerManage.jsp").forward(request, response);
			return;
		}
		
	}

	private List<UserBean> getUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDao = new UserDAO();
		List<UserBean> userList = null; 
		try {
			userList = userDao.getAllUser();
		} catch (SQLException e) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setDetailMessage("数据库查询失败");
			
			request.setAttribute("ErrorInfo", errorInfo);
		}
		return userList;
	}
	
	private void forwordCustomerList(int pageSize, int pageNum, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDAO customerDao = new CustomerDAO();
		int pageCount = customerDao.getAllCustomerCount();
		if ((pageCount / pageSize) < pageNum) {
			pageNum = ((pageCount % pageSize)==0)?(pageCount/pageSize):(pageCount/pageSize+1);
		}
		if (pageNum <= 0) pageNum = 1;
		
		List<CustomerBean> customerList = customerDao.getAllCustomer((pageNum-1)*pageSize, pageSize);
		request.setAttribute("CustomerList", customerList);
		
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
		
		request.getRequestDispatcher("/customerManage.jsp").forward(request, response);
	}
	
	private void forwordCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 25;
		int pageNum = 1;
		try {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		} catch (Exception e) {}
		
		if (pageNum <= 0) pageNum = 1;
		
		forwordCustomerList(pageSize, pageNum, request, response);
		
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
