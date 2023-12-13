package DAO;

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
	
	public DETAI laychitietdetai(DETAI dt) {
		DETAI detai = null;
		try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DETAI);) {
			preparedStatement.setString(1, dt.getMaDeTai());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String MaDeTai = rs.getString("MaDeTai");
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
}
