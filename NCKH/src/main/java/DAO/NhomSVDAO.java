package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.NHOMSINHVIEN;
import Models.SINHVIEN;
import Util.HandleException;
import Util.JDBC;

public class NhomSVDAO {
	private static final String INSERT_NHOMSINHVIEN_SQL = "INSERT INTO nckh.nhomsinhvien" +
	        "  (MaNhom, SoLuongSV) VALUES " + " (?, ?);";
	private static final String INSERT_SINHVIEN_SQL = "INSERT INTO nckh.sinhvien" +
	        "  (MSSV, HoTen, MaNhom, NienKhoa, MaKhoa) VALUES " + " (?, ?, ?, ?, ?);";
	
	public NhomSVDAO() {}
	
	public void insertNhom(NHOMSINHVIEN nhom) {
		try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NHOMSINHVIEN_SQL)) {
            preparedStatement.setString(1, nhom.getMaNhom());
            preparedStatement.setInt(2, nhom.getSoLuongSV());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	
	public void insertSinhVien(SINHVIEN sv) {
		try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SINHVIEN_SQL)) {
            preparedStatement.setString(1, sv.getmSSV());
            preparedStatement.setString(2, sv.getHoTen());
            preparedStatement.setString(3, sv.getMaNhom());
            preparedStatement.setString(4, sv.getNienKhoa());
            preparedStatement.setString(5, sv.getMaKhoa());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	
	public String GenerateMaNhom() {
	    String sql = "SELECT MAX(MaNhom) FROM nckh.nhomsinhvien";
	    String nextMaNhom = "N0001";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaNhom = rs.getString(1);
	        }
	        
	        if(nextMaNhom == null) {
	        	return "N0001";
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaNhom.substring(1)) + 1;
	    String numberStr = String.format("%04d", number);
	    return "N" + numberStr;
	}
}
