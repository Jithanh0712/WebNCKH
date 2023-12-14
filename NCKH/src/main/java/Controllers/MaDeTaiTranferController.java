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

import DAO.DeTaiDAO;
import DAO.GiangVienDAO;
import DAO.KhoaDAO;
import Models.DETAI;
import Models.GIANGVIEN;
import Models.KHOA;

/**
 * Servlet implementation class MaDeTaiTranferController
 */
@WebServlet("/tranfer/*")
public class MaDeTaiTranferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeTaiDAO dtdao;
	private GiangVienDAO gvdao;
	private KhoaDAO khoadao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaDeTaiTranferController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		dtdao = new DeTaiDAO();
		khoadao = new KhoaDAO();
		gvdao = new GiangVienDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDT = request.getParameter("madetai");
		HttpSession session = request.getSession();
		session.setAttribute("MaDT", MaDT);
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
        //System.out.println("action error :"+ action );
		
		if (IDDangNhap != null) {
        	request.setCharacterEncoding("UTF-8");
            try {
            	List<KHOA> khoas = khoadao.LayThongTinCacKhoa();
				GIANGVIEN gv = gvdao.layThongTinGV(IDDangNhap);
				DETAI dt = dtdao.laychitietdetai(MaDT);				
				request.setAttribute("giangvien", gv);
				request.setAttribute("detai", dt);
				request.setAttribute("khoas", khoas);
				if (action != null && action.equals("/dangkydt")) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/DangKy.jsp");
					dispatcher.forward(request, response);
				}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login.jsp");
        }
	}

}
