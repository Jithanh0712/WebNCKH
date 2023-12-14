package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DANGKY;
import Models.DETAI;
import Models.GIANGVIEN;
import Util.HandleException;
import Util.JDBC;

public class DangKyDAO {
	private static final String INSERT_DANGKY_SQL = "INSERT INTO nckh.dangky" +
	        "  (MaDK, MaDeTai, MaGV, MaNhom) VALUES " + " (?, ?, ?, ?);";
	private static final String UPDATE_TrangThai_DK = "UPDATE nckh.dangky SET TrangThai = ? WHERE MaDK = ?";
	private static final String UPDATE_NgayDKTC_DK = "UPDATE nckh.detai SET NgayDKTC = ? WHERE MaDeTai = ?";
	private static final String SELECT_MaDK = "SELECT MaDK FROM nckh.dangky WHERE MaDeTai = ?";
	private static final String SELECT_GV = "SELECT giangvien.MaGV, TenGV "
												+ "FROM nckh.giangvien "
												+ "INNER JOIN nckh.dangky "
												+ "ON nckh.giangvien.MaGV = nckh.dangky.MaGV "
												+ "WHERE nckh.dangky.MaDK = ?";
	private static final String SELECT_NHOMSV = "SELECT sinhvien.HoTen, sinhvien.MSSV, sinhvien.NienKhoa, khoa.TenKhoa "
												+ "FROM nckh.sinhvien "
												+ "INNER JOIN nckh.dangky ON sinhvien.MaNhom = dangky.MaNhom "
												+ "INNER JOIN nckh.khoa ON sinhvien.MaKhoa = khoa.MaKhoa "
												+ "WHERE dangky.MaDeTai = ?;";
	public DangKyDAO() {}
	
	public void insertDangKy(DANGKY dk) {
		try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DANGKY_SQL);) {
			preparedStatement.setString(1, dk.getMaDK());
			preparedStatement.setString(2, dk.getMaDeTai());
			preparedStatement.setString(3, dk.getMaGV());
			preparedStatement.setString(4, dk.getMaNhom());
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
	        
	        if(nextMaDK == null) {
	        	return "DK001";
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
	
	public boolean CapNhatTrangThaiDK(Boolean TrangThai, String MaDK) throws SQLException{
		boolean updated = false;
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TrangThai_DK);) {
        	statement.setBoolean(1, TrangThai);
        	statement.setString(2, MaDK);
        	System.out.println(statement);
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
        	System.out.println(preparedStatement);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                MaDK = rs.getString("MaDK");  
                System.out.println(MaDK);
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
        	System.out.println(preparedStatement);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                String MaGV = rs.getString("MaGV");   
                String TenGV = rs.getString("TenGV");
                gv = new GIANGVIEN(MaGV, TenGV);
                System.out.println(TenGV);
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
	    	preparedStatement.setString(1, MaDeTai);
	        ResultSet rs = preparedStatement.executeQuery();
	        System.out.println(preparedStatement);
	        while (rs.next()) {
	            String HoTen = rs.getString("sinhvien.HoTen");
	            String MSSV = rs.getString("sinhvien.MSSV");
	            String NienKhoa = rs.getString("sinhvien.NienKhoa");
	            String TenKhoa = rs.getString("khoa.TenKhoa");
	            

	            String result = String.format(" %s, %s, %s, %s", HoTen, MSSV, NienKhoa, TenKhoa);
	            results.add(result);
	        }
	    } catch (SQLException exception) {
	        HandleException.printSQLException(exception);
	    }

	    return results;
	}
	
	public boolean CapNhatNgayDKTC(Date NgayDKTC, String MaDeTai) throws SQLException{
		boolean updated = false;
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_NgayDKTC_DK);) {
        	statement.setDate(1, NgayDKTC);
        	statement.setString(2, MaDeTai);
        	System.out.println(statement);
        	int rowsAffected = statement.executeUpdate();
            updated = (rowsAffected > 0);
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        } 
        return updated;
    }
}
