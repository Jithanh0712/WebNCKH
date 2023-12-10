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

import DAO.TaiKhoanDAO;
import Models.TAIKHOAN;


@WebServlet("/")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaiKhoanDAO taikhoanDAO; 

    public TaiKhoanController() {
        super();
    }

	
	public void init() {
		taikhoanDAO = new TaiKhoanDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("action error :"+ action );
   
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertTK(request, response);
                    break;
                case "/list":
                    listTK(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/TrangChuAdmin.jsp");
                    dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listTK(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		    	HttpSession session = request.getSession();
		        List <TAIKHOAN> listTK = taikhoanDAO.selectAllTaiKhoans();
		        
		        request.setAttribute("listTK", listTK);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/ThemTaiKhoan.jsp");
		        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tk-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertTK(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String IDDangNhap = request.getParameter("IDDangNhap");
        String MatKhau = request.getParameter("MatKhau");
        String ROLE_User = request.getParameter("ROLE_User");

        
        TAIKHOAN tk = new TAIKHOAN(IDDangNhap, MatKhau, ROLE_User);
        taikhoanDAO.insertTK(tk);
        response.sendRedirect("list");
    }
}
