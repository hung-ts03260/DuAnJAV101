package entity;

import java.sql.Date;

public class DanhMuc {
	private int maDM;
	private String tenDM;
	private String moTa;
	private Date ngayTao;
	private boolean trangThai;

	public DanhMuc() {
	}

	public DanhMuc(int maDM, String tenDM, String moTa, Date ngayTao, boolean trangThai) {
		this.maDM = maDM;
		this.tenDM = tenDM;
		this.moTa = moTa;
		this.ngayTao = ngayTao;
		this.trangThai = trangThai;
	}

	public int getMaDM() {
		return maDM;
	}

	public void setMaDM(int maDM) {
		this.maDM = maDM;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
}
