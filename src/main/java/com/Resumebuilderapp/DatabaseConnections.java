package com.Resumebuilderapp;
import java.sql.*;
public class DatabaseConnections { 

    public static String url = "jdbc:mysql://localhost:3306/pract";    

    public static String driverName = "com.mysql.cj.jdbc.Driver";   

    public static String username = "root";   

    public static  String password = "123456";

    public static Connection con;

    private static String urlstring;
    
    public static Connection getConnection(){
    	try {
    	Class.forName(driverName);
    	con=DriverManager.getConnection(url,username,password);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return con;
	}
}




