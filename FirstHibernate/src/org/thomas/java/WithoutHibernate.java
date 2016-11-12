package org.thomas.java;

import java.sql.*;

public class WithoutHibernate {

   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

   //  Database credentials
   static final String USER = "thuya";
   static final String PASS = "password";	
	
	public static void main1(String[] args) {
		
		
	  Connection conn = null;
	  Statement stmt = null;
	   
      
      try {
    	  	//STEP 2: Register JDBC driver
    	  	Class.forName(JDBC_DRIVER);
		
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);			
		
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT userid, username, useradd1, useradd2 FROM userdetails";
		      ResultSet rs = stmt.executeQuery(sql);			
		      while(rs.next()){
		          //Retrieve by column name
		          int userid  = rs.getInt("userid");
		          String username = rs.getString("username");
		          String useradd1 = rs.getString("useradd1");
		          String useradd2 = rs.getString("useradd2");

		          //Display values
		          System.out.print("userid: " + userid);
		          System.out.print(", username: " + username);
		          System.out.print(", useradd1: " + useradd1);
		          System.out.println(", useradd2: " + useradd2);
		       }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	

	}

}
