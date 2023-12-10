package Models;

import java.io.Serializable;

public class SINHVIEN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mSSV;
	private String hoTen;
	private String maNhom;
	private String nienKhoa;
	private String maKhoa;
	
	public SINHVIEN() {
		super();
	}
	
	public SINHVIEN(String mSSV, String hoTen, String maNhom, String nienKhoa, String maKhoa) {
		super();
		this.mSSV = mSSV;
		this.hoTen = hoTen;
		this.maNhom = maNhom;
		this.nienKhoa = nienKhoa;
		this.maKhoa = maKhoa;
	}

	public String getmSSV() {
		return mSSV;
	}

	public void setmSSV(String mSSV) {
		this.mSSV = mSSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaNhom() {
		return maNhom;
	}

	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	
}
