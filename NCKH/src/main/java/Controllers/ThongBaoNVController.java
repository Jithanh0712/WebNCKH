package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ThongBaoNVDAO;
import Models.GIANGVIEN;
import Models.THONGBAO;


@WebServlet("/ThongBaoNVController")
public class ThongBaoNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ThongBaoNVDAO tbnvDAO;   

    public ThongBaoNVController() {
        super();
        
    }

	
	public void init() {
		tbnvDAO = new ThongBaoNVDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        //System.out.println(IDDangNhap);
        if (IDDangNhap != null) {
            try {
                List<THONGBAO> listTB = tbnvDAO.selectThongBao(IDDangNhap);
                request.setAttribute("listTB", listTB);
                
                List<GIANGVIEN> listGV = tbnvDAO.selectAllTenGVs();
                request.setAttribute("listGV", listGV);
                
                
                try { 
                        insertTB(request, response);
                } catch (SQLException ex) {
                    throw new ServletException(ex);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBaoNV.jsp");
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
	
	private void listGV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
    	HttpSession session = request.getSession();
        List <GIANGVIEN> listGV = tbnvDAO.selectAllTenGVs();    
        request.setAttribute("listGV", listGV);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBaoNV.jsp");
        dispatcher.forward(request, response);
    }
	
	private void insertTB(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
    
		request.setCharacterEncoding("UTF-8");
        String[] selectedNguoiNhan = request.getParameterValues("nguoiNhan");

        if (selectedNguoiNhan != null && selectedNguoiNhan.length > 0) {
        	
            String TenThongBao = request.getParameter("TenThongBao");
            String NoiDung = request.getParameter("NoiDung");
            
            
            Date NgayGui = new Date(System.currentTimeMillis());
            
            
            HttpSession session = request.getSession();
            String IDDangNhap = (String) session.getAttribute("IDDangNhap");
            String NguoiGui = tbnvDAO.selectMaNV(IDDangNhap);
            
            for (String NguoiNhan : selectedNguoiNhan) {
            	String MaThongBao = tbnvDAO.findNextMaTB();
            	THONGBAO tb = new THONGBAO(MaThongBao, TenThongBao, NoiDung, NgayGui, NguoiNhan, NguoiGui);

                try {
                    tbnvDAO.insertTB(tb);
                } catch (SQLException e) {
                    // Handle exception
                }
            }   
        }
    }   	
}
