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

}
