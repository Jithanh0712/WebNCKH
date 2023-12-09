package Models;

import java.io.Serializable;

public class DANGKY implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MaDK;
	private String MaDeTai;
	private String MaGV;
	private String MaNhom;
	private boolean TrangThai;
	
	public DANGKY() {
		super();
	}
	public DANGKY(String maDK, String maDeTai, String maGV, String maNhom, boolean trangThai) {
		super();
		MaDK = maDK;
		MaDeTai = maDeTai;
		MaGV = maGV;
		MaNhom = maNhom;
		TrangThai = trangThai;
	}
	public String getMaDK() {
		return MaDK;
	}
	public void setMaDK(String maDK) {
		MaDK = maDK;
	}
	public String getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		MaDeTai = maDeTai;
	}
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public String getMaNhom() {
		return MaNhom;
	}
	public void setMaNhom(String maNhom) {
		MaNhom = maNhom;
	}
	public boolean isTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}
	
}
