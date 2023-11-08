package com.qsp.sms.batchexecution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BatchExecution {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-project-m1", properties);
			
			Statement statement = connection.createStatement();
			
			statement.addBatch("INSERT INTO students VALUES(1,'khushal')");
			statement.addBatch("INSERT INTO students VALUES(2,'santosh')");
			statement.addBatch("INSERT INTO students VALUES(3,'omkar')");
			statement.addBatch("INSERT INTO students VALUES(4,'prathamesh')");
			
			int[] executeBatch = statement.executeBatch();
			
			for (int i = 0; i < executeBatch.length; i++) {
				System.out.println("Number of Rows :"+executeBatch[i]);
			}
			
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
