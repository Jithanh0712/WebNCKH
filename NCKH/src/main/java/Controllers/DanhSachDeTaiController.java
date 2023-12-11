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


@WebServlet("/")
public class DanhSachDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private DeTaiDAO detaiDAO;
    
    public DanhSachDeTaiController() {
        super();
    }
    
    public void init() {
		detaiDAO = new DeTaiDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("action error :"+ action );
		
		try {
			if (action.equals("/listDSDT"))
			{
				listDT(request, response);
			} 
		} catch (SQLException ex) {
            throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void listDT(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	HttpSession session = request.getSession();
		        List <DETAI> listDT = detaiDAO.selectAllDeTais();
		        request.setAttribute("listDT", listDT);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachDeTaiGV.jsp");
		        dispatcher.forward(request, response);
    }

}
