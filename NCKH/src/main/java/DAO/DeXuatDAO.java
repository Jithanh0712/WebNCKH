package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DETAI;
import Models.DEXUATDETAI;
import Util.HandleException;
import Util.JDBC;

public class DeXuatDAO {
	private static final String INSERT_DEXUATDETAI_SQL = "INSERT INTO nckh.dexuatdetai" +
	        "  (MaDeXuat, TieuDeDeTai, MoTaDeTai, MaGV, MaDeTai) VALUES " + " (?, ?, ?, ?, ?);";
	private static final String SELECT_ALL_DEXUAT = "SELECT * FROM nckh.dexuatdetai";
	
	public DeXuatDAO() {}
	
	public void dexuat(DEXUATDETAI dxdt) throws SQLException{
		System.out.println(INSERT_DEXUATDETAI_SQL);
		
		try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DEXUATDETAI_SQL)) {
            preparedStatement.setString(1, dxdt.getMaDeXuat());
            preparedStatement.setString(2, dxdt.getTieuDeDeTai());
            preparedStatement.setString(3, dxdt.getMoTaDeTai());
            preparedStatement.setString(4, dxdt.getMaGV());
            preparedStatement.setString(5, dxdt.getMaDeTai());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	
	public String GenerateMaDeXuat() {
	    String sql = "SELECT MAX(MaDeXuat) FROM nckh.dexuatdetai";
	    String nextMaDX = "DX001";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaDX = rs.getString(1);
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaDX.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "DX" + numberStr;
	}
	
	public List<DEXUATDETAI> Lay_DSDeXuat() throws SQLException{
		List <DEXUATDETAI> detais = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEXUAT);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String MaDeXuat1 = rs.getString("MaDeXuat");
                String TieuDeDeTai1 = rs.getString("TieuDeDeTai");
                String MoTaDeTai1 = rs.getString("MoTaDeTai");
                String MaGV1 = rs.getString("MaGV");
                boolean TrangThai1 = rs.getBoolean("TrangThai");
                String MaDeTai1 = rs.getString("MaDeTai");
                
                detais.add(new DEXUATDETAI(MaDeXuat1, TieuDeDeTai1, MoTaDeTai1, MaGV1, TrangThai1,MaDeTai1));
            }
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
        return detais;
	}
}
