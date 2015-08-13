package com.ewa.servlet.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.ewa.bean.CustomerBean;
import com.ewa.bean.UserBean;
import com.ewa.bean.WorksBean;
import com.ewa.bean.dao.CustomerDAO;
import com.ewa.bean.dao.UserDAO;
import com.ewa.bean.dao.WorksDAO;
import com.ewa.util.ErrorInfo;

public class Works extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		String howdo = request.getParameter("mode");
		
		if (howdo.equals("add")) {
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
			String userid = request.getParameter("userid");
			if (customerid==null || level==null || isphonecall==null || isclosed==null || customerid.isEmpty() || level.isEmpty() || isphonecall.isEmpty() || isclosed.isEmpty()) {
		        errorInfo(501, "字段不能为空", request, response); 
		        return;
			}
			
			WorksDAO worksDao = new WorksDAO();
			CustomerDAO customerDao = new CustomerDAO();
			boolean result = false;
			
			try {
				if (userid==null || userid.isEmpty()) {
					result = false;
				} else {
					UserDAO userDao = new UserDAO();
					
					UserBean userBean1 = null;
					try {
						userBean1 = userDao.getUserBean(userid);
					} catch (SQLException e) {	        
				        errorInfo(401, "用户验证失败，请重新登录", request, response); 
				        return;
					}
					
					CustomerBean customerBean = customerDao.getCustomerBean(Integer.valueOf(customerid));
					
					if (customerBean == null) {
						result = false;
					} else {
						result = worksDao.addWorks(
								Integer.valueOf(customerid).intValue(), 
								customerBean.getName(), 
								Integer.valueOf(userid).intValue(), 
								userBean1.getName(), 
								level, 
								describe, 
								Integer.valueOf(isphonecall).intValue(), 
								phonenumber, 
								solution, 
								Integer.valueOf(isclosed).intValue(),
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
				errorInfo(200, "增加工作纪要成功", request, response);
				return;
			} else {
				errorInfo(401, "增加工作纪要失败", request, response); 
		        return;
			}
		} else if (howdo.equals("list")) {
			
			forwordWorksList(request, response);
			
			return;
		} else if (howdo.equals("edit")) {
			WorksDAO worksDao = new WorksDAO();
			
			WorksBean worksBean = null;
			
			int id = Integer.valueOf(request.getParameter("id")).intValue();
			
			try {
				worksBean = worksDao.getWorksById(id);
			} catch (Exception e) {
				errorInfo(501, "查询出错", request, response); 
		        return;
			}
			
			outBean(worksBean, request, response);
			
			return;
			
		} else if (howdo.equals("update")) {
			int id = Integer.valueOf(request.getParameter("id")).intValue();
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
			String userid = request.getParameter("userid");
			if (customerid==null || level==null || isphonecall==null || isclosed==null || customerid.isEmpty() || level.isEmpty() || isphonecall.isEmpty() || isclosed.isEmpty()) {
				errorInfo(501, "字段不能为空", request, response); 
		        return;
			}
			
			UserDAO userDao = new UserDAO();
			
			UserBean userBean1 = null;
			try {
				userBean1 = userDao.getUserBean(userid);
			} catch (SQLException e) {	        
		        errorInfo(401, "用户验证失败，请重新登录", request, response); 
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
							Integer.valueOf(customerid).intValue(), 
							customerBean.getName(), 
							userBean1.getId(), 
							userBean1.getName(), 
							level, 
							describe, 
							Integer.valueOf(isphonecall).intValue(), 
							phonenumber, 
							solution, 
							Integer.valueOf(isclosed).intValue(), 
							newcontent,
							erjidanwei,
							kehulianxiren,
							lianxifangshi,
							lianximail);
					
					// 更改关闭字段了， 就要把问题父列和子列的关闭字段都改一下
					if (worksBean.getIsclosed() != Integer.valueOf(isclosed).intValue()) {
						worksDao.updateWorksClosedField(id, Integer.valueOf(isclosed).intValue());
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				result = false;
			}
			
			if (result) {
				errorInfo(200, "更新工作纪要成功", request, response);
				return;
			} else {
				errorInfo(501, "更新工作纪要失败", request, response); 
		        return;
			}
		} else if (howdo.equals("history")) {
			String id = request.getParameter("id");
			
			if (id==null || id.isEmpty()) {
				errorInfo(501, "查看失败", request, response); 
		        return;
			}
			
			forwordWorksHistoryList(request, response);
			
			return;
		} else if (howdo.equals("view")) {
			WorksDAO worksDao = new WorksDAO();
			
			WorksBean worksBean = null;
			
			int id = Integer.valueOf(request.getParameter("id")).intValue();
			
			try {
				worksBean = worksDao.getWorksById(id);
			} catch (Exception e) {
				errorInfo(401, "查询出错", request, response); 
		        return;
			}
			
			outBean(worksBean, request, response);
			
			return;
		} else if (howdo.equals("find")) {
			/*
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
				username = userBean.getName();
				userid = Integer.toString(userBean.getId());
			} else {
				if (username!=null && (username.equals("用户") || username.equals(""))) {
					username = null;
				}
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
				errorInfo(401, "数据库查询失败", request, response); 
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
			*/
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	private void errorInfo(int errorCode, String errorDes, HttpServletRequest request, HttpServletResponse response) {
		JSONObject json=new JSONObject();
		try {
			json.put("status", errorCode);
			json.put("describe", errorDes);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
		try {
			response.getOutputStream().write(json.toString().getBytes("UTF-8"));
			response.setContentType("text/json; charset=UTF-8"); 
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		
	}
	
	private void outBean(WorksBean worksBean, HttpServletRequest request, HttpServletResponse response) {
		try{
		    JSONObject memberjson=new JSONObject();
	        memberjson.put("id", worksBean.getId());
	        memberjson.put("customerid", worksBean.getCustomerid());
	        memberjson.put("customername", worksBean.getCustomername());
	        memberjson.put("level", worksBean.getLevel());
	        memberjson.put("describe", worksBean.getDescribe());
	        memberjson.put("isphonecall", worksBean.isIsphonecall());
	        memberjson.put("phonecallnumber", worksBean.getPhonecallnumber());
	        memberjson.put("solution", worksBean.getSolution());
	        memberjson.put("isclosed", worksBean.getIsclosed());
	        memberjson.put("createdate", worksBean.getCreatedate());
	        memberjson.put("closedate", worksBean.getClosedate());
	        memberjson.put("username", worksBean.getUsername());
	        memberjson.put("customername", worksBean.getCustomername());
	        memberjson.put("newcontent", worksBean.getNewcontent());
	        memberjson.put("erjidanwei", worksBean.getErjidanwei());
	        memberjson.put("kehulianxiren", worksBean.getKehulianxiren());
	        memberjson.put("lianxifangshi", worksBean.getLianxifangshi());
	        memberjson.put("contactmail", worksBean.getLianximail());
	    	
	        JSONObject json=new JSONObject();
			json.put("status", 200);
			json.put("data", memberjson);
			
			response.getOutputStream().write(json.toString().getBytes("UTF-8"));
			response.setContentType("text/json; charset=UTF-8");
			return;
		} catch (JSONException e) {
			errorInfo(503, "数据出错", request, response); 
	        return;
		} catch (Exception e) {
			errorInfo(501, "数据查询失败", request, response); 
	        return;
		}
	}
	
	private void outBean(List<WorksBean> worksBeanList, HttpServletRequest request, HttpServletResponse response) {
		try{
			JSONObject memberjson1=new JSONObject();
			memberjson1.put("count", worksBeanList.size());
			merberjson1.
			
			for (WorksBean worksBean : worksBeanList) {
			    JSONObject memberjson =new JSONObject();
		        memberjson.put("id", worksBean.getId());
		        memberjson.put("customerid", worksBean.getCustomerid());
		        memberjson.put("customername", worksBean.getCustomername());
		        memberjson.put("level", worksBean.getLevel());
		        memberjson.put("describe", worksBean.getDescribe());
		        memberjson.put("isphonecall", worksBean.isIsphonecall());
		        memberjson.put("phonecallnumber", worksBean.getPhonecallnumber());
		        memberjson.put("solution", worksBean.getSolution());
		        memberjson.put("isclosed", worksBean.getIsclosed());
		        memberjson.put("createdate", worksBean.getCreatedate());
		        memberjson.put("closedate", worksBean.getClosedate());
		        memberjson.put("username", worksBean.getUsername());
		        memberjson.put("customername", worksBean.getCustomername());
		        memberjson.put("newcontent", worksBean.getNewcontent());
		        memberjson.put("erjidanwei", worksBean.getErjidanwei());
		        memberjson.put("kehulianxiren", worksBean.getKehulianxiren());
		        memberjson.put("lianxifangshi", worksBean.getLianxifangshi());
		        memberjson.put("contactmail", worksBean.getLianximail());
			}
	    	
	        JSONObject json=new JSONObject();
			json.put("status", 200);
			json.put("data", memberjson);
			
			response.getOutputStream().write(json.toString().getBytes("UTF-8"));
			response.setContentType("text/json; charset=UTF-8");
			return;
		} catch (JSONException e) {
			errorInfo(503, "数据出错", request, response); 
	        return;
		} catch (Exception e) {
			errorInfo(501, "数据查询失败", request, response); 
	        return;
		}
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
			customerList = worksDao.getAllWorks((pageNum-1)*pageSize, pageSize);
		} else {
			customerList = worksDao.getAllWorks(userid, (pageNum-1)*pageSize, pageSize);
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
	
	private void forwordWorksHistoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageSize = 25;
		int pageNum = 1;
		try {
			pageSize = Integer.valueOf(request.getParameter("pageSize"));
			pageNum = Integer.valueOf(request.getParameter("pageNum"));
		} catch (Exception e) {}
		
		forwordWorksHistoryList(pageSize, pageNum, request, response);
		
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

}
