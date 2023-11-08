package com.qsp.sms.inrecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import org.postgresql.Driver;

public class InsertNRecord {

	public static void main(String[] args) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);

			FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/my-first-project-m1",
					properties);

			String query = "INSERT INTO students VALUES(?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			boolean flag = true;
			byte check = 1;
			Scanner myInput = new Scanner(System.in);
			do {
				int id = 0;
				String name = null;
				System.out.print("Enter id : ");
				id = myInput.nextInt();
				myInput.nextLine();
				System.out.print("Enter Name : ");
				name=myInput.nextLine();
				prepareStatement.setInt(1, id);
				prepareStatement.setString(2, name);
				System.out.println("Do you want to add more record ? 1:yes 0:no");
				check = myInput.nextByte();

				if (check == 0) {
					flag = false;
				}
				prepareStatement.execute();
			} while (flag);
			System.out.println("Data Inserted");
			connection.close();
			myInput.close();

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
