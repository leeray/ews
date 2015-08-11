package com.ewa.bean.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.ewa.bean.*;
import com.ewa.db.*;

public class WorksDAO {
	private PreparedStatement ps; 
	private ResultSet rs;
	private Statement statement; 
	
	public boolean addWorks(int customerid, 
			String customername, 
			int userid, 
			String username, 
			String level, 
			String describe, 
			int isphonecall, 
			String phonecallnumber, 
			String solution, 
			int isclosed,
			String erjidanwei,
			String kehulianxiren,
			String lianxifangshi,
			String lianximail) throws SQLException {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		try {	
			String sql = "insert into works(fid, customerid, customername, userid, username, `level`, `describe`, isphonecall, phonecallnumber, solution, createtime, isclosed, erjidanwei,kehulianxiren,lianxifangshi,lianximail) values(0, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerid);
			ps.setString(2, customername);
			ps.setInt(3, userid);
			ps.setString(4, username);
			ps.setString(5, level);
			ps.setString(6, describe);
			ps.setInt(7, isphonecall);
			ps.setString(8, phonecallnumber);
			ps.setString(9, solution);
			ps.setDate(10, new Date(new java.util.Date().getTime()));
			ps.setInt(11, isclosed);
			ps.setString(12, erjidanwei);
			ps.setString(13, kehulianxiren);
			ps.setString(14, lianxifangshi);
			ps.setString(15, lianximail);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		return false;
	}
	
	public List<WorksBean> getAllWorks(int start, int count) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<WorksBean> workList = new ArrayList<WorksBean>();
		String sql = "select id,customerid,customername,userid,username,`level`,`describe`,isphonecall,phonecallnumber,solution,isclosed,createtime,closetime,newcontent,erjidanwei,kehulianxiren,lianxifangshi,lianximail from works where fid = 0  order by createtime desc limit "+start+","+count;
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				WorksBean worksBean = new WorksBean();  
				worksBean.setId(rs.getInt("id"));  
				worksBean.setCustomerid(rs.getInt("customerid"));
				worksBean.setCustomername(rs.getString("customername"));
				worksBean.setUserid(rs.getInt("userid"));
				worksBean.setUsername(rs.getString("username"));
				worksBean.setLevel(rs.getString("level"));    
				worksBean.setDescribe(rs.getString("describe"));    
				worksBean.setIsphonecall(rs.getBoolean("isphonecall"));  
				worksBean.setPhonecallnumber(rs.getString("phonecallnumber"));  
				worksBean.setSolution(rs.getString("solution")); 
				worksBean.setIsclosed(rs.getInt("isclosed"));
				worksBean.setCreatedate(rs.getDate("createtime"));
				worksBean.setClosedate(rs.getDate("closetime"));
				worksBean.setNewcontent(rs.getString("newcontent"));
				worksBean.setErjidanwei(rs.getString("erjidanwei"));
				worksBean.setKehulianxiren(rs.getString("kehulianxiren"));
				worksBean.setLianxifangshi(rs.getString("lianxifangshi"));
				worksBean.setLianximail(rs.getString("lianximail"));
				workList.add(worksBean);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return workList;
	}
	
	public int getAllWorksCount() {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		String sql = "select count(*) from works where fid = 0 ";
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
	
	public List<WorksBean> getAllWorks(int userid, int start, int count) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<WorksBean> workList = new ArrayList<WorksBean>();
		String sql = "select id,customerid,customername,userid,username,`level`,`describe`,isphonecall,phonecallnumber,solution,isclosed,createtime,closetime,newcontent,erjidanwei,kehulianxiren,lianxifangshi,lianximail from works where fid = 0 and userid= "+ userid+" order by createtime desc limit "+start+","+count;
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				WorksBean worksBean = new WorksBean();  
				worksBean.setId(rs.getInt("id"));  
				worksBean.setCustomerid(rs.getInt("customerid"));
				worksBean.setCustomername(rs.getString("customername"));
				worksBean.setUserid(rs.getInt("userid"));
				worksBean.setUsername(rs.getString("username"));
				worksBean.setLevel(rs.getString("level"));    
				worksBean.setDescribe(rs.getString("describe"));    
				worksBean.setIsphonecall(rs.getBoolean("isphonecall"));  
				worksBean.setPhonecallnumber(rs.getString("phonecallnumber"));  
				worksBean.setSolution(rs.getString("solution")); 
				worksBean.setIsclosed(rs.getInt("isclosed"));
				worksBean.setCreatedate(rs.getDate("createtime"));
				worksBean.setClosedate(rs.getDate("closetime"));
				worksBean.setNewcontent(rs.getString("newcontent"));
				worksBean.setErjidanwei(rs.getString("erjidanwei"));
				worksBean.setKehulianxiren(rs.getString("kehulianxiren"));
				worksBean.setLianxifangshi(rs.getString("lianxifangshi"));
				worksBean.setLianximail(rs.getString("lianximail"));
				workList.add(worksBean);
			} 
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return workList;
	}
	
	public int getAllWorksCount(int userid) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		String sql = "select count(*) from works where fid = 0 and userid= "+ userid+"  order by createtime desc";
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
	
	public List<WorksBean> getWorksHistory(int id) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<WorksBean> workList = new ArrayList<WorksBean>();
		String sql = "select id,customerid,customername,userid,username,`level`,`describe`,isphonecall,phonecallnumber,solution,isclosed,createtime,closetime,newcontent,erjidanwei,kehulianxiren,lianxifangshi,lianximail from works where fid = " + id + " or id = " +id + " order by id";
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				WorksBean worksBean = new WorksBean();  
				worksBean.setId(rs.getInt("id"));  
				worksBean.setCustomerid(rs.getInt("customerid"));
				worksBean.setCustomername(rs.getString("customername"));
				worksBean.setUserid(rs.getInt("userid"));
				worksBean.setUsername(rs.getString("username"));
				worksBean.setLevel(rs.getString("level"));    
				worksBean.setDescribe(rs.getString("describe"));    
				worksBean.setIsphonecall(rs.getBoolean("isphonecall"));  
				worksBean.setPhonecallnumber(rs.getString("phonecallnumber"));  
				worksBean.setSolution(rs.getString("solution")); 
				worksBean.setIsclosed(rs.getInt("isclosed"));
				worksBean.setCreatedate(rs.getDate("createtime"));
				worksBean.setClosedate(rs.getDate("closetime"));
				worksBean.setNewcontent(rs.getString("newcontent"));
				worksBean.setErjidanwei(rs.getString("erjidanwei"));
				worksBean.setKehulianxiren(rs.getString("kehulianxiren"));
				worksBean.setLianxifangshi(rs.getString("lianxifangshi"));
				worksBean.setLianximail(rs.getString("lianximail"));
				workList.add(worksBean);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return workList;
	}
	
	public int getWorksHistoryCount(int id) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		String sql = "select count(*) from works where fid = " + id + " or id = " +id;
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
	
	public List<WorksBean> findWorks(String userid, String username, String customername, String isclosed, String createdate, String closedate, int start, int count) throws SQLException{
		
		String where = "fid=0";
		
		if (userid != null && !userid.isEmpty()) {
			where += " and userid = " + userid;
		}
		
		if (customername!=null && !customername.isEmpty() ) {
			where += " and customername like '%" + customername + "%' ";
		}
		
		if (username!=null && !username.isEmpty() ) {
			where += " and username like '%" + username +"%' ";
		}
		
		if (createdate != null) {
			where += " and createtime = '" + createdate + "'";
		}
		
		if (closedate != null) {
			where += " and closetime = '" + closedate + "'";
		}
		
		if (isclosed != null && !isclosed.isEmpty()) {
			int close = Integer.valueOf(isclosed);
			where += " and isclosed = " + close;
		}
		
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		List<WorksBean> workList = new ArrayList<WorksBean>();
		String sql = "select id,customerid,customername,userid,username,level,`describe`,isphonecall,phonecallnumber,solution,isclosed,createtime,closetime, newcontent,erjidanwei,kehulianxiren,lianxifangshi,lianximail from works where "+ where +" order by createtime desc limit "+start+","+count;
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			while (rs.next()) { 
				WorksBean worksBean = new WorksBean();
				worksBean.setId(rs.getInt("id"));  
				worksBean.setCustomerid(rs.getInt("customerid"));
				worksBean.setCustomername(rs.getString("customername"));
				worksBean.setUserid(rs.getInt("userid"));
				worksBean.setUsername(rs.getString("username"));
				worksBean.setLevel(rs.getString("level"));    
				worksBean.setDescribe(rs.getString("describe"));    
				worksBean.setIsphonecall(rs.getBoolean("isphonecall"));  
				worksBean.setPhonecallnumber(rs.getString("phonecallnumber"));  
				worksBean.setSolution(rs.getString("solution")); 
				worksBean.setIsclosed(rs.getInt("isclosed"));
				worksBean.setCreatedate(rs.getDate("createtime"));
				worksBean.setClosedate(rs.getDate("closetime"));
				worksBean.setNewcontent(rs.getString("newcontent"));
				worksBean.setErjidanwei(rs.getString("erjidanwei"));
				worksBean.setKehulianxiren(rs.getString("kehulianxiren"));
				worksBean.setLianxifangshi(rs.getString("lianxifangshi"));
				worksBean.setLianximail(rs.getString("lianximail"));
				workList.add(worksBean);
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return workList;
	}
	
	public int findWorksCount(String userid, String username, String customername, String isclosed, String createdate, String closedate) throws SQLException {
		
		String where = "fid=0";
		
		if (userid != null && !userid.isEmpty()) {
			where += " and userid = " + userid;
		}
		
		if (customername!=null && !customername.isEmpty() ) {
			where += " and customername like '%" + customername + "%' ";
		}
		
		if (username!=null && !username.isEmpty() ) {
			where += " and username like '%" + username +"%' ";
		}
		
		if (createdate != null) {
			where += " and createtime = '" + createdate + "'";
		}
		
		if (closedate != null) {
			where += " and closetime = '" + closedate + "'";
		}
		
		if (isclosed != null && !isclosed.isEmpty()) {
			int close = Integer.valueOf(isclosed);
			where += " and isclosed = " + close;
		}
		
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		String sql = "select count(*) from works where "+ where;
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
	
	public WorksBean getWorksById(int id) throws SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		String sql = "select id,customerid,customername,userid,username,`level`,`describe`,isphonecall,phonecallnumber,solution,isclosed,createtime,closetime,newcontent,erjidanwei,kehulianxiren,lianxifangshi,lianximail from works where id = " + id;
		try { 
			statement = (Statement)conn.createStatement();
			rs = statement.executeQuery(sql);
			
			if (rs.next()) { 
				WorksBean worksBean = new WorksBean();  
				worksBean.setId(rs.getInt("id"));  
				worksBean.setCustomerid(rs.getInt("customerid"));
				worksBean.setCustomername(rs.getString("customername"));
				worksBean.setUserid(rs.getInt("userid"));
				worksBean.setUsername(rs.getString("username"));
				worksBean.setLevel(rs.getString("level"));    
				worksBean.setDescribe(rs.getString("describe"));    
				worksBean.setIsphonecall(rs.getBoolean("isphonecall"));  
				worksBean.setPhonecallnumber(rs.getString("phonecallnumber"));  
				worksBean.setSolution(rs.getString("solution")); 
				worksBean.setIsclosed(rs.getInt("isclosed"));
				worksBean.setCreatedate(rs.getDate("createtime"));
				worksBean.setClosedate(rs.getDate("closetime"));
				worksBean.setNewcontent(rs.getString("newcontent"));
				worksBean.setErjidanwei(rs.getString("erjidanwei"));
				worksBean.setKehulianxiren(rs.getString("kehulianxiren"));
				worksBean.setLianxifangshi(rs.getString("lianxifangshi"));
				worksBean.setLianximail(rs.getString("lianximail"));
				return worksBean;
			}   
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return null;
	}
	
	public boolean delWorksById(int id) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		String sql = "delete from works where id = " + id;
		try { 
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return false;
	}
	
	public boolean updateWorks(int id, String describe, boolean isphonecall, String phonecallnumber, String solution) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		String sql = "update works set `describe` = ?, isphonecall = ?, phonecallnumber = ?, solution = ?, closetime = ? where id = ?";
		try { 
			int row = this.excute(sql, new Object[]{describe, isphonecall, phonecallnumber, solution, new Date(new java.util.Date().getTime()), id});
			
			if (row > 0) { 
				return true; 
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}   
		return false;
	}
	
	public boolean updateWorks(int id, 
			int customerid, 
			String customername, 
			int userid, 
			String username, 
			String level, 
			String describe, 
			int isphonecall, 
			String phonecallnumber, 
			String solution, 
			int isclosed, 
			String newcontent,
			String erjidanwei,
			String kehulianxiren,
			String lianxifangshi,
			String lianximail) throws SQLException{
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		try {	
			String sql = "insert into works(fid, customerid, customername, userid, username, `level`, `describe`, isphonecall, phonecallnumber, solution, createtime, newcontent, isclosed, erjidanwei,kehulianxiren,lianxifangshi,lianximail) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, customerid);
			ps.setString(3, customername);
			ps.setInt(4, userid);
			ps.setString(5, username);
			ps.setString(6, level);
			ps.setString(7, describe);
			ps.setInt(8, isphonecall);
			ps.setString(9, phonecallnumber);
			ps.setString(10, solution);
			ps.setDate(11,  new Date(new java.util.Date().getTime()));
			ps.setString(12, newcontent);
			ps.setInt(13, isclosed);
			ps.setString(14, erjidanwei);
			ps.setString(15, kehulianxiren);
			ps.setString(16, lianxifangshi);
			ps.setString(17, lianximail);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			ConnectionPoolManager.getInstance().close("testPool", conn);
		}
		
		return false;
	}
	
	//只修改父列的close字段 和 关闭时间 
	public boolean updateWorksClosedField(int id, int isclosed) {
		Connection conn = ConnectionPoolManager.getInstance().getConnection("testPool");
		
		String sql = "update works set isclosed=?, closetime=?  where id = ? or fid = ?";
		try { 
			int row = this.excute(sql, new Object[]{isclosed, new java.sql.Date(new java.util.Date().getTime()), id, id});
			
			if (row > 0) { 
				return true; 
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();  
		} finally {
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
