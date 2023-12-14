package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DANGKY;
import Models.GIANGVIEN;
import Util.HandleException;
import Util.JDBC;

public class DangKyDAO {
	private static final String INSERT_DANGKY_SQL = "INSERT INTO nckh.dangky" +
	        "  (MaDangKy, MaDeTai, MaGV, MaNhom) VALUES " + " (?, ?, ?, ?);";
	private static final String UPDATE_TrangThai_DK = "UPDATE nckh.dangky SET TrangThai = 1 WHERE MaDK = ?";
	private static final String SELECT_MaDK = "SELECT MaDK FROM nckh.dangky WHERE MaDeTai = ?";
	private static final String SELECT_GV = "SELECT MaGV, TenGV FROM nckh.giangvien WHERE  MaGV = (SELECT MaGV FROM nckh.dangky MaDK = ?)";
	private static final String SELECT_NHOMSV = "SELECT sv.HoTen, sv.MSSV, sv.NienKhoa, kh.TenKhoa"
												+ "FROM nckh.sinhvien "
												+ "INNER JOIN nckh.dangky dk ON sv.MaNhom = dk.MaNhom"
												+ "INNER JOIN nckh.khoa kh ON sv.MaKhoa = kh.MaKhoa"
												+ "WHERE dk.MaDeTai = ?;";
										
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
	
	public boolean CapNhatTrangThaiDK(String MaDK) throws SQLException{
        boolean updated = false;
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TrangThai_DK);) {
        	statement.setString(1, MaDK);
        	//System.out.println(gv.getTenGV());
            int rowsAffected = statement.executeUpdate();
            updated = (rowsAffected > 0);
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        } 
        return updated;
    }
	
	public String layMaDK(String MaDeTai) throws SQLException{
		String MaDK = "";
        ResultSet rs = null;
        
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MaDK);)
        {
        	preparedStatement.setString(1, MaDeTai);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                MaDK = rs.getString("MaDK");     
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return MaDK;
	}
	
	public GIANGVIEN layGV(String MaDK) throws SQLException{
		GIANGVIEN gv = null;
        ResultSet rs = null;
        
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GV);)
        {
        	preparedStatement.setString(1, MaDK);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                String MaGV = rs.getString("MaGV");   
                String TenGV = rs.getString("TenGV");
                gv = new GIANGVIEN(MaGV, TenGV);
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return gv;
	}	
	
	
	public List<String> laySV(String MaDeTai) throws SQLException {
	    List<String> results = new ArrayList<>();

	    // Step 1: Establish a Connection
	    try (Connection connection = JDBC.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NHOMSV)) {
	        // Step 3: Execute the query and process the ResultSet
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	            String HoTen = rs.getString("HoTen");
	            String MSSV = rs.getString("MSSV");
	            String NienKhoa = rs.getString("NienKhoa");
	            String TenKhoa = rs.getString("TenKhoa");
	            

	            String result = String.format("HoTen: %s, MSSV: %s, NienKhoa: %s, TenKhoa: %s", HoTen, MSSV, NienKhoa, TenKhoa);
	            results.add(result);
	        }
	    } catch (SQLException exception) {
	        HandleException.printSQLException(exception);
	    }

	    return results;
	}
}
