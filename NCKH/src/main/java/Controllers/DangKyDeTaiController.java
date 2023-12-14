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
            	String maDT = (String) session.getAttribute("MaDT");
            	String maNhom = nhomdao.GenerateMaNhom();
            	String maDK = dkdao.GenerateMaDK();
            	List<SINHVIEN> svlist = new ArrayList <> ();
            	int soluongtv = 0;
            	for(var i = 1; i < 5; i++) {
            		String mssv = (String) request.getParameter("MaSV" + i);
            		if(mssv != "" && mssv != null) {
            			String ten = (String) request.getParameter("SV" + i);
            			String nienkhoa = (String) request.getParameter("NKSV" + i);
            			String khoa = (String) request.getParameter("KhoaSV" + i);
            			svlist.add(new SINHVIEN(mssv, ten, maNhom, nienkhoa, khoa));
            			soluongtv++;
            		}
            		else {
            			break;
            		}
            	}
				if (soluongtv > 0) {
					NHOMSINHVIEN nhom = new NHOMSINHVIEN(maNhom, soluongtv);
					nhomdao.insertNhom(nhom);
					for(var i = 0; i < soluongtv; i++) {
	            		nhomdao.insertSinhVien(svlist.get(i));
	            	}
					dtdao.setTrangThai(maDT);
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

		doGet(request, response);
	}

}
