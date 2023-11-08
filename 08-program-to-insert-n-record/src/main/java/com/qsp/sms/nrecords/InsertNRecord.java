package com.qsp.sms.nrecords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

			Statement statement = connection.createStatement();

			boolean flag = true;
			byte loop = 1;
			Scanner myInput = new Scanner(System.in);
			do {
				int id = 0;
				String name = null;
				System.out.println("Enter id : ");
				id = myInput.nextInt();
				myInput.nextLine();
				System.out.println("Enter name : ");
				name = myInput.nextLine();
				statement.execute("INSERT INTO students VALUES(" + id + ",'" + name + "');");
				System.out.println("Do you want to add more records ? yes:1 No:0");
				loop = myInput.nextByte();
				if (loop == 0) {
					flag = false;
				}
			} while (flag);
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
