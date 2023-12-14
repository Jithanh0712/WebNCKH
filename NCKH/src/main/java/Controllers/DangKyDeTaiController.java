package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DangKyDAO;
import DAO.DeTaiDAO;
import DAO.KhoaDAO;
import DAO.NhomSVDAO;
import DAO.GiangVienDAO;

import Models.DANGKY;
import Models.DETAI;
import Models.KHOA;
import Models.NHOMSINHVIEN;
import Models.SINHVIEN;
import Models.GIANGVIEN;

@WebServlet("/dangky")
public class DangKyDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DangKyDAO dkdao;
	private DeTaiDAO dtdao;
	private NhomSVDAO nhomdao;
	private KhoaDAO khoadao;
	private GiangVienDAO gvdao;

    public DangKyDeTaiController() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		dkdao = new DangKyDAO();
		dtdao = new DeTaiDAO();
		nhomdao = new NhomSVDAO();
		khoadao = new KhoaDAO();
		gvdao = new GiangVienDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
        String IDDangNhap = (String) session.getAttribute("IDDangNhap");
        String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		
		if (IDDangNhap != null) {
        	request.setCharacterEncoding("UTF-8");
            try {
            	String maDT = (String) request.getAttribute("MaDT");
            	String maNhom = nhomdao.GenerateMaNhom();
            	String maDK = dkdao.GenerateMaDK();
            	List<SINHVIEN> svlist = new ArrayList <> ();
            	for(var i = 0; i < 5; i++) {
            		String mssv = (String) request.getAttribute("MaSV" + i);
            		if(!mssv.isEmpty()) {
            			String ten = (String) request.getAttribute("SV" + i);
            			String nienkhoa = (String) request.getAttribute("NKSV" + i);
            			String khoa = (String) request.getAttribute("KhoaSV" + i);
            			svlist.add(new SINHVIEN(mssv, ten, maNhom, nienkhoa, khoa));
            		}
            	}
            	int soluongtv = svlist.size();
            	NHOMSINHVIEN nhom = new NHOMSINHVIEN(maNhom, soluongtv);
            	nhomdao.insertNhom(nhom);
            	for(var i = 0; i < soluongtv; i++) {
            		nhomdao.insertSinhVien(svlist.get(i));
            	}
            	
            	List<KHOA> khoas = khoadao.LayThongTinCacKhoa();
				GIANGVIEN gv = gvdao.layThongTinGV(IDDangNhap);
				DETAI dt = dtdao.laychitietdetai(maDT);
				
				DANGKY dk = new DANGKY(maDK, maDT, gv.getMaGV(), maNhom);
				dkdao.insertDangKy(dk);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/DangKy.jsp");
				request.setAttribute("giangvien", gv);
				request.setAttribute("detai", dt);
				request.setAttribute("khoas", khoas);
				dispatcher.forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login.jsp");
        }
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String MaDT = request.getParameter("madetai");
		request.setAttribute("MaDT", MaDT);
		doGet(request, response);
	}

}
