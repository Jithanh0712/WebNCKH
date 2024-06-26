package Models;

import java.io.Serializable;
import java.sql.Date;

public class DETAI implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maDeTai;
	private String tieuDe;
	private String moTa;
	private boolean trangThai;
	private int kinhPhi;
	private Date ngayDKTC;
	private String maNV;
	
	public DETAI() {
		super();
	}
	
	public DETAI(String maDeTai, String tieuDe) {
		super();
		this.maDeTai = maDeTai;
		this.tieuDe = tieuDe;
	}
	
	public DETAI(String maDeTai, String tieuDe, String moTa, boolean trangThai, int kinhPhi, String maNV) {
		super();
		this.maDeTai = maDeTai;
		this.tieuDe = tieuDe;
		this.moTa = moTa;
		this.trangThai = trangThai;
		this.kinhPhi = kinhPhi;
		this.maNV = maNV;
	}

	public DETAI(String maDeTai, String tieuDe, String moTa, boolean trangThai, int kinhPhi, Date ngayDKTC, String maNV) {
		super();
		this.maDeTai = maDeTai;
		this.tieuDe = tieuDe;
		this.moTa = moTa;
		this.trangThai = trangThai;
		this.kinhPhi = kinhPhi;
		this.ngayDKTC = ngayDKTC;
		this.maNV = maNV;
	}

	public String getMaDeTai() {
		return maDeTai;
	}

	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public boolean getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	public int getKinhPhi() {
		return kinhPhi;
	}

	public void setKinhPhi(int kinhPhi) {
		this.kinhPhi = kinhPhi;
	}

	public Date getNgayDKTC() {
		return ngayDKTC;
	}

	public void setNgayDKTC(Date ngayDKTC) {
		this.ngayDKTC = ngayDKTC;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
}
