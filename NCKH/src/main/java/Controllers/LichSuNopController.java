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

import DAO.BaoCaoDAO;
import Models.BAOCAO;


@WebServlet("/lichsunop")
public class LichSuNopController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BaoCaoDAO bcDAO;
	
    public LichSuNopController() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		bcDAO = new BaoCaoDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		try {
		String MaDT = (String) request.getParameter("baocao");
        List <BAOCAO> listBC = bcDAO.layThongTinBaoCao(MaDT);
        request.setAttribute("listBC", listBC);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/LichSuBaoCao.jsp");
        dispatcher.forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
