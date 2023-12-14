package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.DANGKY;
import Util.HandleException;
import Util.JDBC;

public class DangKyDAO {
	private static final String INSERT_DANGKY_SQL = "INSERT INTO nckh.dangky" +
	        "  (MaDangKy, MaDeTai, MaGV, MaNhom) VALUES " + " (?, ?, ?, ?);";
	
	public DangKyDAO() {}
	
	public void insertDangKy(DANGKY dk) {
		try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DANGKY_SQL);) {
			preparedStatement.setString(1, dk.getMaDK());
			preparedStatement.setString(2, dk.getMaDeTai());
			preparedStatement.setString(3, dk.getMaGV());
			preparedStatement.setString(3, dk.getMaNhom());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
	}
	public String GenerateMaDK() {
	    String sql = "SELECT MAX(MaDK) FROM nckh.dangky";
	    String nextMaDK = "DK001";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaDK = rs.getString(1);
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaDK.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "DK" + numberStr;
	}
}
