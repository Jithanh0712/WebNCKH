package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.GiangVienDAO;
import Models.GIANGVIEN;

@WebServlet("/thongtingv")
public class ThongTinGVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ThongTinGVController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maGV = request.getParameter("magv");
        String tenGV = request.getParameter("tengv");
        String trinhDo = request.getParameter("trinhdo");
        String id = request.getParameter("id");
        String maKhoa = request.getParameter("makhoa");

        GIANGVIEN gv = new GIANGVIEN(maGV, tenGV, trinhDo, id, maKhoa);

        boolean updated = GiangVienDAO.capNhatThongTinGV(gv);

        if (updated) {
        	request.getSession().setAttribute("giangvien", gv);
        	RequestDispatcher dispatcher = request.getRequestDispatcher("HoSoGV.jsp");
			dispatcher.forward(request, response);
        } else {
          
        }
	}

}
