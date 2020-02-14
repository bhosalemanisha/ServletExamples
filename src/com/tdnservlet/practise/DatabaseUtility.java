package com.tdnservlet.practise;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
	final  String DB_URL="jdbc:mysql://localhost:3306/student1";
	final  String DB_USER="root";
	final  String DB_PASSWORD="";
  
	public Connection getconnection() throws ClassNotFoundException, SQLException {
		Class.forName( "com.mysql.jdbc.Driver");
		Connection con =DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		return con;
	}


}
