package Models;

import java.io.Serializable;
import java.sql.Date;

public class THONGBAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MaThongBao;
	private String TenThongBao;
	private String NoiDung;
	private Date NgayGui;
	private String NguoiNhan;
	private String NguoiGui;
	
	public THONGBAO() {
		super();
	}
	public THONGBAO(String maThongBao, String tenThongBao, String noiDung, Date ngayGui, String nguoiNhan,
			String nguoiGui) {
		super();
		MaThongBao = maThongBao;
		TenThongBao = tenThongBao;
		NoiDung = noiDung;
		NgayGui = ngayGui;
		NguoiNhan = nguoiNhan;
		NguoiGui = nguoiGui;
	}
	public String getMaThongBao() {
		return MaThongBao;
	}
	public void setMaThongBao(String maThongBao) {
		MaThongBao = maThongBao;
	}
	public String getTenThongBao() {
		return TenThongBao;
	}
	public void setTenThongBao(String tenThongBao) {
		TenThongBao = tenThongBao;
	}
	public String getNoiDung() {
		return NoiDung;
	}
	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}
	public Date getNgayGui() {
		return NgayGui;
	}
	public void setNgayGui(Date ngayGui) {
		NgayGui = ngayGui;
	}
	public String getNguoiNhan() {
		return NguoiNhan;
	}
	public void setNguoiNhan(String nguoiNhan) {
		NguoiNhan = nguoiNhan;
	}
	public String getNguoiGui() {
		return NguoiGui;
	}
	public void setNguoiGui(String nguoiGui) {
		NguoiGui = nguoiGui;
	}
	
}
