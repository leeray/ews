package com.ewa.bean.dao;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import com.ewa.bean.*;
import com.ewa.db.*;

public class CustomerDAO {
	private PreparedStatement ps; 
	private ResultSet rs;
	private Statement statement; 
	
	public List<CustomerBean> getAllCustomer(int start, int count) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<CustomerBean> cusList = new ArrayList<CustomerBean>();
		String sql = "select * from customer limit "+start+","+count;
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				CustomerBean cusBean = new CustomerBean();
				int i=1;    
				cusBean.setId(rs.getInt(i++));    
				cusBean.setName(rs.getString(i++));        
				cusBean.setDate(rs.getDate(i++)); 
				cusList.add(cusBean);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return cusList;
	}
	
	public List<CustomerBean> getCustomers(int userid) throws SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<CustomerBean> cusList = new ArrayList<CustomerBean>();
		String sql = "select customer.id, customer.name, customer.date from customer inner join user_customer where user_customer.customerid = customer.id and userid="+userid;
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				CustomerBean cusBean = new CustomerBean();
				int i=1;    
				cusBean.setId(rs.getInt(i++));    
				cusBean.setName(rs.getString(i++));        
				cusBean.setDate(rs.getDate(i++)); 
				cusList.add(cusBean);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return cusList;
	}
	
	public List<UserBean> getCustomersUser(int customerid) throws SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<UserBean> cusList = new ArrayList<UserBean>();
		String sql = "select * from user inner join user_customer on user.id = user_customer.userid where user_customer.customerid = " + customerid;
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				UserBean cusBean = new UserBean();  
				cusBean.setId(rs.getInt("id"));    
				cusBean.setName(rs.getString("name"));        
				cusBean.setDate(rs.getDate("date")); 
				cusList.add(cusBean);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return cusList;
	}
	
	public int getAllCustomerCount() {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		String sql = "select count(*) from customer";
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
	
	public CustomerBean getCustomerBean(int id) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		CustomerBean cusBean = new CustomerBean();
		String sql = "select * from customer where id = '"+id+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				int i = 1;
				cusBean.setId(rs.getInt(i++));
				cusBean.setName(rs.getString(i++));
				cusBean.setDate(rs.getDate(i++));
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return cusBean;
	}
	
	public CustomerBean getCustomerBean(String username) throws SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		CustomerBean cusBean = null;
		String sql = "select * from customer where name = '"+username+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				cusBean = new CustomerBean();
				int i = 1;
				cusBean.setId(rs.getInt(i++));
				cusBean.setName(rs.getString(i++));
				cusBean.setDate(rs.getDate(i++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return cusBean;
	}
	
	public List<CustomerBean> findCustomerBean(String name, int start, int count) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		String where = " where 1 = 1";
		if (name!=null && !name.isEmpty() ) {
			where += " and name like '%" + name + "%' ";
		}
		
		List<CustomerBean> cusList = new ArrayList<CustomerBean>();
		String sql = "select * from customer " + where +" limit "+start+","+count;;
		try {
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				CustomerBean cusBean = new CustomerBean();
				int i = 1;
				cusBean.setId(rs.getInt(i++));
				cusBean.setName(rs.getString(i++));
				cusBean.setDate(rs.getDate(i++));
				
				cusList.add(cusBean);
			}
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return cusList;
	}
	
	public int findCustomerBeanCount(String name) throws SQLException {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		String where = " where 1 = 1";
		if (name!=null && !name.isEmpty() ) {
			where += " and name like '%" + name + "%' ";
		}
		
		String sql = "select count(*) from customer"+where;
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
	
	public boolean addCustomer(String name, java.util.Date date, List<String> userList) throws Exception {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		
		try {
			String sql = "insert into customer(name, date) values(?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setDate(2, new java.sql.Date(date.getTime()));
			ps.executeUpdate();
		
			int customerid = 0;
			String sql1 = "select id from customer order by id desc limit 0,1";
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql1);
			if (rs.next()) {
				customerid = rs.getInt(1);
			}
			
			if (customerid == 0) {
				throw new Exception();
			}
			
			String sql2 = "";
			for (String userid : userList) {
				sql2 = "insert into user_customer(userid, customerid) values(?, ?)";
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, Integer.valueOf(userid).intValue());
				ps.setInt(2, customerid);
				ps.executeUpdate();
			}
			
			conn.commit();
			
			return true;
		} catch (java.sql.SQLException e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			throw e;
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
	}
	
	public boolean updateCustomer(int id, String name, List<String> userList) throws SQLException {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		conn.setAutoCommit(false);
		try {	
			String sql = "update customer set name = ? where id = ?";
			
			int row = this.excute(sql, new Object[]{name, id}, conn);
			
			if (row <= 0) { 
				conn.rollback();
				return false; 
			}
			
			String sql1 = "delete from user_customer where customerid = " + id;
			
			ps = conn.prepareStatement(sql1);
			ps.executeUpdate();
			
			String sql2 = "";
			for (String userid : userList) {
				sql2 = "insert into user_customer(userid, customerid) values(?, ?)";
				ps = conn.prepareStatement(sql2);
				ps.setInt(1, Integer.valueOf(userid).intValue());
				ps.setInt(2, id);
				ps.executeUpdate();
			}
			
			conn.commit();
			
			return true;
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return false;
	}
	
	public boolean deleteCustomer(int id) throws SQLException {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		conn.setAutoCommit(false);
		try {	
			String sql = "delete from customer where id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			String sql1 = "delete from user_customer where customerid = ?";
			ps = conn.prepareStatement(sql1);
			ps.setInt(1, id);
			ps.executeUpdate();
			
			conn.commit();
			
			return true;
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
		return false;
	}
	
	public int excute(String sql,Object[] obj, Connection conn) throws SQLException {
		int row = 0;  
		int len = obj.length;    
		ps = conn.prepareStatement(sql);
		preparSql(obj, len);   
		row = ps.executeUpdate();   
		 
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
