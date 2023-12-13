package Controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.GiangVienDAO;
import Models.GIANGVIEN;

@WebServlet("/thongtingv/*")
public class ThongTinGVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GiangVienDAO gvDAO;
    
    public ThongTinGVController() {
        super();
    }
    
    public void init() {
		gvDAO = new GiangVienDAO();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
   
        if (IDDangNhap != null) {
        	request.setCharacterEncoding("UTF-8");
            try {
        	if (action.equals("/thongtin"))
        		{
        			GIANGVIEN gv = gvDAO.layThongTinGV(IDDangNhap);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/HoSoGV.jsp");
            		request.setAttribute("giangvien", gv);
            		//System.out.println(gv.getMaGV());
                    dispatcher.forward(request, response);
        		}
        		if (action.equals("/update"))
        		{
        			String maGV = request.getParameter("magv");
                    String tenGV = request.getParameter("tengv");

        			System.out.println(tenGV);
                    String trinhDo = request.getParameter("trinhdo");
                    String maKhoa = request.getParameter("makhoa"); 

                    GIANGVIEN gv = new GIANGVIEN(maGV, tenGV, trinhDo, IDDangNhap, maKhoa);

                    boolean updated = gvDAO.capNhatThongTinGV(gv);
                    if (updated) {
                    	RequestDispatcher dispatcher = request.getRequestDispatcher("/thongtingv/thongtin");
                		request.setAttribute("giangvien", gv);
                		dispatcher.forward(request, response);
                    }
        		}
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
