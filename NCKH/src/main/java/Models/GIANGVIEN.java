package Models;

import java.io.Serializable;

public class GIANGVIEN implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MaGV;
	private String TenGV;
	private String TrinhDo;
	private String ID;
	private String MaKhoa;
	
	public GIANGVIEN() {
		super();
	}
	public GIANGVIEN(String maGV, String tenGV, String trinhDo, String iD, String maKhoa) {
		super();
		MaGV = maGV;
		TenGV = tenGV;
		TrinhDo = trinhDo;
		ID = iD;
		MaKhoa = maKhoa;
	}
	public String getMaGV() {
		return MaGV;
	}
	public void setMaGV(String maGV) {
		MaGV = maGV;
	}
	public String getTenGV() {
		return TenGV;
	}
	public void setTenGV(String tenGV) {
		TenGV = tenGV;
	}
	public String getTrinhDo() {
		return TrinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		TrinhDo = trinhDo;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getMaKhoa() {
		return MaKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		MaKhoa = maKhoa;
	}
	
}
