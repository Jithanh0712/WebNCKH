package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

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
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
   
        try { 
            if (action.equals("/insertTB")) {
                insertTB(request, response);
            } else if (action.equals("/ThongBaoNVController")) {
                listGV(request, response);
            } else {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBaoNV.jsp");
                dispatcher.forward(request, response);
            }     
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listGV(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
    	HttpSession session = request.getSession();
        List <GIANGVIEN> listGV = tbnvDAO.selectAllTenGVs();
        
        
        Gson gson = new Gson();
        String json = gson.toJson(listGV);
        response.getWriter().write(json);
        System.out.println(json);
        
        /*request.setAttribute("listGV", listGV);*/
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ThongBaoNV.jsp");
        dispatcher.forward(request, response);
    }
	
	private void insertTB(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {

        String MaThongBao = request.getParameter("MaThongBao");
        String TenThongBao = request.getParameter("TenThongBao");
        String NoiDung = request.getParameter("NoiDung");
        
        String NgayGuiStr = request.getParameter("NgayGui");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date NgayGui = (Date) sdf.parse(NgayGuiStr);
        
        String NguoiNhan = request.getParameter("NguoiNhan");
        String NguoiGui = request.getParameter("NguoiGui");
               
        THONGBAO tb = new THONGBAO(MaThongBao, TenThongBao, NoiDung, NgayGui, NguoiNhan, NguoiGui);
        tbnvDAO.insertTB(tb);
        
        response.sendRedirect("/ThongBaoNV.jsp");
    }
}