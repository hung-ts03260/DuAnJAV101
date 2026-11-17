package entity;

import java.math.BigDecimal;

public class ChiTietHoaDon {
	private int maCTHD;
	private int maHD;
	private int maSPKC;
	private int soLuong;
	private BigDecimal donGia;
	private BigDecimal thanhTien;

	public ChiTietHoaDon() {
	}

	public ChiTietHoaDon(int maCTHD, int maHD, int maSPKC, int soLuong, BigDecimal donGia, BigDecimal thanhTien) {
		this.maCTHD = maCTHD;
		this.maHD = maHD;
		this.maSPKC = maSPKC;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}

	public int getMaCTHD() {
		return maCTHD;
	}

	public void setMaCTHD(int maCTHD) {
		this.maCTHD = maCTHD;
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public int getMaSPKC() {
		return maSPKC;
	}

	public void setMaSPKC(int maSPKC) {
		this.maSPKC = maSPKC;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public BigDecimal getDonGia() {
		return donGia;
	}

	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}

	public BigDecimal getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(BigDecimal thanhTien) {
		this.thanhTien = thanhTien;
	}
}
