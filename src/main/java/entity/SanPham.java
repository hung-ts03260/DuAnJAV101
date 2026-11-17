package entity;

import java.math.BigDecimal;

public class SanPham {
	private int maSP;
	private int maDM;
	private String tenSP;
	private String thuongHieu;
	private BigDecimal giaBan;
	private String hinhAnh;
	private boolean trangThai;

	public SanPham() {
	}

	public SanPham(int maSP, int maDM, String tenSP, String thuongHieu, BigDecimal giaBan, String hinhAnh,
			boolean trangThai) {
		this.maSP = maSP;
		this.maDM = maDM;
		this.tenSP = tenSP;
		this.thuongHieu = thuongHieu;
		this.giaBan = giaBan;
		this.hinhAnh = hinhAnh;
		this.trangThai = trangThai;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getMaDM() {
		return maDM;
	}

	public void setMaDM(int maDM) {
		this.maDM = maDM;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getThuongHieu() {
		return thuongHieu;
	}

	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}

	public BigDecimal getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(BigDecimal giaBan) {
		this.giaBan = giaBan;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

}
