package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.GIANGVIEN;
import Util.HandleException;
import Util.JDBC;

public class GiangVienDAO {
	private static final String INSERT_GIANGVIEN_SQL = "INSERT INTO nckh.giangvien" +
	        "  (MaGV, TenGV, TrinhDo, ID, MaKhoa) VALUES " + " (?, ?, ?, ?, ?);";
	public GiangVienDAO() {}
	public void insertGV(GIANGVIEN gv) throws SQLException {
		System.out.println(INSERT_GIANGVIEN_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GIANGVIEN_SQL)) {
            preparedStatement.setString(1, gv.getMaGV());
            preparedStatement.setString(2, gv.getTenGV());
            preparedStatement.setString(3, gv.getTrinhDo());
            preparedStatement.setString(4, gv.getiD());
            preparedStatement.setString(5, gv.getMaKhoa());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	public String findNextMaGV() {
	    String sql = "SELECT MAX(MaGV) FROM nckh.giangvien";
	    String nextMaGV = "GV000";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaGV = rs.getString(1);
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaGV.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "GV" + numberStr;
	}
	public static GIANGVIEN layThongTinGV(String MaGV) {
		GIANGVIEN gv = null;
        ResultSet rs = null;
        
		String query = "SELECT * FROM GIANGVIEN WHERE MaGV = ?";
        try {
        	Connection connection = JDBC.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(query);
        	preparedStatement.setString(1, MaGV);
        	rs = preparedStatement.executeQuery();
        	if (rs.next()) {
                String tenGV = rs.getString("TenGV");
                String trinhdo = rs.getString("TrinhDo");
                String id = rs.getString("ID");
                String makhoa = rs.getString("MaKhoa");
                gv = new GIANGVIEN(MaGV, tenGV, trinhdo, id, makhoa);
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return gv;
	}
	
	public static boolean capNhatThongTinGV(GIANGVIEN gv) {
        boolean updated = false;
        String query = "UPDATE GIANGVIEN SET TenGV = ?, TrinhDo = ?, ID = ?, MaKhoa = ? WHERE MaGV = ?";
        try {
            Connection connection = JDBC.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gv.getTenGV());
            preparedStatement.setString(2, gv.getTrinhDo());
            preparedStatement.setString(3, gv.getiD());
            preparedStatement.setString(4, gv.getMaKhoa());
            preparedStatement.setString(5, gv.getMaGV());
            int rowsAffected = preparedStatement.executeUpdate();
            updated = (rowsAffected > 0);
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return updated;
    }
}
