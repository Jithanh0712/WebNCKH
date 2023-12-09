package Util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Main_JDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = JDBC.getConnection();
			
			//GET DATA
			String query = "SELECT * FROM nckh.taikhoan";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
			//INSERT
			/*try {
				String query_i = "INSERT INTO hello.sinhvien(MSSV, HoTen) VALUES(?,?)";
				PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(query_i);
				preparedStatement.setString(1, "4");
				preparedStatement.setString(2, "Phong");
				
				int row = preparedStatement.executeUpdate();
				
				if (row!=0) {
					System.out.println("Insert success!");
				}
			} catch (Exception ex) {
				
			}*/
			
			//UPDATE
			/*try {
				String query_u = "UPDATE hello.sinhvien SET HoTen=? where MSSV=?";
				PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(query_u);
				preparedStatement.setString(1, "An");
				preparedStatement.setInt(2, 4);
				int row = preparedStatement.executeUpdate();
				
				if (row != 0) {
					System.out.println("Update success");
				}
			} catch (Exception ex) {
				
			}*/
			
			//DELETE
			/*try {
				String query_d = "DELETE FROM hello.sinhvien WHERE MSSV=?";
				PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(query_d);
				preparedStatement.setInt(1,1);
				int row = preparedStatement.executeUpdate();
				
				if(row!=0) {
					System.out.println("Delete success!");
				}
			} catch (Exception ex) {
				
			}*/
			
			
			JDBC.closeConnection(conn);
		}
		catch (Exception ex) {
			
		}
	}

}
