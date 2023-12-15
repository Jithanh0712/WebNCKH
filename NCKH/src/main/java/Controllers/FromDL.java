package Controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BaoCaoDAO;
import DAO.GiangVienDAO;
import DAO.ThoiGianDAO;
import Models.THOIGIAN;
import Models.THONGBAO;
import Models.BAOCAO;
import Models.GIANGVIEN;


@WebServlet("/FromDL/*")
public class FromDL extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ThoiGianDAO tgDAO;
    private GiangVienDAO gvdao;
    private BaoCaoDAO bcdao;
	
    public FromDL() {
        super();

    }


	public void init()  {
		tgDAO = new ThoiGianDAO();
		gvdao = new GiangVienDAO();
		bcdao = new BaoCaoDAO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String IDDangNhap = (String) session.getAttribute("IDDangNhap");
		
		String action = request.getPathInfo();
		System.out.println("action error :"+ action );
		try {
			String MaDT = null;
			if(action.contains("/redirect")) {
				MaDT = (String) request.getParameter("madetai");
				session.setAttribute("madetai", MaDT);
			}
			else {
				MaDT = (String) session.getAttribute("madetai");
			}
			String FileURL = (String) session.getAttribute("filename");
			THOIGIAN tg = tgDAO.layThoiGianBaoCao();
			request.setAttribute("thoigian", tg);
			GIANGVIEN gv = gvdao.layThongTinGV(IDDangNhap);
			List<THONGBAO> thongbaos = bcdao.laycacthongbao(gv.getMaGV());
			String Loai = null;
			for(THONGBAO tb: thongbaos){
				if(tb.getTenThongBao().contains("Báo cáo định kỳ")) {
					request.setAttribute("thongbao", tb);
					Loai = "BCDK";
					break;
				}
				else if(tb.getTenThongBao().contains("Báo cáo nghiệm thu")){
					request.setAttribute("thongbao", tb);
					Loai = "BCNT";
					break;
				}
			}
			if(action.contains("/redirect")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/FromNopDL.jsp");
				dispatcher.forward(request, response);
			}
			if(action.contains("/nopbaocao")) {
				String MaBC = bcdao.GenerateMaBaoCao();
				Date ngaynop = Date.valueOf(LocalDate.now());
				bcdao.insertbaocao(new BAOCAO(MaBC, MaDT, ngaynop, Loai, FileURL));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/listDSDT_GV");
				dispatcher.forward(request, response);
			}
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
