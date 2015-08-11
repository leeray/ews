package com.ewa.bean;

public class WorksBean {
	private CustomerBean customer;
	private UserBean user;
	
	private int id;
	public CustomerBean getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public boolean isIsphonecall() {
		return isphonecall;
	}
	public void setIsphonecall(boolean isphonecall) {
		this.isphonecall = isphonecall;
	}
	public String getPhonecallnumber() {
		return phonecallnumber;
	}
	public void setPhonecallnumber(String phonecallnumber) {
		this.phonecallnumber = phonecallnumber;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public int getIsclosed() {
		return isclosed;
	}
	public void setIsclosed(int isclosed) {
		this.isclosed = isclosed;
	}
	private String level; //事件属性 1级  2级  3级
	private String describe; //事件描述
	private boolean isphonecall; //是否转800
	private String phonecallnumber; //800 case电话
	private String solution; //解决方案
	private int isclosed;   //0:未关闭  1:关闭
	
	private int customerid;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	private int userid;
	
	public java.sql.Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(java.sql.Date createdate) {
		this.createdate = createdate;
	}
	public java.sql.Date getClosedate() {
		return closedate;
	}
	public void setClosedate(java.sql.Date closedate) {
		this.closedate = closedate;
	}
	private java.sql.Date createdate;
	private java.sql.Date closedate;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	private String username;
	private String customername;
	
	private String newcontent;
	public String getNewcontent() {
		return newcontent;
	}
	public void setNewcontent(String newcontent) {
		this.newcontent = newcontent;
	}
	
	private String erjidanwei;
	private String kehulianxiren;
	private String lianxifangshi;
	private String lianximail;
	private String duquzhanghao;
	public String getErjidanwei() {
		return erjidanwei;
	}
	public void setErjidanwei(String erjidanwei) {
		this.erjidanwei = erjidanwei;
	}
	public String getKehulianxiren() {
		return kehulianxiren;
	}
	public void setKehulianxiren(String kehulianxiren) {
		this.kehulianxiren = kehulianxiren;
	}
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	public String getLianximail() {
		return lianximail;
	}
	public void setLianximail(String lianximail) {
		this.lianximail = lianximail;
	}
	public String getDuquzhanghao() {
		return duquzhanghao;
	}
	public void setDuquzhanghao(String duquzhanghao) {
		this.duquzhanghao = duquzhanghao;
	}
	
	
	
}
