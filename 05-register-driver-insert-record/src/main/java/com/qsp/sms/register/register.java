package com.qsp.sms.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.Driver;

public class register {
	public static void main(String[] args) {
		try {
			//Step 1: Register Driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-project-m1", "postgres", "root");
			
			Statement statement = connection.createStatement();
			
			statement.execute("INSERT INTO Students VALUES(2,'khushal');INSERT INTO Students VALUES(3,'SAHIL')");
			
			connection.close();
			System.out.println("data inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
