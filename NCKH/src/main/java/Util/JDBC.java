package Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			String url = "jdbc:mysql://localhost:3306/nckh?useUnicode=true&characterEncoding=UTF-8";
			String username = "root";
			String password = "Thanh07122904";

			
			conn = DriverManager.getConnection(url, username, password);
			
			//System.out.println("Connection successfully!");
		} catch (SQLException e) {
			System.out.println("Connection error...");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null) {
				System.out.println("Close connection!");
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
