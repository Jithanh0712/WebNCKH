package Models;

import java.io.Serializable;
import java.sql.Date;

public class THOIGIAN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String LoaiTG;
	private Date NgayBatDau;
	private Date NgayKetThuc;
	
	public THOIGIAN() {
		super();
	}
	public THOIGIAN(String loaiTG, Date ngayBatDau, Date ngayKetThuc) {
		super();
		LoaiTG = loaiTG;
		NgayBatDau = ngayBatDau;
		NgayKetThuc = ngayKetThuc;
	}
	public String getLoaiTG() {
		return LoaiTG;
	}
	public void setLoaiTG(String loaiTG) {
		LoaiTG = loaiTG;
	}
	public Date getNgayBatDau() {
		return NgayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return NgayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	
}
