package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
	public static Connection myconnection(){
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123456789");
		} 
		catch (ClassNotFoundException | SQLException e)	{
			e.printStackTrace();
		}
		return con;
	}
}

/* 
  create table Employee1
(
 Employeeid int primary key,
 Name varchar2(100) not null,
 Address varchar2(200) not null,
 salary number(5) not null,
Gender varchar2(10),
Birthdate varchar2(15)
);  
 */