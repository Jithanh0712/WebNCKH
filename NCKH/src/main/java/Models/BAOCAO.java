package Models;

import java.io.Serializable;
import java.sql.Date;

public class BAOCAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String MaBaoCao;
	private String MaDeTai;
	private Date NgayNop;
	private String LoaiBaoCao;
	private String FileURL;
	
	public BAOCAO() {
		super();
	}
	public BAOCAO(String maBaoCao, String maDeTai, Date ngayNop, String loaiBaoCao, String fileURL) {
		super();
		MaBaoCao = maBaoCao;
		MaDeTai = maDeTai;
		NgayNop = ngayNop;
		LoaiBaoCao = loaiBaoCao;
		FileURL = fileURL;
	}
	public String getMaBaoCao() {
		return MaBaoCao;
	}
	public void setMaBaoCao(String maBaoCao) {
		MaBaoCao = maBaoCao;
	}
	public String getMaDeTai() {
		return MaDeTai;
	}
	public void setMaDeTai(String maDeTai) {
		MaDeTai = maDeTai;
	}
	public Date getNgayNop() {
		return NgayNop;
	}
	public void setNgayNop(Date ngayNop) {
		NgayNop = ngayNop;
	}
	public String getLoaiBaoCao() {
		return LoaiBaoCao;
	}
	public void setLoaiBaoCao(String loaiBaoCao) {
		LoaiBaoCao = loaiBaoCao;
	}
	public String getFileURL() {
		return FileURL;
	}
	public void setFileURL(String fileURL) {
		FileURL = fileURL;
	}
}
