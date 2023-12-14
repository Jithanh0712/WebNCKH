package Controllers;

import java.io.IOException;
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
import DAO.DeXuatDAO;
import Models.NVPQLKH;
import Models.DETAI;
import Models.DEXUATDETAI;

@WebServlet("/XacNhanDeXuat")
public class XacNhanDeXuatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDAO dtdao;
	private DeXuatDAO dxdao;

    public XacNhanDeXuatController() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		dtdao = new DeTaiDAO();
		dxdao = new DeXuatDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		NVPQLKH nv = (NVPQLKH) session.getAttribute("nhanvien");
		DEXUATDETAI dx = (DEXUATDETAI) session.getAttribute("dexuat");
		try {
			String MaDT = dtdao.GenerateMaDeTai();
			int KinhPhi = Integer.parseInt(request.getParameter("kinhphi"));
			boolean trangThai = false;
			DETAI dt = new DETAI(MaDT, dx.getTieuDeDeTai(), dx.getMoTaDeTai(), trangThai, KinhPhi, nv.getMaNV());
			dtdao.DangDeTai(dt);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/DeXuatNV.jsp");
			dispatcher.forward(request, response);
			dxdao.setTrangThai(dx.getMaDeXuat());
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
