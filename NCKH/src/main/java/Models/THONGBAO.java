package Models;

import java.io.Serializable;
import java.sql.Date;

public class THONGBAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maThongBao;
	private String tenThongBao;
	private String noiDung;
	private Date ngayGui;
	private String nguoiNhan;
	private String nguoiGui;
	
	public THONGBAO() {
		super();
	}

	public THONGBAO(String maThongBao, String tenThongBao, String noiDung, Date ngayGui, String nguoiNhan,
			String nguoiGui) {
		super();
		this.maThongBao = maThongBao;
		this.tenThongBao = tenThongBao;
		this.noiDung = noiDung;
		this.ngayGui = ngayGui;
		this.nguoiNhan = nguoiNhan;
		this.nguoiGui = nguoiGui;
	}

	public String getMaThongBao() {
		return maThongBao;
	}

	public void setMaThongBao(String maThongBao) {
		this.maThongBao = maThongBao;
	}

	public String getTenThongBao() {
		return tenThongBao;
	}

	public void setTenThongBao(String tenThongBao) {
		this.tenThongBao = tenThongBao;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getNgayGui() {
		return ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}

	public String getNguoiNhan() {
		return nguoiNhan;
	}

	public void setNguoiNhan(String nguoiNhan) {
		this.nguoiNhan = nguoiNhan;
	}

	public String getNguoiGui() {
		return nguoiGui;
	}

	public void setNguoiGui(String nguoiGui) {
		this.nguoiGui = nguoiGui;
	}
	
	
}
