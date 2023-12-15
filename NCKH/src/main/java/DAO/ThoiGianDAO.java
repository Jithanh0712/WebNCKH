package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.GIANGVIEN;
import Models.THOIGIAN;
import Util.HandleException;
import Util.JDBC;


public class ThoiGianDAO {
	private static final String SELECT_THOIGIAN_DK = "SELECT * FROM nckh.THOIGIAN WHERE LoaiTG = ?";

	private static final String SELECT_THOIGIAN_BC = "SELECT * FROM nckh.THOIGIAN WHERE LoaiTG = ?";
	
	private static final String UPDATE_THOIGIAN_BC = "UPDATE nckh.THOIGIAN SET NgayBatDau = ?, NgayKetThuc = ? WHERE LoaiTG = ?";
	
	private static final String UPDATE_THOIGIAN_DK = "UPDATE nckh.THOIGIAN SET NgayBatDau = ?, NgayKetThuc = ? WHERE LoaiTG = ?";

	
	public ThoiGianDAO() {}

	public THOIGIAN layThoiGian() throws SQLException{
		THOIGIAN tg = null;
        ResultSet rs = null;
        
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THOIGIAN_DK);)
        {
        	preparedStatement.setString(1, "TGDK");
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                Date ngaybd = rs.getDate("NgayBatDau");
                Date ngaykt = rs.getDate("NgayKetThuc");
                tg = new THOIGIAN("TGDK", ngaybd, ngaykt);
               
            }
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return tg;
	}
	


	public THOIGIAN layThoiGianBaoCao() throws SQLException{
		THOIGIAN tg = null;
        ResultSet rs = null;
        
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THOIGIAN_BC);)
        {
        	preparedStatement.setString(1, "TGBC");
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
                Date ngaybd = rs.getDate("NgayBatDau");
                Date ngaykt = rs.getDate("NgayKetThuc");
                tg = new THOIGIAN("TGBC", ngaybd, ngaykt);
               
            }
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return tg;
	}

	public boolean capNhatThoiGianDK(THOIGIAN tg) throws SQLException{
        boolean updated = false;
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_THOIGIAN_DK);) {
        	statement.setDate(1, tg.getNgayBatDau());
        	
        	statement.setDate(2, tg.getNgayKetThuc());
        	statement.setString(3, "TGDK");
            int rowsAffected = statement.executeUpdate();
            updated = (rowsAffected > 0);
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        } 
        return updated;
    }
	
	public boolean capNhatThoiGianBC(THOIGIAN tg) throws SQLException{
        boolean updated = false;
        System.out.println(UPDATE_THOIGIAN_BC);
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_THOIGIAN_BC);) {
        	statement.setDate(1, tg.getNgayBatDau());
        	//System.out.println(gv.getTenGV());
        	statement.setDate(2, tg.getNgayKetThuc());
        	statement.setString(3, "TGBC");
            int rowsAffected = statement.executeUpdate();
            updated = (rowsAffected > 0);
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        } 
        return updated;
    }

}
