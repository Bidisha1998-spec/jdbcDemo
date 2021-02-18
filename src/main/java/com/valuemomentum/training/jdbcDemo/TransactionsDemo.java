package com.valuemomentum.training.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

 

public class TransactionsDemo {

 

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Bidi@1234");
         System.out.println("driver is loaded");
         Statement stmt=con.createStatement();
         con.setAutoCommit(false);
         try
         {
             int i1= stmt.executeUpdate("insert into candidate_skills values(111,5)");
             int i2= stmt.executeUpdate("update skills set name='Spring' where id=4");
             int i3= stmt.executeUpdate("delete from candidiates where id=4");
             con.commit();
             System.out.println("transaction is success");
         }
         catch(Exception e)
         {
             try
             {
                con.rollback();
                System.out.println("transaction is failed");
             }
             catch(Exception ex)
             {
                 System.out.println(ex);
             }
             }
         stmt.close();
         con.close();
         System.out.println("connection is close");
    }

 

}