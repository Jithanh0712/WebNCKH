package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.NVPQLKHDAO;
import DAO.ThoiGianDAO;
import Models.DETAI;
import Models.THOIGIAN;

@WebServlet("/detaicuatoiNV")
public class DeTaiCuaToiNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NVPQLKHDAO nvDAO;

    private ThoiGianDAO tgDAO;
    
    public DeTaiCuaToiNVController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		nvDAO = new NVPQLKHDAO();
		tgDAO = new ThoiGianDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		if (IDDangNhap != null) {
		    request.setCharacterEncoding("UTF-8");
		    try {
		        String MaNV = nvDAO.layThongTinNV(IDDangNhap).getMaNV();
		        List<DETAI> listDTCN = nvDAO.selectAllDTCN(MaNV);
		        List<String> listTT = nvDAO.selectAllTrangThai(MaNV);
		        THOIGIAN thoigian = tgDAO.layThoiGianBaoCao();
				request.setAttribute("thoigian", thoigian);
		        request.setAttribute("listDTCN", listDTCN);
		        request.setAttribute("listTT", listTT);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DSDTCuaToi(NV).jsp");
		        dispatcher.forward(request, response);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		} else {
		    response.sendRedirect("/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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
