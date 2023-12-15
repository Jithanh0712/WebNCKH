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

import DAO.ThoiGianDAO;
import Models.THOIGIAN;


@WebServlet("/FromDL")
public class FromDL extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThoiGianDAO tgDAO;
	
    public FromDL() {
        super();

    }


	public void init()  {
		tgDAO = new ThoiGianDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			THOIGIAN tg = tgDAO.layThoiGianBaoCao();
			request.setAttribute("thoigian", tg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("FromNopDL.jsp");
			dispatcher.forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
