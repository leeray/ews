package com.ewa.servlet.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.*;

import com.ewa.bean.UserBean;
import com.ewa.bean.dao.UserDAO;
import com.ewa.util.ErrorInfo;

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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO userDao = new UserDAO();
		
		UserBean userBean1 = null;
		try {
			userBean1 = userDao.getUserBean(username, password);
		} catch (SQLException e) {	        
	        errorInfo(401, "登录失败", request, response); 
	        return;
		}
		
		if (userBean1 != null) {
	        try {
		        JSONObject memberjson=new JSONObject();
		        memberjson.put("id", userBean1.getId());
		        memberjson.put("name", userBean1.getName());
	        	
		        JSONObject json=new JSONObject();
				json.put("status", 200);
				json.put("data", memberjson);
				
				response.getOutputStream().write(json.toString().getBytes("UTF-8"));
				response.setContentType("text/json; charset=UTF-8"); 
			} catch (JSONException e) {
				e.printStackTrace();
			}
	        
			
			return;
		} else {
			errorInfo(401, "登录失败", request, response); 
	        return;
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
}
