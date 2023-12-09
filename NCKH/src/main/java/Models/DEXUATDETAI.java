package Models;

import java.io.Serializable;

public class DEXUATDETAI implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MaDeXuat;
	private String TieuDeDeTai;
	private String MoTaDeTai;
	private String MaGV;
	private boolean TrangThai;
	private String MaDeTai;
	
	public DEXUATDETAI() {
		super();
	}
	public DEXUATDETAI(String maDeXuat, String tieuDeDeTai, String moTaDeTai, String maGV, boolean trangThai,
			String maDeTai) {
		super();
		MaDeXuat = maDeXuat;
		TieuDeDeTai = tieuDeDeTai;
		MoTaDeTai = moTaDeTai;
		MaGV = maGV;
		TrangThai = trangThai;
		MaDeTai = maDeTai;
	}
	public String getMaDeXuat() {
		return MaDeXuat;
	}
	public void setMaDeXuat(String maDeXuat) {
		MaDeXuat = maDeXuat;
	}
	public String getTieuDeDeTai() {
		return TieuDeDeTai;
	}
	public void setTieuDeDeTai(String tieuDeDeTai) {
		TieuDeDeTai = tieuDeDeTai;
	}
	public String getMoTaDeTai() {
		return MoTaDeTai;
	}
	public void setMoTaDeTai(String moTaDeTai) {
		MoTaDeTai = moTaDeTai;
	}
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public boolean isTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(boolean trangThai) {
		TrangThai = trangThai;
	}
	public String getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		MaDeTai = maDeTai;
	}
	
}
