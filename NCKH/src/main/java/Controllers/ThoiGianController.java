package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ThoiGianDAO;
import Models.THOIGIAN;

@WebServlet("/thoigian/*")
public class ThoiGianController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ThoiGianDAO tgDAO;
    public ThoiGianController() {
        super();
    }

    public void init()
    {
    	tgDAO = new ThoiGianDAO();
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
				/*DateTimeFormatter df_bd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate tgBDMoi = LocalDate.parse(request.getParameter("ngaybdmoi"),df_bd);
		        DateTimeFormatter df_kt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        DateFormat tgKTMoi = DateFormat.(request.getParameter("ngayktmoi"),df_kt);
		        */
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

	        boolean updated = tgDAO.capNhatThoiGianBC(thoigian);

	        if (updated) {            
	            request.setAttribute("thoigian", thoigian);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/listDSDT_NV");
				dispatcher.forward(request, response);
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
}
