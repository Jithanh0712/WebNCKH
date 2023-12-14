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


import DAO.GiangVienDAO;


@WebServlet("/detaicuatoi")
public class DeTaiCuaToiGVConTroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GiangVienDAO gvDAO;

    public DeTaiCuaToiGVConTroller() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		gvDAO = new GiangVienDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String IDDangNhap = (String) session.getAttribute("IDDangNhap");
		System.out.println( IDDangNhap);
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		 if (IDDangNhap != null) {
			 try {
				 String MaGV = gvDAO.layThongTinGV(IDDangNhap).getMaGV();
				 List <String> listDT = gvDAO.retrieveResults(MaGV);
				 request.setAttribute("listDT", listDT);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/DeTaiCuaToiGV.jsp");
				 dispatcher.forward(request, response);
				 
			 }  catch (SQLException e) {
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
