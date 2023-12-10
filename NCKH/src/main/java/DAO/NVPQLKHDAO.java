package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.NVPQLKH;
import Util.HandleException;
import Util.JDBC;

public class NVPQLKHDAO {
	private static final String INSERT_NVPQLKH_SQL = "INSERT INTO nckh.nvpqlkh" +
	        "  (MaNV, TenNV, KinhNghiem, Email, ID) VALUES " + " (?, ?, ?, ?, ?);";
	public NVPQLKHDAO() {}
	public void insertNVPQLKH(NVPQLKH nv) throws SQLException {
		System.out.println(INSERT_NVPQLKH_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NVPQLKH_SQL)) {
            preparedStatement.setString(1, nv.getMaNV());
            preparedStatement.setString(2, nv.getTenNV());
            preparedStatement.setInt(3, nv.getKinhNghiem());
            preparedStatement.setString(4, nv.getEmail());
            preparedStatement.setString(5, nv.getiD());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	public String findNextMaNV() {
	    String sql = "SELECT MAX(MaNV) FROM nckh.nvpqlkh";
	    String nextMaNV = "NV000";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaNV = rs.getString(1);
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaNV.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "NV" + numberStr;
	}
}
