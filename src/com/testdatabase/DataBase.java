package com.testdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class DataBase {

	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_url="jdbc:mysql://localhost/learnphp";
	static final String username="learnphp";
	static final String password ="Password@123";
	
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("conn to db");
			conn=DriverManager.getConnection(DB_url,username,password);
			System.out.println("create statement");
			stmt=conn.createStatement();
			String sql;
			sql="select name from user_details";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				String name=rs.getString("name");
				System.out.println(name);
				
			}
		}catch(SQLException se){
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
