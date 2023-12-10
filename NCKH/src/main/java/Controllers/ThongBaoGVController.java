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

import DAO.ThongBaoGVDAO;
import Models.THONGBAO;


@WebServlet("/ThongBaoGVController")
public class ThongBaoGVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThongBaoGVDAO tbgvDAO;   

    public ThongBaoGVController() {
        super();

    }

    
    public void init() {
		tbgvDAO = new ThongBaoGVDAO();
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        if (IDDangNhap != null) {
            try {
                List<THONGBAO> listTB = tbgvDAO.selectAllThongBaos(IDDangNhap);

                request.setAttribute("listTB", listTB);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBaoGV.jsp");
                dispatcher.forward(request, response);
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
