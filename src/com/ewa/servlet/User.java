package com.ewa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.*;

import com.ewa.db.*;
import com.ewa.bean.dao.*;
import com.ewa.bean.*;
import com.ewa.util.*;

public class User extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public User() {
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
		if (howdo.equals("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserDAO userDao = new UserDAO();
			
			UserBean userBean1 = null;
			try {
				userBean1 = userDao.getUserBean(username, password);
			} catch (SQLException e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("登陆失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
		        rd.forward(request,response);
		        
		        return;
			}
			
			if (userBean1 != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userid", userBean1.getId());
				session.setAttribute("userBean", userBean1);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=list");  
		        rd.forward(request,response);
				
				return;
			} else {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("登陆失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
		        rd.forward(request,response);
		        
		        return;
			}
		}
		
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
		
		if (howdo.equals("password")) {
			request.setAttribute("userBean", userBean);
			RequestDispatcher rd=request.getRequestDispatcher("/updatePassword.jsp");  
	        rd.forward(request,response);
	        return;
		} else if (howdo.equals("updatePwd")) {
			int id = userBean.getId();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confirPassword = request.getParameter("confirPassword");
			//String describe = request.getParameter("describe");
			if (password==null || confirPassword==null || password.isEmpty() || confirPassword.isEmpty()) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("字段不能为空");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/User?howdo=password");  
		        rd.forward(request,response);
		        
		        return;
			}
			
			if (!password.equalsIgnoreCase(confirPassword)) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("密码不相同");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/User?howdo=password");  
		        rd.forward(request,response);

		        return;
			}
			
			UserDAO userDao = new UserDAO();
			if (userDao.updateUser(id, username, password, "", new java.sql.Date(new java.util.Date().getTime()))) {
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=list");  
		        rd.forward(request,response);
				
				return;
			} else {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("修改用户失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/User?howdo=password");  
		        rd.forward(request,response);
		        
		        return;
			}
		}
		
		if (userBean.getPriv() != 0) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setDetailMessage("你没有权限管理账号");
			
			request.setAttribute("ErrorInfo", errorInfo);
			
			RequestDispatcher rd=request.getRequestDispatcher("/servlet/Works?howdo=list");  
	        rd.forward(request,response);
	        
	        return;
		}
		
		if (howdo.equals("add")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confirPassword = request.getParameter("confirPassword");
			String describe = request.getParameter("describe");
			if (password==null || username==null || confirPassword==null || password.isEmpty() || username.isEmpty() || confirPassword.isEmpty()) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("字段不能为空");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/addUser.jsp");  
		        rd.forward(request,response);
		        
		        return;
			}
			
			if (!password.equalsIgnoreCase(confirPassword)) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("密码不相同");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/addUser.jsp");  
		        rd.forward(request,response);

		        return;
			}
			
			UserDAO userDao = new UserDAO();
			try {
				UserBean uL = userDao.getUserBean(username);
				if (uL!=null) {
					ErrorInfo errorInfo = new ErrorInfo();
					errorInfo.setDetailMessage("添加账号同名");
					
					request.setAttribute("ErrorInfo", errorInfo);
					
					RequestDispatcher rd=request.getRequestDispatcher("/addUser.jsp");  
			        rd.forward(request,response);
			        
			        return;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (userDao.addUser(username, password, describe, new java.util.Date(), 1)) {
				
				forwordUserList(request, response);
				
				return;
			} else {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("增加用户失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/addUser.jsp");  
		        rd.forward(request,response);
		        
		        return;
			}
		} else if (howdo.equals("list")) {
			
			forwordUserList(request, response);
			
			return;
		} else if (howdo.equals("del")) {
			try {
				int id = Integer.valueOf(request.getParameter("id"));
			
				UserDAO userDao = new UserDAO();
				
				if (userDao.delUser(id)) {
					
					forwordUserList(request, response);
					
					return;
				} else {
					ErrorInfo errorInfo = new ErrorInfo();
					errorInfo.setDetailMessage("删除失败");
					
					request.setAttribute("ErrorInfo", errorInfo);
					
					forwordUserList(request, response);
			        
			        return;
				}
				
			} catch (NumberFormatException e) {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("删除失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				forwordUserList(request, response);
		        
		        return;
			}
		} else if (howdo.equals("edit")) {
			int id = Integer.valueOf(request.getParameter("id"));
			UserDAO userDao = new UserDAO();
			UserBean userBean1 = userDao.getUserBean(id);
			request.setAttribute("userBean", userBean1);
			RequestDispatcher rd=request.getRequestDispatcher("/updateUser.jsp");  
	        rd.forward(request,response);
	        return;
		} else if (howdo.equals("update")) {
			int id = Integer.valueOf(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String confirPassword = request.getParameter("confirPassword");
			String describe = request.getParameter("describe");
			if (password==null || confirPassword==null || password.isEmpty() || confirPassword.isEmpty()) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("字段不能为空");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/User?howdo=edit&id="+id);  
		        rd.forward(request,response);
		        
		        return;
			}
			
			if (!password.equalsIgnoreCase(confirPassword)) {
				
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("密码不相同");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/User?howdo=edit&id="+id);  
		        rd.forward(request,response);

		        return;
			}
			
			UserDAO userDao = new UserDAO();
			if (userDao.updateUser(id, username, password, describe, new java.sql.Date(new java.util.Date().getTime()))) {
				
				forwordUserList(request, response);
				
				return;
			} else {
				ErrorInfo errorInfo = new ErrorInfo();
				errorInfo.setDetailMessage("修改用户失败");
				
				request.setAttribute("ErrorInfo", errorInfo);
				
				RequestDispatcher rd=request.getRequestDispatcher("/servlet/User?howdo=edit&id="+id);  
		        rd.forward(request,response);
		        
		        return;
			}
		} else if (howdo.equals("find")) {
			
			String username = request.getParameter("username");
			if (username!=null && (username.equals("用户") || username.equals(""))) {
				username = null;
			}
			int pageSize = 25;
			int pageNum = 1;
			try {
				pageSize = Integer.valueOf(request.getParameter("pageSize"));
				pageNum = Integer.valueOf(request.getParameter("pageNum"));
			} catch (Exception e) {}
			
			if (pageNum <= 0) pageNum = 1;
			
			UserDAO userDao = new UserDAO();
			List<UserBean> userList = null;
			int pageCount = 0;
			try {
				if (userBean.getPriv() != 0) {
					userList = new ArrayList<UserBean>();
					userList.add(userBean);
					
					pageCount = 1;
					
				} else {
					pageCount = userDao.findUserBeanCount(username);
					
					if ((pageCount / pageSize) < pageNum) {
						pageNum = ((pageCount % pageSize)==0)?(pageCount/pageSize):(pageCount/pageSize+1);
					}
					
					userList = userDao.findUserBean(username,(pageNum-1)*pageSize, pageSize);

				}
				request.setAttribute("UserList", userList);
				
				
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
			request.getRequestDispatcher("/userManage.jsp").forward(request, response);
		}
	}
	
	private void forwordUserList(int pageSize, int pageNum, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserBean userBean1 = (UserBean)session.getAttribute("userBean");
		if (userBean1 == null) {
			ErrorInfo errorInfo = new ErrorInfo();
			errorInfo.setDetailMessage("你没有登陆");
			
			request.setAttribute("ErrorInfo", errorInfo);
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");  
	        rd.forward(request,response);
	        
	        return;
		} 
		
		int pageCount = 0;
		
		UserDAO userDao = new UserDAO();
		List<UserBean> userList = null; 
		try {
			if (userBean1.getPriv() != 0) {
				userList = new ArrayList<UserBean>();
				userList.add(userBean1);
				
				pageCount = 1;
				pageNum = 1;
				pageSize = 1;
				
			} else {
				pageCount = userDao.getAllUserCount();
				if ((pageCount / pageSize) < pageNum) {
					pageNum = ((pageCount % pageSize)==0)?(pageCount/pageSize):(pageCount/pageSize+1);
				}
				
				if (pageNum <= 0) pageNum = 1;
				
				userList = userDao.getAllUser((pageNum-1)*pageSize, pageSize);

			}
			request.setAttribute("UserList", userList);
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

		RequestDispatcher rd = request.getRequestDispatcher("/userManage.jsp");  
        rd.forward(request,response);
		
		return;
	}
	
	private void forwordUserList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		int pageSize = 25;
		
		try {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
			session.setAttribute("UserPageSize", pageSize);
		} catch (Exception e) {
			try {
				pageSize = Integer.valueOf(session.getAttribute("UserPageSize").toString());
			} catch(Exception e1) {
				pageSize = 25;
			}
		}
		
		int pageNum = 1;
		try {
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
			session.setAttribute("UserPageNum", pageNum);
		} catch (Exception e) {
			try {
				pageNum = Integer.valueOf(session.getAttribute("UserPageNum").toString());
			} catch(Exception e1) {
				pageNum = 1;
			}
		}
		
		if (pageNum <= 0) pageNum = 1;
		
		forwordUserList(pageSize, pageNum, request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	public void forward(String forwardPath, HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(forwardPath);  
        try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
