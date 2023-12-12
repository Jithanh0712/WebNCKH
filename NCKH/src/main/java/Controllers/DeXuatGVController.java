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

import DAO.DeXuatDAO;
import DAO.GiangVienDAO;
import Models.DEXUATDETAI;

@WebServlet("/dexuat")
public class DeXuatGVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeXuatDAO dexuatdao;
	private GiangVienDAO gvdao;
	private DEXUATDETAI dxdt;

    public DeXuatGVController() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		dexuatdao = new DeXuatDAO();
		gvdao = new GiangVienDAO();
		dxdt = new DEXUATDETAI();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		if(IDDangNhap != null) {
			try {
				String MaDX = dexuatdao.GenerateMaDeXuat();
				String TenDeTai = request.getParameter("tendetai");
				String MoTa = request.getParameter("mota");
				String MaGV = gvdao.layThongTinGV(IDDangNhap).getMaGV();
				String MaDeTai = null;
				
				dxdt.setMaDeXuat(MaDX);
				dxdt.setTieuDeDeTai(TenDeTai);
				dxdt.setMoTaDeTai(MoTa);
				dxdt.setMaGV(MaGV);
				dxdt.setMaDeTai(MaDeTai);
				
				dexuatdao.dexuat(dxdt);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/DeXuatGV.jsp");
        		//dispatcher.forward(request, response);
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			response.sendRedirect("/login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
