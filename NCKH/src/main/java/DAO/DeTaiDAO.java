package DAO;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import Models.DETAI;
import Util.HandleException;
import Util.JDBC;



public class DeTaiDAO {
	private static final String SELECT_ALL_DETAI = "SELECT * FROM nckh.detai";
	private static final String SELECT_DETAI = "SELECT * FROM nckh.detai WHERE MaDeTai = ?";
	private static final String SELECT_TenDeTai = "SELECT TieuDe FROM nckh.detai WHERE MaNV = (SELECT MaNV FROM nckh.nvpqlkh WHERE ID = ?)";
	private static final String Set_TrangThaiDeTai = "SELECT d.MaDeTai,"
			+ "    COALESCE("
			+ "        CASE"
			+ "            WHEN d.TrangThai = '0' THEN '2'"
			+ "            WHEN dk.TrangThai = '0' THEN '0'"
			+ "            WHEN dk.TrangThai = '1' THEN '1'"
			+ "        END,"
			+ "        '2'"
			+ "    ) AS TrangThai"
			+ " FROM nckh.DETAI d LEFT JOIN nckh.DANGKY dk ON d.MaDeTai = dk.MaDeTai";
	public DeTaiDAO() {}
	
	public List<DETAI> selectAllDeTais() {
		// using try-with-resources to avoid closing resources (boiler plate code)
        List <DETAI> detais = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAI);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String MaDeTai1 = rs.getString("MaDeTai");
                String TieuDe1 = rs.getString("TieuDe");
                String MoTa1 = rs.getString("MoTa");
                boolean TrangThai1 = rs.getBoolean("TrangThai");
                int KinhPhi1 = rs.getInt("KinhPhi");
                Date NDKTC1 = rs.getDate("NgayDKTC");
                String MaNV1 = rs.getString("MaNV");
                detais.add(new DETAI(MaDeTai1, TieuDe1, MoTa1, TrangThai1, KinhPhi1, NDKTC1, MaNV1));
            }
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
        return detais;
	}
  
  public DETAI laychitietdetai(String MaDeTai) {
		DETAI detai = null;
		try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DETAI);) {
			preparedStatement.setString(1, MaDeTai);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                MaDeTai = rs.getString("MaDeTai");
                String TieuDe = rs.getString("TieuDe");
                String MoTa = rs.getString("MoTa");
                boolean TrangThai = rs.getBoolean("TrangThai");
                int KinhPhi = rs.getInt("KinhPhi");
                Date NDKTC = rs.getDate("NgayDKTC");
                String MaNV = rs.getString("MaNV");
                detai = new DETAI(MaDeTai, TieuDe, MoTa, TrangThai, KinhPhi, NDKTC, MaNV);
            }
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
		return detai;
	}
	
	public List<DETAI> selectAllTenDeTais() {
		// using try-with-resources to avoid closing resources (boiler plate code)
        List <DETAI> tendetais = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TenDeTai);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String MaDeTai = rs.getString("MaDeTai");
                String TieuDe = rs.getString("TieuDe");
                tendetais.add(new DETAI(MaDeTai, TieuDe));
            }
        } catch (SQLException exception) {
        	 HandleException.printSQLException(exception);
        }
        return tendetais;
  }
	public List<String> selectAllTrangThai() {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<String> trangthais = new ArrayList <> ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(Set_TrangThaiDeTai);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String trangthai = rs.getString("TrangThai");
                trangthais.add(trangthai);
            }
        } catch (SQLException exception) {
        	 HandleException.printSQLException(exception);
        }
        return trangthais;
  }
}
