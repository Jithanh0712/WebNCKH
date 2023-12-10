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

import DAO.GiangVienDAO;
import DAO.NVPQLKHDAO;
import DAO.TaiKhoanDAO;
import Models.GIANGVIEN;
import Models.NVPQLKH;
import Models.TAIKHOAN;


@WebServlet("/TaiKhoan/*")
public class TaiKhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TaiKhoanDAO taikhoanDAO; 
    private GiangVienDAO gvDAO;
    private NVPQLKHDAO nvDAO;
    
    public TaiKhoanController() {
        super();
    }

	
	public void init() {
		taikhoanDAO = new TaiKhoanDAO();
		gvDAO = new GiangVienDAO();
		nvDAO = new NVPQLKHDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
   
        try {
        	if (action.equals("/new"))
        	{
        		showNewForm(request, response);
        	}
        	else if (action.equals("/insert"))
        	{
        		insertTK(request, response);
        	}
        	else if (action.equals("/list"))
        	{
        		listTK(request, response);
        	}
        	else
        	{
        		RequestDispatcher dispatcher = request.getRequestDispatcher("/TrangChuAdmin.jsp");
                dispatcher.forward(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/FormThemTK.jsp");
        dispatcher.forward(request, response);
    }

    private void insertTK(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String IDDangNhap = request.getParameter("IDDangNhap");
        String MatKhau = request.getParameter("MatKhau");
        String ROLE_User = request.getParameter("ROLE_User");
               
        TAIKHOAN tk = new TAIKHOAN(IDDangNhap, MatKhau, ROLE_User);
        taikhoanDAO.insertTK(tk);
        if(ROLE_User.equals("GV"))
        {	
        	String MaGV = gvDAO.findNextMaGV();
        	String TenGV = " ";
        	String TrinhDo = " ";
        	String ID = IDDangNhap;
        	String MaKhoa = request.getParameter("MaKhoa");
        	GIANGVIEN gv = new GIANGVIEN(MaGV, TenGV, TrinhDo, ID, MaKhoa);
        	gvDAO.insertGV(gv);
        }
        else if(ROLE_User.equals("NV"))
        {
        	String MaNV = nvDAO.findNextMaNV();
        	String TenNV = " ";
        	int KinhNghiem = 0;
        	String Email = " ";
        	String ID = IDDangNhap;
        	NVPQLKH nv = new NVPQLKH(MaNV, TenNV, KinhNghiem, Email, ID);
        	nvDAO.insertNVPQLKH(nv);
        }
        response.sendRedirect("list");
    }
}
