package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Models.TAIKHOAN;
import Util.HandleException;
import Util.JDBC;



public class TaiKhoanDAO {
	private static final String INSERT_TAIKHOAN_SQL = "INSERT INTO nckh.taikhoan" +
	        "  (IDDangNhap, MatKhau, ROLE_User) VALUES " + " (?, ?, ?);";

    private static final String SELECT_ALL_TAIKHOAN = "SELECT IDDangNhap, MatKhau, ROLE_User FROM nckh.taikhoan";
    
    public TaiKhoanDAO() {}
    
    public void insertTK(TAIKHOAN tk) throws SQLException {
		System.out.println(INSERT_TAIKHOAN_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TAIKHOAN_SQL)) {
            preparedStatement.setString(1, tk.getiDDangNhap());
            preparedStatement.setString(2, tk.getMatKhau());
            preparedStatement.setString(3, tk.getrOLE_User());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
    
    public List<TAIKHOAN> selectAllTaiKhoans() {
		// using try-with-resources to avoid closing resources (boiler plate code)
        List <TAIKHOAN> taikhoans = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TAIKHOAN);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String IDDangNhap1 = rs.getString("IDDangNhap");
                String MatKhau1 = rs.getString("MatKhau");
                String ROLE_User1 = rs.getString("ROLE_User");
                taikhoans.add(new TAIKHOAN(IDDangNhap1, MatKhau1, ROLE_User1));
            }
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
        return taikhoans;
	}
}
