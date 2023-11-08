package com.qsp.sms.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class read {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-project-m1", "postgres", "root");
			
			Statement statement = connection.createStatement();
			
			//4-program-to-read-data
			ResultSet resultSet = statement.executeQuery("SELECT * FROM students WHERE id=1");
			while(resultSet.next()) {
				System.out.println("id: "+resultSet.getInt(1));
				System.out.println("name: "+resultSet.getString(2));
			}
			
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
