package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.THONGBAO;
import Models.BAOCAO;
import Util.HandleException;
import Util.JDBC;

public class BaoCaoDAO {
	private static final String SELECT_ALL_THONGBAO_DESC = "SELECT * FROM nckh.thongbao where nguoinhan = ? ORDER BY MaThongBao DESC;";
	private static final String INSERT_BAOCAO = "INSERT INTO baocao VALUES (?, ?, ?, ?, ?)";
	
	public BaoCaoDAO() {}
	
	public List<THONGBAO> laycacthongbao(String MaGV){
		List<THONGBAO> thongbaos = new ArrayList<>();
		
		try (Connection connection = JDBC.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THONGBAO_DESC)) {
		        // Step 3: Execute the query and process the ResultSet
		    	preparedStatement.setString(1, MaGV);
		        ResultSet rs = preparedStatement.executeQuery();
		        System.out.println(preparedStatement);
		        while (rs.next()) {
		            String MaTB = rs.getString("MaThongBao");
		            String TenThongBao = rs.getString("TenThongBao");
		            String NoiDung = rs.getString("NoiDung");
		            Date NgayGui = rs.getDate("NgayGui");
		            String NguoiNhan = rs.getString("NguoiNhan");
		            String NguoiGui = rs.getString("NguoiGui");
		            thongbaos.add(new THONGBAO(MaTB, TenThongBao, NoiDung, NgayGui, NguoiNhan, NguoiGui));
		        }
		    } catch (SQLException exception) {
		        HandleException.printSQLException(exception);
		    }
		
		return thongbaos;
	}
	
	public void insertbaocao(BAOCAO bc) {
		try (Connection connection = JDBC.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BAOCAO)) {
		        // Step 3: Execute the query and process the ResultSet
		    	preparedStatement.setString(1, bc.getMaBaoCao());
		    	preparedStatement.setString(2, bc.getMaDeTai());
		    	preparedStatement.setDate(3, bc.getNgayNop());
		    	preparedStatement.setString(4, bc.getLoaiBaoCao());
		    	preparedStatement.setString(5, bc.getFileURL());
		        preparedStatement.executeUpdate();
		        System.out.println(preparedStatement);
		    } catch (SQLException exception) {
		        HandleException.printSQLException(exception);
		    }
	}
	
	public String GenerateMaBaoCao() {
	    String sql = "SELECT MAX(MaBaoCao) FROM nckh.baocao";
	    String nextMaBC = "BC001";

	    try {
	    	Connection connection = JDBC.getConnection();
	        PreparedStatement pstmt = connection.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            nextMaBC = rs.getString(1);
	        }
	        
	        if(nextMaBC==null) {
	        	return "BC001";
	        }
	        
	        rs.close();
	        pstmt.close();

	    } catch (SQLException e) {
	        System.out.println("Error: " + e);
	    }

	    int number = Integer.parseInt(nextMaBC.substring(2)) + 1;
	    String numberStr = String.format("%03d", number);
	    return "BC" + numberStr;
	}
}
