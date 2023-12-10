package Models;

import java.io.Serializable;

public class NVPQLKH implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maNV;
	private String tenNV;
	private int kinhNghiem;
	private String email;
	private String iD;
	
	public NVPQLKH() {
		super();
	}
	
	public NVPQLKH(String maNV, String tenNV, int kinhNghiem, String email, String iD) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.kinhNghiem = kinhNghiem;
		this.email = email;
		this.iD = iD;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getKinhNghiem() {
		return kinhNghiem;
	}

	public void setKinhNghiem(int kinhNghiem) {
		this.kinhNghiem = kinhNghiem;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}
	
}
