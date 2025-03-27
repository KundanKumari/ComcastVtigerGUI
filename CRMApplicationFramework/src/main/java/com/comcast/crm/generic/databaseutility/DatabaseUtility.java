package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
//getDbconnection method is used to connect the database, have to pass proper un, pwd, url 
	Connection con;
	public void getDbconnection(String url, String username, String password) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		 con=DriverManager.getConnection(url, username, password);
		
		}catch (Exception e) {
			
		}
	}
//getDbconnection method is used to connect default database which is available for project
	public void getDbconnection() throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		 con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		
		}catch (Exception e) {
			
		}
	}
    public ResultSet executeConSelectQuery(String query) throws Throwable {
    	ResultSet result = null;
    	try {
    	Statement stat = con.createStatement();
    	 result=stat.executeQuery(query);
    	}catch(Exception e) {
    		
    	}
		return result;
    }
    public int executeNonSelectQuery(String query) {
            int result = 0;
    	try {
    	Statement stat = con.createStatement();
    	 result=stat.executeUpdate(query);
    	}catch(Exception e) {
    		
    	}
		return result;
    }
  //after execute the any one query makesure close the connection of database
		public void closeDbconnection() throws Throwable {
			try {
			con.close();
		}catch(Exception e) {
		}
		
    }
}
