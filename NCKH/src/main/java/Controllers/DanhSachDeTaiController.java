package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import Models.DETAI;
import Models.GIANGVIEN;
import Models.THOIGIAN;
import DAO.ThoiGianDAO;

@WebServlet("/")
public class DanhSachDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private DeTaiDAO detaiDAO;
    private ThoiGianDAO tgDAO;
    public DanhSachDeTaiController() {
        super();
    }
    
    public void init() {
		detaiDAO = new DeTaiDAO();
		tgDAO = new ThoiGianDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("action error :"+ action );
		
		try {
			if (action.equals("/listDSDT_GV"))
			{
				listDT_GV(request, response);
			} 
			if (action.equals("/listDSDT_NV"))
			{
				listDT_NV(request, response);
			} 
			if (action.equals("/listDSDT_Ad"))
			{
				listDT_Ad(request, response);
			} 
			if (action.equals("/updateTGDK"))
			{
				update_TGDK(request, response);
			} 
		} catch (SQLException ex) {
            throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void listDT_GV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	HttpSession session = request.getSession();
		        List <DETAI> listDT = detaiDAO.selectAllDeTais();
		        request.setAttribute("listDT", listDT);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachDeTaiGV.jsp");
		        dispatcher.forward(request, response);
    }
	
	private void listDT_NV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	HttpSession session = request.getSession();
		        List <DETAI> listDT = detaiDAO.selectAllDeTais();
		        THOIGIAN thoigian = tgDAO.layThoiGian();
				request.setAttribute("thoigian", thoigian);
		        request.setAttribute("listDT", listDT);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachDeTaiNV.jsp");
		        dispatcher.forward(request, response);
    }

	private void listDT_Ad(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	HttpSession session = request.getSession();
		        List <DETAI> listDT = detaiDAO.selectAllDeTais();
		        request.setAttribute("listDT", listDT);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachDeTaiAd.jsp");
		        dispatcher.forward(request, response);
    }
	
	private void update_TGDK(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
				/*DateTimeFormatter df_bd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate tgBDMoi = LocalDate.parse(request.getParameter("ngaybdmoi"),df_bd);
		        DateTimeFormatter df_kt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        DateFormat tgKTMoi = DateFormat.(request.getParameter("ngayktmoi"),df_kt);
		        */
				String ngaybdmoi = request.getParameter("ngaybdmoi");
				System.out.println(ngaybdmoi);
			    String ngayktmoi = request.getParameter("ngayktmoi");
		
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
			    try {
			        // Chuyển đổi chuỗi ngày bắt đầu mới thành đối tượng java.util.Date
			        java.util.Date utilDate_bd = sdf.parse(ngaybdmoi);
			        Date tgBDMoi = new Date(utilDate_bd.getTime());
		
			        // Chuyển đổi chuỗi ngày kết thúc mới thành đối tượng java.util.Date
			        java.util.Date utilDate_kt = sdf.parse(ngayktmoi);
			        Date tgKTMoi = new Date(utilDate_kt.getTime());
		
			        THOIGIAN thoigian = new THOIGIAN("TGDK", tgBDMoi, tgKTMoi);
		
			        boolean updated = tgDAO.capNhatThoiGianDK(thoigian);

			        
			        if (updated) {
			            RequestDispatcher dispatcher = request.getRequestDispatcher("/listDSDT_NV");
			            request.setAttribute("thoigian", thoigian);
			            dispatcher.forward(request, response);
			        }
			    } catch (ParseException e) {
			        e.printStackTrace();
			    }
	}
}
