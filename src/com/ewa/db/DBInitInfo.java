package com.ewa.db;

import java.util.ArrayList;  
import java.util.List;
import java.io.IOException;
import java.io.InputStream; 
import java.util.Properties;

public class DBInitInfo {
	public  static List<DBbean>  beans = null;  
	private static String driver = "com.mysql.jdbc.Driver";  
	private static String url = "jdbc:mysql://127.0.0.1:3306/ews?autoReconnect=true";  
	private static String username ="root";  
	private static String password = ""; 
    static{  
        beans = new ArrayList<DBbean>();  
        
        Properties p = new Properties();
        InputStream in = DBInitInfo.class.getResourceAsStream("/db.properties");  
        try {
			p.load(in);
			in.close();
			
			driver = p.getProperty("driver"); 
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("url:" + url);
        
        DBbean beanOracle = new DBbean();  
        beanOracle.setDriverName(driver);  
        beanOracle.setUrl(url);  
        beanOracle.setUserName(username);  
        beanOracle.setPassword(password);  
          
        beanOracle.setMinConnections(5);  
        beanOracle.setMaxConnections(100);  
          
        beanOracle.setPoolName("testPool");  
        beans.add(beanOracle);  
    }  
}
