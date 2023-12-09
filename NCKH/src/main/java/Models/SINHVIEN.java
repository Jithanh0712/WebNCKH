package Models;

import java.io.Serializable;

public class SINHVIEN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MSSV;
	private String HoTen;
	private String MaNhom;
	private String NienKhoa;
	private String MaKhoa;
	
	public SINHVIEN() {
		super();
	}
	public SINHVIEN(String mSSV, String hoTen, String maNhom, String nienKhoa, String maKhoa) {
		super();
		MSSV = mSSV;
		HoTen = hoTen;
		MaNhom = maNhom;
		NienKhoa = nienKhoa;
		MaKhoa = maKhoa;
	}
	public String getMSSV() {
		return MSSV;
	}
	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(String maNhom) {
		MaNhom = maNhom;
	}
	public String getNienKhoa() {
		return NienKhoa;
	}
	public void setNienKhoa(String nienKhoa) {
		NienKhoa = nienKhoa;
	}
	public String getMaKhoa() {
		return MaKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}
}
