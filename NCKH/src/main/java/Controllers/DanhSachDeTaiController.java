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

import DAO.DeTaiDAO;
import Models.DETAI;
import Models.THOIGIAN;
import DAO.ThoiGianDAO;

@WebServlet("/")
public class DanhSachDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private DeTaiDAO detaiDAO;
    private ThoiGianDAO tgDAO;
    public DanhSachDeTaiController() {
        super();
    }
    
    public void init() {
		detaiDAO = new DeTaiDAO();
		tgDAO = new ThoiGianDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("action error :"+ action );
		
		try {
			if (action.equals("/listDSDT_GV"))
			{
				listDT_GV(request, response);
			} 
			if (action.equals("/listDSDT_NV"))
			{
				listDT_NV(request, response);
			} 
			if (action.equals("/listDSDT_Ad"))
			{
				listDT_Ad(request, response);
			} 
		} catch (SQLException ex) {
            throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void listDT_GV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	HttpSession session = request.getSession();
		        List <DETAI> listDT = detaiDAO.selectAllDeTais();
		        request.setAttribute("listDT", listDT);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachDeTaiGV.jsp");
		        dispatcher.forward(request, response);
    }
	
	private void listDT_NV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	HttpSession session = request.getSession();
		        List <DETAI> listDT = detaiDAO.selectAllDeTais();
		        THOIGIAN thoigian = tgDAO.layThoiGian();
				request.setAttribute("thoigian", thoigian);
		        request.setAttribute("listDT", listDT);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachDeTaiNV.jsp");
		        dispatcher.forward(request, response);
    }

	private void listDT_Ad(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	HttpSession session = request.getSession();
		        List <DETAI> listDT = detaiDAO.selectAllDeTais();
		        request.setAttribute("listDT", listDT);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachDeTaiAd.jsp");
		        dispatcher.forward(request, response);
    }
}
