package Controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DeTaiDAO;
import DAO.NVPQLKHDAO;
import Models.DETAI;

@WebServlet("/DangDeTai")
public class DangDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDAO dtdao;
	private NVPQLKHDAO nvdao;
	
    public DangDeTaiController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		dtdao = new DeTaiDAO();
		nvdao = new NVPQLKHDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        System.out.println(IDDangNhap);
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
	
		if (IDDangNhap != null) {
		    try {
		        request.setCharacterEncoding("UTF-8");

		        String MaDT = dtdao.GenerateMaDeTai();
		        String TenDeTai = request.getParameter("tendetai");
		        String MoTa = request.getParameter("mota");
		        System.out.println(MoTa);
		        boolean TrangThai = false;
		        String kinhPhiString = request.getParameter("kinhphi");
		        int kinhPhi = 0; // Giá trị mặc định hoặc giá trị khi không hợp lệ

		        if (kinhPhiString != null) {
		            try {
		                kinhPhi = Integer.parseInt(kinhPhiString);
		            } catch (NumberFormatException e) {
		                // Xử lý khi giá trị kinhPhiString không hợp lệ
		                e.printStackTrace();
		                // Gán giá trị mặc định hoặc giá trị khi không hợp lệ
		            }
		        }

		        String MaNV = nvdao.layThongTinNV(IDDangNhap).getMaNV();

		        DETAI detai = new DETAI(MaDT, TenDeTai, MoTa, TrangThai, kinhPhi, null, MaNV);

		        dtdao.DangDeTai(detai);

		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DangDeTaiNV.jsp");
		        dispatcher.forward(request, response);
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } catch (UnsupportedEncodingException e) {
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
