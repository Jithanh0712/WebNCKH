package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DangKyDAO;
import DAO.DeTaiDAO;
import DAO.GiangVienDAO;
import Models.DETAI;
import Models.GIANGVIEN;


@WebServlet("/MDTTranferXNDKController")
public class MDTTranferXNDKController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDAO dtDAO;
	private DangKyDAO dkDAO; 
    
    public MDTTranferXNDKController() {
        super();
        
    }

	
	public void init()  {
		dtDAO = new DeTaiDAO();
		dkDAO = new DangKyDAO();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDeTai = request.getParameter("madetai");
		HttpSession session = request.getSession();
		session.setAttribute("MaDeTai", MaDeTai);
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		if (IDDangNhap != null) {
        	request.setCharacterEncoding("UTF-8");
            try {

				DETAI dt = dtDAO.laychitietdetai(MaDeTai);
				System.out.println(dt);
				String MaDK = dkDAO.layMaDK(MaDeTai);
				System.out.println(MaDK);
				GIANGVIEN gv = dkDAO.layGV(MaDK);
				System.out.println(gv.getMaGV());
				List<String> listsv = dkDAO.laySV(MaDeTai);
				System.out.println(listsv);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/XacNhanDK");
				request.setAttribute("MaDK", MaDK);
				request.setAttribute("detai", dt);
				request.setAttribute("gv", gv);
				request.setAttribute("listsv", listsv);
				dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login.jsp");
        }
	}

}
