package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.NVPQLKHDAO;
import DAO.ThoiGianDAO;
import DAO.ThongBaoNVDAO;
import Models.GIANGVIEN;
import Models.THOIGIAN;
import Models.THONGBAO;

@WebServlet("/thoigian/*")
public class ThoiGianController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ThoiGianDAO tgDAO;
	private NVPQLKHDAO nvDAO;
	private ThongBaoNVDAO tbnvDAO;
	
    public ThoiGianController() {
        super();
    }

    public void init()
    {
    	tgDAO = new ThoiGianDAO();
    	nvDAO = new NVPQLKHDAO();
    	tbnvDAO = new ThongBaoNVDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String IDDangNhap = (String) session.getAttribute("IDDangNhap");
		System.out.println(IDDangNhap);
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		if (IDDangNhap != null) {
		    request.setCharacterEncoding("UTF-8");
		    try {
		    	if (action.equals("/direct"))
				 {
		    		RequestDispatcher dispatcher = request.getRequestDispatcher("/DatDL.jsp");
					dispatcher.forward(request, response);
				 }
				if (action.equals("/update"))
				{
					update_TGBC(request, response);
				} 
			} catch (SQLException ex) {
	            throw new ServletException(ex);
			}
		} else {
		    response.sendRedirect("/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
		
	}

	private void update_TGBC(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		String IDDangNhap = (String) session.getAttribute("IDDangNhap");
		String ngaybdmoi = request.getParameter("ngaybdbc");
	    String ngayktmoi = request.getParameter("ngayktbc");

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    try {
	        // Chuyển đổi chuỗi ngày bắt đầu mới thành đối tượng java.util.Date
	        //java.util.Date utilDate_bd = sdf.parse(ngaybdmoi);
	        Date tgBDMoi = new java.sql.Date(sdf.parse(ngaybdmoi).getTime());

	        // Chuyển đổi chuỗi ngày kết thúc mới thành đối tượng java.util.Date
	        java.util.Date utilDate_kt = sdf.parse(ngayktmoi);
	        Date tgKTMoi = new java.sql.Date(sdf.parse(ngayktmoi).getTime());
	        
	        THOIGIAN thoigian = new THOIGIAN("TGDC", tgBDMoi, tgKTMoi);
	        String MaNV = nvDAO.layThongTinNV(IDDangNhap).getMaNV();
	        List <GIANGVIEN> listGV = nvDAO.selectAllGVs(MaNV);
	        
	        boolean updated = tgDAO.capNhatThoiGianBC(thoigian);

	        if (updated) {            
	            request.setAttribute("thoigian", thoigian);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/listDSDT_NV");
				dispatcher.forward(request, response);
	        }
	        
	        if (listGV != null) {
	        	
	            String TenThongBao = request.getParameter("TenThongBao");
	            String NoiDung = request.getParameter("NoiDung");
	            Date NgayGui = new Date(System.currentTimeMillis());
	            
	            for (GIANGVIEN NguoiNhan : listGV) {
	            	String MaGV = NguoiNhan.getMaGV();
	            	String MaThongBao = tbnvDAO.findNextMaTB();
	            	THONGBAO tb = new THONGBAO(MaThongBao, TenThongBao, NoiDung, NgayGui, MaGV, MaNV);

	                try {
	                    tbnvDAO.insertTB(tb);
	                } catch (SQLException e) {
	                    // Handle exception
	                }
	            }   
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
}
