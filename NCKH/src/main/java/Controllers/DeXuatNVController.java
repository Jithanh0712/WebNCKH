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

import DAO.DeXuatDAO;
import DAO.GiangVienDAO;
import Models.DEXUATDETAI;


@WebServlet("/dexuatnhanvien")
public class DeXuatNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeXuatDAO dexuatdao;
	private GiangVienDAO gvdao;
       
    public DeXuatNVController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		dexuatdao = new DeXuatDAO();
		gvdao = new GiangVienDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		if (IDDangNhap != null) {
        	request.setCharacterEncoding("UTF-8");
            try {
		        List <DEXUATDETAI> listDX = dexuatdao.Lay_DSDeXuat();
		        request.setAttribute("listDX", listDX);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/DeXuatNV.jsp");
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
