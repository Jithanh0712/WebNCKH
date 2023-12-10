package Models;

import java.io.Serializable;

public class TAIKHOAN implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String iDDangNhap;
	private String matKhau;
	private String rOLE_User;
	
	public TAIKHOAN() {
		super();
	}

	public TAIKHOAN(String iDDangNhap, String matKhau, String rOLE_User) {
		super();
		this.iDDangNhap = iDDangNhap;
		this.matKhau = matKhau;
		this.rOLE_User = rOLE_User;
	}

	public String getiDDangNhap() {
		return iDDangNhap;
	}

	public void setiDDangNhap(String iDDangNhap) {
		this.iDDangNhap = iDDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getrOLE_User() {
		return rOLE_User;
	}

	public void setrOLE_User(String rOLE_User) {
		this.rOLE_User = rOLE_User;
	}
}
