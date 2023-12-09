package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/nckh";
        String user = "root";
        String password = "Thanh07122904";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from nckh.taikhoan";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String IDDangNhap = resultSet.getString("IDDangNhap");
                String MatKhau = resultSet.getString("MatKhau");

                System.out.println("ID đăng nhập: " + IDDangNhap);
                System.out.println("Mật khẩu: " + MatKhau);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

	}

}
