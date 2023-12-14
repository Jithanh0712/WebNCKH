package Models;

import java.io.Serializable;

public class DANGKY implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maDK;
	private String maDeTai;
	private String maGV;
	private String maNhom;
	private boolean trangThai;
	
	public DANGKY() {
		super();
	}
	
	public DANGKY(String maDK, boolean trangThai) {
		super();
		this.maDK = maDK;
		this.trangThai = trangThai;
	}

	public DANGKY(String maDK, String maDeTai, String maGV, String maNhom, boolean trangThai) {
		super();
		this.maDK = maDK;
		this.maDeTai = maDeTai;
		this.maGV = maGV;
		this.maNhom = maNhom;
		this.trangThai = trangThai;
	}
	
	public DANGKY(String maDK, String maDeTai, String maGV, String maNhom) {
		super();
		this.maDK = maDK;
		this.maDeTai = maDeTai;
		this.maGV = maGV;
		this.maNhom = maNhom;
	}

	public String getMaDK() {
		return maDK;
	}

	public void setMaDK(String maDK) {
		this.maDK = maDK;
	}

	public String getMaDeTai() {
		return maDeTai;
	}

	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getMaNhom() {
		return maNhom;
	}

	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
}
