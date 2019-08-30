package com.Ticket.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.Ticket.FileFormat.ITIL;
import com.google.gson.Gson;

public class DBConnect {

//	Host: sql12.freesqldatabase.com
//	Database name: sql12287507
//	Database user: sql12287507
//	Database password: 5YcTfI6ap7
//	Port number: 3306

	public static Connection conn() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com/sql12287507", "sql12287507",
					"5YcTfI6ap7");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static void insertQuery(List<ITIL> data) throws SQLException {

		Connection conn = conn();
		Statement stmt = conn.createStatement();

		for (int i = 0; i < data.size(); i++) {
			String insertQuery = "INSERT INTO sql12287507.ITIL_data"
					+ " (Id,Date,SR_ID,Subject,Status,Engineer,Description) " + "VALUES " + "('" + data.get(i).getId()
					+ "'," + "'" + data.get(i).getDate() + "'," + "'" + data.get(i).getSR_ID() + "'," + "'"
					+ data.get(i).getSubject() + "'," + "'" + data.get(i).getStatus() + "'," + "'"
					+ data.get(i).getEngineer() + "'," + "'" + data.get(i).getDescription() + "');";

			System.out.println(insertQuery);

			int inserted = 0;
			inserted = stmt.executeUpdate(insertQuery);
			if (inserted == 1) {
				System.out.println(data.get(i).getSR_ID() + " inserted Successfully!");
			} else if (inserted == 0) {
				System.out.println(data.get(i).getSR_ID() + " insert failed!");
			}

		}
		conn.close();
	}

	public static void insertQueryPS(List<ITIL> data) {

		Connection conn = conn();

		try {

			for (int i = 0; i < data.size(); i++) {
				if (!recordCheck(data.get(i).getSR_ID())) {
					String insertQuery = "INSERT INTO sql12287507.ITIL_data"
							+ " (Id,Date,SR_ID,Subject,Status,Engineer,Description) " + " values (?, ?, ?,?, ?, ?, ?)";

					PreparedStatement preparedStmt = conn.prepareStatement(insertQuery);
					preparedStmt.setString(1, data.get(i).getId());
					preparedStmt.setString(2, data.get(i).getDate());
					preparedStmt.setString(3, data.get(i).getSR_ID());
					preparedStmt.setString(4, data.get(i).getSubject());
					preparedStmt.setString(5, data.get(i).getStatus());
					preparedStmt.setString(6, data.get(i).getEngineer());
					preparedStmt.setString(7, data.get(i).getDescription());

					System.out.println(preparedStmt.toString());

					boolean isInserted = preparedStmt.execute();
					if (!isInserted) {
						System.out.println(data.get(i).getSR_ID() + " inserted Successfully!");
					} else if (isInserted) {
						System.out.println(data.get(i).getSR_ID() + " insert failed!");
					}
				}
			}

			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static boolean recordCheck(String SR_ID) throws Exception {
		// TODO Auto-generated method stub
		boolean exist = false;
		Connection conn = conn();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ITIL_data where SR_ID='" + SR_ID + "'");
			while (rs.next()) {
				exist = true;
			}

		} catch (Exception e) {
			conn.close();
			e.printStackTrace();
		}
		conn.close();
		return exist;
	}

	public static String listToJson(List<ITIL> studentList) {
		Gson gson = new Gson();
		String ITILList = gson.toJson(studentList);
		return ITILList;
	}
}
