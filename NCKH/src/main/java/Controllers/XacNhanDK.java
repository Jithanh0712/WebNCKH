package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DangKyDAO;
import DAO.DeTaiDAO;
import Models.DETAI;
import Models.GIANGVIEN;





@WebServlet("/XacNhanDK")
public class XacNhanDK extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DeTaiDAO dtDAO;  
    private DangKyDAO dkDAO;
    
    public XacNhanDK() {
        super();

    }
    
    public void init() {
    	dtDAO = new DeTaiDAO();
    	dkDAO = new DangKyDAO();
	}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		try {
			if (action.equals("/loaddata"))
			{
				LayChiTietDT(request, response);
				listSV(request, response);
				LayGV(request, response);
			}
			if (action.equals("/updateDK"))
			{
				String MaDeTai = request.getParameter("MaDeTai");
				String MaDK = dkDAO.layMaDK(MaDeTai);
	            
	
	
	            boolean updated = dkDAO.CapNhatTrangThaiDK(MaDK);
	            if (updated) {
	            	RequestDispatcher dispatcher = request.getRequestDispatcher("/XacNhanDangKy.jsp");
	        		request.setAttribute("dangky", MaDK);
	        		dispatcher.forward(request, response);
	            }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void LayChiTietDT(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        String MaDeTai = request.getParameter("MaDeTai");
		        DETAI dt = dtDAO.laychitietdetai(MaDeTai);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/XacNhanDangKy.jsp");
		        request.setAttribute("detai", dt);
		        dispatcher.forward(request, response);

	}
	
	private void listSV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
				String MaDeTai = request.getParameter("MaDeTai");
		        List <String> listSV = dkDAO.laySV(MaDeTai);
		        
		        request.setAttribute("listSV", listSV);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/XacNhanDangKy.jsp");
		        dispatcher.forward(request, response);
    }
	
	private void LayGV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
				String MaDeTai = request.getParameter("MaDeTai");
				String MaDK = dkDAO.layMaDK(MaDeTai);
		        GIANGVIEN giangvien = dkDAO.layGV(MaDK);
		        
		        request.setAttribute("giangvien", giangvien);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/XacNhanDangKy.jsp");
		        dispatcher.forward(request, response);
    }
}
