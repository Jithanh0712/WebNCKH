package DAO;

import java.io.UnsupportedEncodingException;
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
	
	private static final String SELECT_GIANGVIEN_BYID = "SELECT * FROM GIANGVIEN WHERE ID = ?";
	private static final String UPDATE_GV = "UPDATE GIANGVIEN SET TenGV = ?, TrinhDo = ?, MaKhoa = ? WHERE ID = ?";
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
	public GIANGVIEN layThongTinGV(String ID) throws SQLException{
		GIANGVIEN gv = null;
        ResultSet rs = null;
        
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GIANGVIEN_BYID);)
        {
        	preparedStatement.setString(1, ID);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                String tenGV = rs.getString("TenGV");
                String trinhdo = rs.getString("TrinhDo");
                String MaGV = rs.getString("MaGV");
                String makhoa = rs.getString("MaKhoa");
                gv = new GIANGVIEN(MaGV, tenGV, trinhdo, ID, makhoa);
               
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return gv;
	}
	
	public boolean capNhatThongTinGV(GIANGVIEN gv) throws SQLException{
		
        boolean updated = false;
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_GV);) {
        	statement.setString(1, gv.getTenGV());
        	//System.out.println(gv.getTenGV());
        	statement.setString(2, gv.getTrinhDo());
        	statement.setString(3, gv.getMaKhoa());
        	statement.setString(4, gv.getiD());
            int rowsAffected = statement.executeUpdate();
            updated = (rowsAffected > 0);
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        } 
        return updated;
    }
}
