package com.valuemomentum.training.jdbcDemo;

import java.sql.*;
import java.util.*;

 

public class UpdateDemo
{
public static void main(String[] args)
{
Connection con;

ResultSet rs;
int cnt=0;
PreparedStatement pstmt;
String sqlUpdate;

try
{
// register jdbc driver
Class.forName("com.mysql.cj.jdbc.Driver");
// Creating connection object
System.out.println("Connection to database");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Bidi@1234");
sqlUpdate= "UPDATE candidates "
+ "SET last_Name = ?"
+ "where id= ?";
pstmt=con.prepareStatement(sqlUpdate);
Scanner sc=new Scanner(System.in);
System.out.println("enter employee id");
int eid=sc.nextInt();
System.out.println("enter emplyee name");
String lastname=sc.next();

pstmt.setString(1,lastname);
pstmt.setInt(2,eid);

int rowsAffected= pstmt.executeUpdate();
System.out.println(String.format("Rows affected %d",rowsAffected));

//reuse the prepared statement
lastname="grohe";
eid=101;
pstmt.setString(1,lastname);
pstmt.setInt(2,eid);
rowsAffected= pstmt.executeUpdate();
System.out.println(String.format("Rows affected %d",rowsAffected));
con.close();

}
catch(Exception e ) {
System.out.println(e);
}
}
}