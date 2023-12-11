package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.GIANGVIEN;
import Models.THONGBAO;
import Util.HandleException;
import Util.JDBC;

public class ThongBaoNVDAO {
	
	private static final String SELECT_ALL_TenGV = "SELECT MaGV, TenGV FROM nckh.giangvien";;
	private static final String INSERT_THONGBAO_SQL = "INSERT INTO nckh.thongbao" +
	        "  (MaThongBao, TenThongBao, NoiDung, NgayGui, NguoiNhan, NguoiGui) VALUES " + " (?, ?, ?, ?, ?, ?);";
	
	public ThongBaoNVDAO () {}
	
	public static void main(String[] args) {
		List<GIANGVIEN> tenGVs = new ArrayList<>();
		
		// Establish a connection
		try (Connection connection = JDBC.getConnection();
		

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TenGV)) {
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
			String MaGV = rs.getString("MaGV");
			String TenGV = rs.getString("TenGV");
			tenGVs.add(new GIANGVIEN(MaGV, TenGV));
			System.out.println(TenGV);
			}
		} catch (SQLException exception) {
			HandleException.printSQLException(exception);
		}
	}	
	
	public List<GIANGVIEN> selectAllTenGVs() throws SQLException {
		List<GIANGVIEN> tenGVs = new ArrayList<>();
		
		// Establish a connection
		try (Connection connection = JDBC.getConnection();
		

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TenGV)) {
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
			String MaGV = rs.getString("MaGV");
			String TenGV = rs.getString("TenGV");
			tenGVs.add(new GIANGVIEN(MaGV, TenGV));
			System.out.println(TenGV);
			}
		} catch (SQLException exception) {
			HandleException.printSQLException(exception);
		}
		return tenGVs;
	}
	
	public String findNextMaTB() {
	    String sql = "SELECT MAX(MaTB) FROM nckh.thongbao";
	    String nextMaTB = "TB000";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaTB = rs.getString(1);
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaTB.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "TB" + numberStr;
	}
	
	public void insertTB(THONGBAO tb) throws SQLException {
		System.out.println(INSERT_THONGBAO_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THONGBAO_SQL)) {
            preparedStatement.setString(1, tb.getMaThongBao());
            preparedStatement.setString(2, tb.getTenThongBao());
            preparedStatement.setString(3, tb.getNoiDung());
            preparedStatement.setDate(4, tb.getNgayGui());
            preparedStatement.setString(5, tb.getNguoiNhan());
            preparedStatement.setString(6, tb.getNguoiGui());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
}
