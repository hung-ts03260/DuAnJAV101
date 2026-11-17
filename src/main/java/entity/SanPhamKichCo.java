package entity;

import java.sql.Timestamp;

public class SanPhamKichCo {
	private int maSPKC;
	private int maSP;
	private int maKichCo;
	private int soLuongTon;
	private Timestamp ngayCapNhat;
	private boolean trangThai;

	public SanPhamKichCo() {
	}

	public SanPhamKichCo(int maSPKC, int maSP, int maKichCo, int soLuongTon, Timestamp ngayCapNhat, boolean trangThai) {
		this.maSPKC = maSPKC;
		this.maSP = maSP;
		this.maKichCo = maKichCo;
		this.soLuongTon = soLuongTon;
		this.ngayCapNhat = ngayCapNhat;
		this.trangThai = trangThai;
	}

	public int getMaSPKC() {
		return maSPKC;
	}

	public void setMaSPKC(int maSPKC) {
		this.maSPKC = maSPKC;
	}

	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getMaKichCo() {
		return maKichCo;
	}

	public void setMaKichCo(int maKichCo) {
		this.maKichCo = maKichCo;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public Timestamp getNgayCapNhat() {
		return ngayCapNhat;
	}

	public void setNgayCapNhat(Timestamp ngayCapNhat) {
		this.ngayCapNhat = ngayCapNhat;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
}
