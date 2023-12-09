package Models;

import java.io.Serializable;
import java.sql.Date;

public class DETAI implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MaDeTai;
	private String TieuDe;
	private String MoTa;
	private String TrangThai;
	private int KinhPhi;
	private Date NgayDKTC;
	private String MaNV;
	
	public DETAI() {
		super();
	}
	public DETAI(String maDeTai, String tieuDe, String moTa, String trangThai, int kinhPhi, Date ngayDKTC,
			String maNV) {
		super();
		MaDeTai = maDeTai;
		TieuDe = tieuDe;
		MoTa = moTa;
		TrangThai = trangThai;
		KinhPhi = kinhPhi;
		NgayDKTC = ngayDKTC;
		MaNV = maNV;
	}
	public String getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		MaDeTai = maDeTai;
	}
	public String getTieuDe() {
		return TieuDe;
	}
	public void setTieuDe(String tieuDe) {
		TieuDe = tieuDe;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}
	public int getKinhPhi() {
		return KinhPhi;
	}
	public void setKinhPhi(int kinhPhi) {
		KinhPhi = kinhPhi;
	}
	public Date getNgayDKTC() {
		return NgayDKTC;
	}
	public void setNgayDKTC(Date ngayDKTC) {
		NgayDKTC = ngayDKTC;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	
}
