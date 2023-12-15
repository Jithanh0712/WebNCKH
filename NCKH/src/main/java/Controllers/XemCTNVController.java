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


@WebServlet("/XemCTNVController")
public class XemCTNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDAO dtDAO;  
    private DangKyDAO dkDAO;   
  
    public XemCTNVController() {
        super();
  
    }


	public void init() {
		dtDAO = new DeTaiDAO();
    	dkDAO = new DangKyDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		HttpSession session = request.getSession();
		String maDT = (String) session.getAttribute("MaDeTai");
		System.out.println(maDT);
		try {
			DETAI dt = dtDAO.laychitietdetai(maDT);
			List <String> listSV = dkDAO.laySV(maDT);
			String MaDK = dkDAO.layMaDK(maDT);
	        GIANGVIEN giangvien = dkDAO.layGV(MaDK);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/XemChiTietNV.jsp");
            request.setAttribute("detai", dt);
        	request.setAttribute("listSV", listSV);
        	request.setAttribute("giangvien", giangvien);
    		request.setAttribute("dangky", MaDK);
        	dispatcher.forward(request, response);
        	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
