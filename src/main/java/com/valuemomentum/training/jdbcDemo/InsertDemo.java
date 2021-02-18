package com.valuemomentum.training.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {
		 Connection con;
	        Statement stmt;
	        ResultSet rs;
	        int cnt=0;
	        try {
	            //register JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            //Open a connection
	            System.out.println("Connecting to database...");
	            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Bidi@1234");
	            
	            String str= "INSERT INTO Skills(name)"+ "VALUES('Hibernate')";
	        
	            stmt=con.createStatement();
	            
	            int rowcount= stmt.executeUpdate(str);
	            if(rowcount>0)
	            {
	            	System.out.println("Record inserted successfully");
	            }
	            
	            String str1= "select count(id) from skills";
		        
	            stmt=con.createStatement();
	            
	            rs= stmt.executeQuery(str1);
	            
	                               
	            while(rs.next()) {
	            	cnt= rs.getInt(1);
	            }
	                         System.out.println("total no of records is="+cnt);
	                         con.close();
	                                 
	                     }
	                  
	              catch(Exception e) {
	                  System.out.println(e);
	              }
	                  

	}

}
