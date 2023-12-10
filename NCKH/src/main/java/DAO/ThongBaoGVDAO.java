package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.THONGBAO;
import Util.HandleException;
import Util.JDBC;

public class ThongBaoGVDAO {
    private static final String SELECT_ALL_THONGBAO = "SELECT MaThongBao, TenThongBao, NoiDung, NgayGui FROM nckh.thongbao " +
            											"WHERE NguoiNhan = (SELECT MaGV FROM nckh.giangvien WHERE ID = ?) ";;
    
    public ThongBaoGVDAO () {}
    
    public List<THONGBAO> selectAllThongBaos(String IDDangNhap) throws SQLException {
        List<THONGBAO> thongbaos = new ArrayList<>();

        // Establish a connection
        try (Connection connection = JDBC.getConnection();

                // Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THONGBAO)) {

            preparedStatement.setString(1, IDDangNhap);

            // Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Process the ResultSet object.
            while (rs.next()) {
            	String MaThongBao = rs.getString("MaThongBao");
                String TenThongBao = rs.getString("TenThongBao");
                String NoiDung = rs.getString("NoiDung");
                Date ThoiGian = rs.getDate("NgayGui");
                thongbaos.add(new THONGBAO(MaThongBao, TenThongBao, NoiDung, ThoiGian));
            }
        } catch (SQLException exception) {
            HandleException.printSQLException(exception);
        }
        return thongbaos;
    }
}
