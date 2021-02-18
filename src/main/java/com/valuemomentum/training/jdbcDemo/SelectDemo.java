package com.valuemomentum.training.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {
		 Connection con;
         Statement stmt;
         ResultSet rs;
         
         try {
             //register JDBC driver
             Class.forName("com.mysql.cj.jdbc.Driver");
             
             //Open a connection
             System.out.println("Connecting to database...");
             System.out.println("id  first_name   last_name     dob          phone           email");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Bidi@1234");
             
             //Execute a query
             stmt=con.createStatement();
            rs=stmt.executeQuery("Select * from candidates");
            
             
             
             //Extract data from result set
             while(rs.next()) {
                 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"         "+rs.getString(3)+
                         "    "+rs.getDate(4)+"   "+rs.getString(5)+"    "+rs.getString(6));
             }
          rs.close();
          stmt.close();
          con.close();
      }
      catch(Exception e) {
          System.out.println(e);
      }
          
   }
   

	}


