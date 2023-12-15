package Models;

import java.io.Serializable;
import java.sql.Date;

public class BAOCAO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maBaoCao;
	private String maDeTai;
	private Date ngayNop;
	private String loaiBaoCao;
	private String fileURL;
	
	public BAOCAO() {
		super();
	}
	
	public BAOCAO(String loaiBaoCao, Date ngayNop, String fileURL) {
		super();
		this.ngayNop = ngayNop;
		this.loaiBaoCao = loaiBaoCao;
		this.fileURL = fileURL;
	}
	
	public BAOCAO(String maBaoCao, String maDeTai, Date ngayNop, String loaiBaoCao, String fileURL) {
		super();
		this.maBaoCao = maBaoCao;
		this.maDeTai = maDeTai;
		this.ngayNop = ngayNop;
		this.loaiBaoCao = loaiBaoCao;
		this.fileURL = fileURL;
	}

	public String getMaBaoCao() {
		return maBaoCao;
	}

	public void setMaBaoCao(String maBaoCao) {
		this.maBaoCao = maBaoCao;
	}

	public String getMaDeTai() {
		return maDeTai;
	}

	public void setMaDeTai(String maDeTai) {
		this.maDeTai = maDeTai;
	}

	public Date getNgayNop() {
		return ngayNop;
	}

	public void setNgayNop(Date ngayNop) {
		this.ngayNop = ngayNop;
	}

	public String getLoaiBaoCao() {
		return loaiBaoCao;
	}

	public void setLoaiBaoCao(String loaiBaoCao) {
		this.loaiBaoCao = loaiBaoCao;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}
}
