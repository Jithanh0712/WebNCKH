package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GiangVienDAO;
import DAO.NVPQLKHDAO;
import Models.NVPQLKH;

@WebServlet("/thongtinnv/*")
public class ThongTinNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NVPQLKHDAO nvDAO;
	
    public ThongTinNVController() {
        super();
    }

    public void init() {
		nvDAO = new NVPQLKHDAO();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		if (IDDangNhap != null) {
			try {
				if (action.equals("/thongtin"))
				{
					NVPQLKH nv = nvDAO.layThongTinNV(IDDangNhap);
		            RequestDispatcher dispatcher = request.getRequestDispatcher("/HoSoNV.jsp");
		    		request.setAttribute("nvpqlkh", nv);
		    		//System.out.println(gv.getMaGV());
		            dispatcher.forward(request, response);
				}
				if (action.equals("/update"))
				{
					String maNV = request.getParameter("manv");
		            String tenNV = request.getParameter("tennv");
		            int kinhNghiem = Integer.parseInt(request.getParameter("kinhnghiem"));
		            String email = request.getParameter("email");
		
		            NVPQLKH nv = new NVPQLKH(maNV, tenNV, kinhNghiem, email,IDDangNhap);
		
		            boolean updated = nvDAO.capNhatThongTinNV(nv);
		            if (updated) {
		            	RequestDispatcher dispatcher = request.getRequestDispatcher("/HoSoNV.jsp");
		        		request.setAttribute("nvpqlkh", nv);
		        		dispatcher.forward(request, response);
		            }
				}
		} catch (SQLException e) {
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
