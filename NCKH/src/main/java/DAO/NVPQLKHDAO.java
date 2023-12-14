package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.DETAI;
import Models.GIANGVIEN;
import Models.NVPQLKH;
import Util.HandleException;
import Util.JDBC;

public class NVPQLKHDAO {
	private static final String INSERT_NVPQLKH_SQL = "INSERT INTO nckh.nvpqlkh" +
	        "  (MaNV, TenNV, KinhNghiem, Email, ID) VALUES " + " (?, ?, ?, ?, ?);";
	
	private static final String SELECT_NHANVIEN_BYID = "SELECT * FROM NVPQLKH WHERE ID = ?";
	private static final String UPDATE_NV = "UPDATE NVPQLKH SET TenNV = ?, KinhNghiem = ?, Email = ? WHERE ID = ?";
	private static final String SELECT_ALL_DETAICANHAN = "SELECT * FROM nckh.DETAI WHERE MaNV = ?";
	private static final String SELECT_ALL_TrangThai = "SELECT DISTINCT d.MaDeTai,\r\n"
			+ "  COALESCE("
			+ "    CASE"
			+ "      WHEN d.TrangThai = '0' THEN '2'"
			+ "      WHEN dk.TrangThai = '0' THEN '0'"
			+ "      WHEN dk.TrangThai = '1' THEN '1'"
			+ "    END,"
			+ "    '2'"
			+ "  ) AS TrangThai"
			+ " FROM nckh.DETAI d"
			+ " LEFT JOIN nckh.DANGKY dk ON d.MaDeTai = dk.MaDeTai"
			+ " where d.manv = ?";
	
	public NVPQLKHDAO() {}
	public void insertNVPQLKH(NVPQLKH nv) throws SQLException {
		System.out.println(INSERT_NVPQLKH_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = JDBC.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NVPQLKH_SQL)) {
            preparedStatement.setString(1, nv.getMaNV());
            preparedStatement.setString(2, nv.getTenNV());
            preparedStatement.setInt(3, nv.getKinhNghiem());
            preparedStatement.setString(4, nv.getEmail());
            preparedStatement.setString(5, nv.getiD());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
	}
	public String findNextMaNV() {
	    String sql = "SELECT MAX(MaNV) FROM nckh.nvpqlkh";
	    String nextMaNV = "NV000";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaNV = rs.getString(1);
	        }

	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaNV.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "NV" + numberStr;
	}
	public NVPQLKH layThongTinNV(String ID) {
		NVPQLKH nv = null;
        ResultSet rs = null;
        
        try {
        	Connection connection = JDBC.getConnection(); 
        	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NHANVIEN_BYID );
        	preparedStatement.setString(1, ID);
        	rs = preparedStatement.executeQuery();
        	while (rs.next()) {
        		 String MaNV = rs.getString("MaNV");
                String tenNV = rs.getString("TenNV");
                int kn = rs.getInt("KinhNghiem");
                String email = rs.getString("Email");
                nv = new NVPQLKH(MaNV, tenNV, kn, email, ID);
            }
            
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return nv;
	}
	public boolean capNhatThongTinNV(NVPQLKH nv) throws SQLException{
		
        boolean updated = false;
        try (Connection connection = JDBC.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_NV);) {
        	statement.setString(1, nv.getTenNV());
        	//System.out.println(gv.getTenGV());
        	statement.setInt(2, nv.getKinhNghiem());
        	statement.setString(3, nv.getEmail());
        	statement.setString(4, nv.getiD());
            int rowsAffected = statement.executeUpdate();
            updated = (rowsAffected > 0);
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return updated;
    }
	
	public List<DETAI> selectAllDTCN(String MaNV) {
		// using try-with-resources to avoid closing resources (boiler plate code)
        List <DETAI> tendetais = new ArrayList < > ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAICANHAN);) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, MaNV);
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
	
	public List<String> selectAllTrangThai(String MaNV) {
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<String> trangthais = new ArrayList <> ();

        // Step 1: Establishing a Connection
        try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TrangThai);) {
        	preparedStatement.setString(1, MaNV);
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
