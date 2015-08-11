package com.ewa.bean.dao;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import com.ewa.bean.*;
import com.ewa.db.*;

public class UserDAO {
	private PreparedStatement ps; 
	private ResultSet rs;
	private Statement statement; 
	
	public UserDAO () {
		
	}
	
	public List<UserBean> getAllUser() throws java.sql.SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<UserBean> userList = new ArrayList<UserBean>();
		String sql = "select * from user";
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				UserBean userBean = new UserBean();   
				userBean.setId(rs.getInt("id"));    
				userBean.setName(rs.getString("name"));    
				userBean.setPassword(rs.getString("password"));    
				userBean.setDescribe(rs.getString("describe"));    
				userBean.setDate(rs.getDate("date")); 
				userBean.setPriv(rs.getInt("priv"));
				userList.add(userBean);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return userList;
	}
	
	public List<UserBean> getAllUser(int start, int count) throws SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<UserBean> userList = new ArrayList<UserBean>();
		String sql = "select * from user limit "+start+","+count;
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				UserBean userBean = new UserBean();   
				userBean.setId(rs.getInt("id"));    
				userBean.setName(rs.getString("name"));    
				userBean.setPassword(rs.getString("password"));    
				userBean.setDescribe(rs.getString("describe"));    
				userBean.setDate(rs.getDate("date")); 
				userBean.setPriv(rs.getInt("priv")); 
				userList.add(userBean);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return userList;
	}
	
	public int getAllUserCount() {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		String sql = "select count(*) from user";
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			if (rs.next()) { 
				return rs.getInt(1);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return 0;
	}
	
	public UserBean getUserBean(int id) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		UserBean userBean = new UserBean();
		String sql = "select * from user where id = '"+id+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				userBean.setId(rs.getInt("id"));    
				userBean.setName(rs.getString("name"));    
				userBean.setPassword(rs.getString("password"));    
				userBean.setDescribe(rs.getString("describe"));    
				userBean.setDate(rs.getDate("date")); 
				userBean.setPriv(rs.getInt("priv"));
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return userBean;
	}
	
	public UserBean getUserBean(String username) throws SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		UserBean userBean = null;
		String sql = "select * from user where name = '"+username+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				userBean = new UserBean();
				userBean.setId(rs.getInt("id"));    
				userBean.setName(rs.getString("name"));    
				userBean.setPassword(rs.getString("password"));    
				userBean.setDescribe(rs.getString("describe"));    
				userBean.setDate(rs.getDate("date")); 
				userBean.setPriv(rs.getInt("priv"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return userBean;
	}
	
	public List<UserBean> findUserBean(String username, int start, int count) throws java.sql.SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		String where = " where 1 = 1";
		if (username!=null && !username.isEmpty() ) {
			where += " and name like '%" + username + "%' ";
		}
		
		List<UserBean> userList = new ArrayList<UserBean>();
		String sql = "select * from user " + where + " limit "+start+","+count;
		try {
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				UserBean userBean = new UserBean();
				userBean.setId(rs.getInt("id"));    
				userBean.setName(rs.getString("name"));    
				userBean.setPassword(rs.getString("password"));    
				userBean.setDescribe(rs.getString("describe"));    
				userBean.setDate(rs.getDate("date")); 
				userBean.setPriv(rs.getInt("priv"));
				
				userList.add(userBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return userList;
	}
	
	public UserBean getUserBean(String username, String password) throws SQLException {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		UserBean userBean = null;
		String sql = "select * from user where name = '"+username+"' and `password`= '"+password+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				userBean = new UserBean();
				userBean.setId(rs.getInt("id"));    
				userBean.setName(rs.getString("name"));    
				userBean.setPassword(rs.getString("password"));    
				userBean.setDescribe(rs.getString("describe"));    
				userBean.setDate(rs.getDate("date")); 
				userBean.setPriv(rs.getInt("priv"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return userBean;
	}
	
	public int findUserBeanCount(String username) throws java.sql.SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		String where = " where 1 = 1";
		if (username!=null && !username.isEmpty() ) {
			where += " and name like '%" + username + "%' ";
		}
		
		String sql = "select count(*) from user "+where ;
		try {
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return 0;
	}
	
	public boolean addUser(String username, String password, String describe, java.util.Date date, int priv) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		try {	
			String sql = "insert into user(name, `password`, `describe`, `date`, `priv`) values(?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, describe);
			ps.setDate(4, new java.sql.Date(date.getTime()));
			ps.setInt(5, priv);
			ps.executeUpdate();
			return true;
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return false;
	}
	
	public boolean updateUser(int id, String username, String password, String describe, java.sql.Date date) {
		try {	
			String sql = "update user set name = ?, `password` = ?, `describe` = ?, `date` = ? where id = ?";
			
			int row = this.excute(sql, new Object[]{username, password, describe, date, Integer.valueOf(id)});
			
			if (row > 0) { 
				return true; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delUser(int id) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		String sql = "delete from user where id = '"+id+"'";
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		
		return false;
	}
	
	public int excute(String sql,Object[] obj) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		int row = 0;  
		int len = obj.length;  
		try {   
			ps = conn.prepareStatement(sql);
			preparSql(obj, len);   
			row = ps.executeUpdate();  
		} catch (SQLException e) {   
			e.printStackTrace();  
		} finally {   
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}  
		return row;
	}
	
	public void preparSql(Object[] obj,int length)throws SQLException { 
		for (int i=0;i<length;i++) {  
			if(obj[i].getClass()==String.class) { 
				ps.setString(i+1, obj[i].toString());
			} else if (obj[i].getClass()==Integer.class) {  
				ps.setInt(i+1, (Integer)obj[i]);  
			} else if(obj[i].getClass()==Double.class) {  
				ps.setDouble(i+1, (Double)obj[i]);   
			} else if (obj[i].getClass()==Date.class) { 
				ps.setDate(i+1,(Date)obj[i]);   
			}
		}    
	}
	
}
