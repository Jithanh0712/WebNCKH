package Models;

import java.io.Serializable;

public class DEXUATDETAI implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maDeXuat;
	private String tieuDeDeTai;
	private String moTaDeTai;
	private String maGV;
	private boolean trangThai;
	private String maDeTai;
	
	public DEXUATDETAI() {
		super();
	}
	
	public DEXUATDETAI(String maDeXuat, String tieuDeDeTai, String moTaDeTai, String maGV, boolean trangThai,
			String fileurl, String maDeTai) {
		super();
		this.maDeXuat = maDeXuat;
		this.tieuDeDeTai = tieuDeDeTai;
		this.moTaDeTai = moTaDeTai;
		this.maGV = maGV;
		this.trangThai = trangThai;
		this.maDeTai = maDeTai;
	}

	public String getMaDeTai() {
		return maDeTai;
	}

	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}
	
	public String getMaDeXuat() {
		return maDeXuat;
	}

	public void setMaDeXuat(String maDeXuat) {
		this.maDeXuat = maDeXuat;
	}

	public String getTieuDeDeTai() {
		return tieuDeDeTai;
	}

	public void setTieuDeDeTai(String tieuDeDeTai) {
		this.tieuDeDeTai = tieuDeDeTai;
	}

	public String getMoTaDeTai() {
		return moTaDeTai;
	}

	public void setMoTaDeTai(String moTaDeTai) {
		this.moTaDeTai = moTaDeTai;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
}
