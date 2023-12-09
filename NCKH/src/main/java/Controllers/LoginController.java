package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import Models.TAIKHOAN;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;
	
    public LoginController() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		loginDAO = new LoginDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1: Lấy data từ form người dùng
		String IDDangNhap = request.getParameter("IDDangNhap");
        String MatKhau = request.getParameter("MatKhau");
        
        //Step 2: Khởi tạo model
        TAIKHOAN tk = new TAIKHOAN();
        tk.setIDDangNhap(IDDangNhap);
        tk.setMatKhau(MatKhau);
        //Step 3: Kết nối CSDL -> trả về kết quả
        try {
        	TAIKHOAN acc = new TAIKHOAN();
			//User users = new User();
			acc = loginDAO.onLogin(tk);
			if (acc != null) {
				String userRole = acc.getROLE_User();
				if("Admin".equals(userRole))
				{
					HttpSession session = request.getSession();
					//session.setAttribute("user", users);
					response.sendRedirect("TrangChuAdmin.jsp");
				}else if("NV".equals(userRole)){
					HttpSession session = request.getSession();
					//session.setAttribute("user", users);
					response.sendRedirect("TrangChuUser.jsp");
				}else if("GV".equals(userRole)){
					HttpSession session = request.getSession();
					//session.setAttribute("user", users);
					response.sendRedirect("TrangChuUser.jsp");
				}else {
					request.setAttribute("errMsg", "Bạn không có quyền truy cập!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
					dispatcher.forward(request, response);
				}
			} else {
	            request.setAttribute("errMsg", "Thông tin đăng nhập không chính xác!");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	            dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
