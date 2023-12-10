package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Models.GIANGVIEN;
import Util.HandleException;
import Util.JDBC;


public class GiangVienDAO {
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
