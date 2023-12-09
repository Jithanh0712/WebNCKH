package Models;

import java.io.Serializable;

public class NVPQLKH implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MaNV;
	private String TenNV;
	private int KinhNghiem;
	private String Email;
	private String ID;
	
	public NVPQLKH() {
		super();
	}
	public NVPQLKH(String maNV, String tenNV, int kinhNghiem, String email, String iD) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		KinhNghiem = kinhNghiem;
		Email = email;
		ID = iD;
	}
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public int getKinhNghiem() {
		return KinhNghiem;
	}
	public void setKinhNghiem(int kinhNghiem) {
		KinhNghiem = kinhNghiem;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
}
