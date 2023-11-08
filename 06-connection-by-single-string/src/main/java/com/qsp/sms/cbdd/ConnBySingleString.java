package com.qsp.sms.cbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnBySingleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-project-m1?user=postgres&password=root");
			
			Statement statement = connection.createStatement();
			
			statement.execute("INSERT INTO students VALUES(4,'omkar')");
			
			connection.close();
			System.out.println("Data insertred");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
