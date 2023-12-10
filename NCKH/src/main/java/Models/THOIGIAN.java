package Models;

import java.io.Serializable;
import java.sql.Date;

public class THOIGIAN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String loaiTG;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	
	public THOIGIAN() {
		super();
	}

	public THOIGIAN(String loaiTG, Date ngayBatDau, Date ngayKetThuc) {
		super();
		this.loaiTG = loaiTG;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getLoaiTG() {
		return loaiTG;
	}

	public void setLoaiTG(String loaiTG) {
		this.loaiTG = loaiTG;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	
	
}
