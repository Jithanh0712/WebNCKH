package Models;

import java.io.Serializable;

public class TAIKHOAN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String IDDangNhap;
	private String MatKhau;
	private String ROLE_User;
	
	public TAIKHOAN() {
		super();
	}
	public TAIKHOAN(String iDDangNhap, String matKhau, String rOLE_User) {
		super();
		IDDangNhap = iDDangNhap;
		MatKhau = matKhau;
		ROLE_User = rOLE_User;
	}
	public String getIDDangNhap() {
		return IDDangNhap;
	}
	public void setIDDangNhap(String iDDangNhap) {
		IDDangNhap = iDDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getROLE_User() {
		return ROLE_User;
	}
	public void setROLE_User(String rOLE_User) {
		ROLE_User = rOLE_User;
	}
	
}
