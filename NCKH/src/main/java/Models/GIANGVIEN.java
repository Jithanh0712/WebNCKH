package Models;

import java.io.Serializable;

public class GIANGVIEN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maGV;
	private String tenGV;
	private String trinhDo;
	private String iD;
	private String maKhoa;
	
	public GIANGVIEN() {
		super();
	}
	
	public GIANGVIEN(String maGV, String tenGV, String trinhDo, String iD, String maKhoa) {
		super();
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.trinhDo = trinhDo;
		this.iD = iD;
		this.maKhoa = maKhoa;
	}

	public String getMaGV() {
		return maGV;
	}

	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	
	
}
