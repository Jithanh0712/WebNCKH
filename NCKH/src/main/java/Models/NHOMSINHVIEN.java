package Models;

import java.io.Serializable;

public class NHOMSINHVIEN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MaNhom;
	private int SoLuongSV;
	
	public NHOMSINHVIEN() {
		super();
	}
	public NHOMSINHVIEN(String maNhom, int soLuongSV) {
		super();
		MaNhom = maNhom;
		SoLuongSV = soLuongSV;
	}
	public String getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(String maNhom) {
		MaNhom = maNhom;
	}
	public int getSoLuongSV() {
		return SoLuongSV;
	}
	public void setSoLuongSV(int soLuongSV) {
		SoLuongSV = soLuongSV;
	}
	
}
