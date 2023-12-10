package Models;

import java.io.Serializable;

public class NHOMSINHVIEN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maNhom;
	private int soLuongSV;
	
	public NHOMSINHVIEN() {
		super();
	}
	
	public NHOMSINHVIEN(String maNhom, int soLuongSV) {
		super();
		this.maNhom = maNhom;
		this.soLuongSV = soLuongSV;
	}

	public String getMaNhom() {
		return maNhom;
	}

	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}

	public int getSoLuongSV() {
		return soLuongSV;
	}

	public void setSoLuongSV(int soLuongSV) {
		this.soLuongSV = soLuongSV;
	}
	
	
}
