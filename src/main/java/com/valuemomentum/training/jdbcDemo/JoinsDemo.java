package com.valuemomentum.training.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinsDemo {


	public static void main(String[] args) {
		 Connection con;
        Statement stmt;
        ResultSet rs;
    
    try {
        //register JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Open a connection
        System.out.println("Connecting to database...");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Bidi@1234");
    
        stmt=con.createStatement();
                                
        rs=stmt.executeQuery("select c.id,first_name,name from candidates c INNER JOIN  candidate_skills s ON "
        		+ "c.id=candidate_id  INNER JOIN  skills sk ON s.skill_id=sk.id");
                           
        while(rs.next()) {
                     System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
                             
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