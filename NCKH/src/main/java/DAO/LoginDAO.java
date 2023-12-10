package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Models.TAIKHOAN;
import Util.HandleException;
import Util.JDBC;


public class LoginDAO {
	public TAIKHOAN onLogin(TAIKHOAN loginData) throws ClassNotFoundException {
		TAIKHOAN tk = null;

        try{
        	// Step 1: Mở kết nối đến MySQL
        	Connection conn = JDBC.getConnection();
        	// Step 2:Create a statement using connection object
        	PreparedStatement preparedStatement = conn
        			.prepareStatement("select * from nckh.taikhoan where IDDangNhap = ? and MatKhau = ? ");
            preparedStatement.setString(1, loginData.getiDDangNhap());
            preparedStatement.setString(2, loginData.getMatKhau());

            ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				tk = new TAIKHOAN();
				tk.setiDDangNhap(rs.getString(1));
				tk.setrOLE_User(rs.getString(3));
			}

        } catch (SQLException e) {
            // process sql exception
            HandleException.printSQLException(e);
        }
        return tk;
    }
}
