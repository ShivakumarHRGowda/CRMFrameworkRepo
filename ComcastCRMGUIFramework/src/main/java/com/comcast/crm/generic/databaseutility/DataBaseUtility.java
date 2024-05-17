package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility {

	Connection con;
   //connect to DB
	public void getDBConnection(String url, String username, String password) throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {

		}
	}
	
	
	//connect database with HardCoded URL,userName,password
	public void getDBConnection() throws SQLException {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		} catch (Exception e) {

		}
	}
	
	//close DB
	public void closeDBConnection() throws SQLException {
		con.close();
	}
	
	//execute non-select query
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet result=null;
		try {
			Statement statement=con.createStatement();
		 result=statement.executeQuery(query);
		}catch (Exception e) {
			
		}
		return result;
	}
	
	//execute select query
		public int executeNonSelectQuery(String query) throws SQLException {
			int result=0;
			try {
				Statement statement=con.createStatement();
			 result=statement.executeUpdate(query);
			}catch (Exception e) {
				
			}
			return result;
		}

}
