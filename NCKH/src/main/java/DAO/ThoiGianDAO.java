package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.THOIGIAN;
import Util.HandleException;
import Util.JDBC;


public class ThoiGianDAO {
	private static final String SELECT_THOIGIAN_DK = "SELECT * FROM nckh.THOIGIAN WHERE LoaiTG = ?";
	private static final String SELECT_THOIGIAN_BC = "SELECT * FROM nckh.THOIGIAN WHERE LoaiTG = ?";
	
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
}
