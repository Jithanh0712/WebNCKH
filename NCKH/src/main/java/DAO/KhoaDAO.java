package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.KHOA;
import Util.HandleException;
import Util.JDBC;

public class KhoaDAO {
	private static final String SELECT_ALL_KHOA = "SELECT * FROM nckh.khoa";
	
	public KhoaDAO() {}
	
	public List<KHOA> LayThongTinCacKhoa(){
		List<KHOA> khoas = new ArrayList <> ();
		try (Connection connection = JDBC.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KHOA);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String MaKhoa = rs.getString(1);
                String TenKhoa = rs.getString(2);
                khoas.add(new KHOA(MaKhoa, TenKhoa));
            }
        } catch (SQLException exception) {
        	HandleException.printSQLException(exception);
        }
		return khoas;
	}
}
