package com.qsp.sms.beps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.postgresql.Driver;

public class BatchExecutionPreparedStatement {

	public static void main(String[] args) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-project-m1", properties);
			PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO friends VALUES(?,?);");
			prepareStatement.setInt(1, 1);
			prepareStatement.setString(2, "khushal");
			prepareStatement.addBatch();
			prepareStatement.setInt(1, 2);
			prepareStatement.setString(2, "sahil");
			prepareStatement.addBatch();
			prepareStatement.setInt(1, 3);
			prepareStatement.setString(2, "omkar");
			prepareStatement.addBatch();
			int[] executeBatch = prepareStatement.executeBatch();
			for (int i = 0; i < executeBatch.length; i++) {
				System.out.println("Number of Rows :"+executeBatch[i]);
			}
			connection.close();
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
