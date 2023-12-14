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
import DAO.NVPQLKHDAO;
import Models.DEXUATDETAI;
import Models.NVPQLKH;


@WebServlet("/MaDeXuatTranfer")
public class MaDeXuatTranferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DeXuatDAO dxdao;
	public NVPQLKHDAO nvdao;
    public MaDeXuatTranferController() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		dxdao = new DeXuatDAO();
		nvdao = new NVPQLKHDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDX = (String) request.getParameter("madexuat");
		HttpSession session = request.getSession();
		session.setAttribute("MaDX", MaDX);
		System.out.println(MaDX);
		String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		if (IDDangNhap != null) {
        	request.setCharacterEncoding("UTF-8");
            try {
				NVPQLKH nv = nvdao.layThongTinNV(IDDangNhap);
				DEXUATDETAI dexuat = dxdao.chitietdexuat(MaDX);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/XacNhanDeXuatDeTai.jsp");
				session.setAttribute("nhanvien", nv);
				session.setAttribute("dexuat", dexuat);
				dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login.jsp");
        }
	}

}
